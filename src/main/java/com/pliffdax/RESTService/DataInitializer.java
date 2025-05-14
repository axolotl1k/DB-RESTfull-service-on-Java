package com.pliffdax.RESTService;

import com.pliffdax.RESTService.entity.Member;
import com.pliffdax.RESTService.entity.Role;
import com.pliffdax.RESTService.entity.User;
import com.pliffdax.RESTService.repository.MemberRepository;
import com.pliffdax.RESTService.repository.RoleRepository;
import com.pliffdax.RESTService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {
    private final RoleRepository roleRepo;
    private final UserRepository userRepo;
    private final MemberRepository memberRepo;

    @Override
    public void run(String... args) {
        createRoleIfNotExists("USER", "Basic user");
        Role adminRole = createRoleIfNotExists("ADMIN", "Administrator");

        if (!userRepo.existsByName("admin")) {
            User admin = new User();
            admin.setName("admin");
            admin.setEmail("admin@admin.com");
            admin.setPassword("admin123");
            admin.setStatus("Active");
            admin.setAvatar("images/admin.png");
            userRepo.save(admin);

            Member member = new Member();
            member.setUser(admin);
            member.setRole(adminRole);
            memberRepo.save(member);
        }
    }

    private Role createRoleIfNotExists(String name, String description) {
        return roleRepo.findByName(name).orElseGet(() -> {
            Role role = new Role();
            role.setName(name);
            role.setDescription(description);
            return roleRepo.save(role);
        });
    }
}
