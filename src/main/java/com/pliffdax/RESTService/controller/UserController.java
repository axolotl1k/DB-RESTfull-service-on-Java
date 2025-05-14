package com.pliffdax.RESTService.controller;

import com.pliffdax.RESTService.dto.*;
import com.pliffdax.RESTService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest request) {
        userService.registerNewUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.loginUser(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editUser(@PathVariable Integer id,
                                         @RequestParam Integer editorId,
                                         @RequestBody EditUserDataRequest request) {
        userService.editUserInfo(editorId, id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id,
                                           @RequestParam Integer editorId) {
        userService.deleteUserInfo(editorId, id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/roles")
    public ResponseEntity<Void> addUserRole(@PathVariable Integer id,
                                            @RequestParam Integer adminId,
                                            @RequestParam String role) {
        userService.addUserRole(adminId, id, role);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/roles")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Integer id,
                                               @RequestParam Integer adminId,
                                               @RequestParam String role) {
        userService.deleteUserRole(adminId, id, role);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/ban")
    public ResponseEntity<Void> banUser(@RequestParam Integer adminId,
                                        @RequestBody BanUserRequest request) {
        userService.banUser(adminId, request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/unban")
    public ResponseEntity<Void> unbanUser(@RequestParam Integer adminId,
                                          @RequestParam Integer userId) {
        userService.unbanUser(adminId, userId);
        return ResponseEntity.ok().build();
    }
}
