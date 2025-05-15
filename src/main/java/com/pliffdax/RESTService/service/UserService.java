package com.pliffdax.RESTService.service;

import com.pliffdax.RESTService.dto.*;
import com.pliffdax.RESTService.entity.Ban;
import com.pliffdax.RESTService.entity.Member;
import com.pliffdax.RESTService.entity.Role;
import com.pliffdax.RESTService.entity.User;
import com.pliffdax.RESTService.exeption.*;
import com.pliffdax.RESTService.repository.BanRepository;
import com.pliffdax.RESTService.repository.MemberRepository;
import com.pliffdax.RESTService.repository.RoleRepository;
import com.pliffdax.RESTService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;

    private final BanRepository banRepo;

    private final MemberRepository memberRepo;

    private final RoleRepository roleRepo;

    @Transactional
    public void registerNewUser(RegisterRequest userData) {
        validateUser(userData.username(), userData.password(), userData.email());
        User user = new User();
        user.setName(userData.username());
        user.setPassword(userData.password());
        user.setEmail(userData.email());
        user.setAvatar("images/user.png");
        user.setStatus("Active");
        userRepo.save(user);

        Role role = roleRepo.findByName("USER")
                .orElseThrow(() -> new RoleNotFoundException("Role not found."));

        assignRoleToUser(user, role);
    }

    public LoginResponse loginUser(LoginRequest loginRequest) {
        User user = userRepo.findByName(loginRequest.username())
                .orElseThrow(() -> new InvalidUsernameException("No user with this name exists."));
        if (!loginRequest.password().equals(user.getPassword())) {
            throw new InvalidPasswordException("Wrong password.");
        }
        if (banRepo.existsByUserIdAndUntilDateAfter(user.getId(), LocalDateTime.now())) {
            throw new UserBannedException("User banned!");
        }
        return new LoginResponse(user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAvatar(),
                user.getStatus()
        );
    }

    public void editUserInfo(Integer editorId, Integer targetId, EditUserDataRequest request) {
        if (!isAdmin(editorId) && !editorId.equals(targetId)) {
            throw new InsufficientPermissionsException("You do not have permission to edit user.");
        }
        User user = userRepo.findById(targetId).orElseThrow(() -> new UserNotFoundException("User not found."));
        validateUser(request.username(), request.password(), request.email(), Optional.of(user.getName()));
        user.setName(request.username());
        user.setPassword(request.password());
        user.setEmail(request.email());
        user.setAvatar(request.avatar());
        user.setStatus(request.status());
        userRepo.save(user);
    }

    public void deleteUserInfo(Integer editorId, Integer targetId) {
        if (!isAdmin(editorId) && !editorId.equals(targetId)) {
            throw new InsufficientPermissionsException("You do not have permission to edit user.");
        }
        User user = userRepo.findById(targetId).orElseThrow(() -> new UserNotFoundException("User not found."));
        userRepo.delete(user);
    }

    public void addUserRole(Integer adminId, Integer userId, String newRole) {
        if (!isAdmin(adminId)) {
            throw new InsufficientPermissionsException("You do not have permission to add new role to user.");
        }
        if (memberRepo.existsByUserIdAndRoleName(userId, newRole))
        {
            throw new InvalidRoleException("User already has a role named " + newRole + ".");
        }
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found."));
        Role role = roleRepo.findByName(newRole).orElseThrow(() -> new RoleNotFoundException("Role not found."));
        assignRoleToUser(user, role);
    }

    public List<String> getUserRoleNames(Integer userId) {
        if (!userRepo.existsById(userId)) {
            throw new UserNotFoundException("User not found");
        }
        return memberRepo.findRoleNamesByUserId(userId);
    }

    public void deleteUserRole(Integer adminId, Integer userId, String oldRole) {
        if (!isAdmin(adminId)) {
            throw new InsufficientPermissionsException("You do not have permission to delete role of user.");
        }
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found."));
        Role role = roleRepo.findByName(oldRole).orElseThrow(() -> new RoleNotFoundException("Role not found."));
        Member member = memberRepo.findByUserIdAndRoleName(user.getId(), role.getName())
                .orElseThrow(() -> new MemberNotFoundException("Member not found."));
        memberRepo.delete(member);
    }

    public void banUser(Integer adminId, BanUserRequest request) {
        if (!isAdmin(adminId)) {
            throw new InsufficientPermissionsException("You do not have permission to ban user.");
        }
        User user = userRepo.findByName(request.username()).orElseThrow(() -> new UserNotFoundException("User not found."));
        if (banRepo.existsByUserIdAndUntilDateAfter(user.getId(), LocalDateTime.now())) {
            throw new UserBannedException("User already banned!");
        }

        Ban ban = new Ban();
        ban.setUser(user);
        ban.setReason(request.reason());
        ban.setUntilDate(request.untilDate());
        banRepo.save(ban);
    }

    public void unbanUser(Integer adminId, Integer userId) {
        if (!isAdmin(adminId)) {
            throw new InsufficientPermissionsException("You do not have permission to unban user.");
        }
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found."));
        Ban ban = banRepo.findByUserIdAndUntilDateAfter(user.getId(), LocalDateTime.now())
                .orElseThrow(() -> new UserBannedException("User already unbanned!"));
        ban.setUntilDate(LocalDateTime.now().minusSeconds(1));
        banRepo.save(ban);
    }

    private void validateUser(String username, String password, String email) {
        validateUser(username, password, email, Optional.empty());
    }

    private void validateUser(String username, String password, String email, Optional<String> oldName) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullUsernameException("Username is required.");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new NullPasswordException("Password is required.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new NullEmailException("Email is required.");
        }
        if (!email.contains("@")) {
            throw new WrongEmailFormatException("Email format is incorrect.");
        }
        if (oldName.isPresent()) {
            if (userRepo.existsByName(username) && !oldName.get().equals(username)) {
                throw new UserAlreadyExistsException("User with this name already exists.");
            }
        } else {
            if (userRepo.existsByName(username)) {
                throw new UserAlreadyExistsException("User with this name already exists.");
            }
        }
        if (password.length() < 6) {
            throw new WeakPasswordException("Password must be at least 6 characters.");
        }
    }

    private boolean isAdmin(Integer userId) {
        return memberRepo.existsByUserIdAndRoleName(userId, "ADMIN");
    }

    private void assignRoleToUser(User user, Role role) {
        Member member = new Member();
        member.setUser(user);
        member.setRole(role);
        memberRepo.save(member);
    }
}
