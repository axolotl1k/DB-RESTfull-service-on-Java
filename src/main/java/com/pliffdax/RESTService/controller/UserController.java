package com.pliffdax.RESTService.controller;

import com.pliffdax.RESTService.dto.*;
import com.pliffdax.RESTService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserInfo>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
        userService.registerNewUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("201", "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseWithData> login(@RequestBody LoginRequest request) {
        UserInfo loginData = userService.loginUser(request);
        return ResponseEntity.ok(
                new ApiResponseWithData("200", "Login successful", loginData)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editUser(@PathVariable Integer id,
                                         @RequestParam Integer editorId,
                                         @RequestBody EditUserDataRequest request) {
        userService.editUserInfo(editorId, id, request);
        return ResponseEntity.ok(new ApiResponse("200", "User edited successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id,
                                           @RequestParam Integer editorId) {
        userService.deleteUserInfo(editorId, id);
        return ResponseEntity.ok(new ApiResponse("200", "User deleted successfully"));
    }

    @PostMapping("/{id}/roles")
    public ResponseEntity<ApiResponse> addUserRole(@PathVariable Integer id,
                                                   @RequestParam Integer adminId,
                                                   @RequestParam String role) {
        userService.addUserRole(adminId, id, role);
        return ResponseEntity.ok(new ApiResponse("200", "Role added to user"));
    }

    @GetMapping("/{id}/roles")
    public ResponseEntity<ApiResponseWithData> getUserRoles(@PathVariable Integer id) {
        List<String> roles = userService.getUserRoleNames(id);
        return ResponseEntity.ok(new ApiResponseWithData("200", "User roles retrieved", roles));
    }

    @DeleteMapping("/{id}/roles")
    public ResponseEntity<ApiResponse> deleteUserRole(@PathVariable Integer id,
                                                      @RequestParam Integer adminId,
                                                      @RequestParam String role) {
        userService.deleteUserRole(adminId, id, role);
        return ResponseEntity.ok(new ApiResponse("200", "Role removed from user"));
    }

    @PostMapping("/ban")
    public ResponseEntity<ApiResponse> banUser(@RequestParam Integer adminId,
                                               @RequestBody BanUserRequest request) {
        userService.banUser(adminId, request);
        return ResponseEntity.ok(new ApiResponse("200", "User banned"));
    }

    @PostMapping("/unban")
    public ResponseEntity<ApiResponse> unbanUser(@RequestParam Integer adminId,
                                                 @RequestParam Integer userId) {
        userService.unbanUser(adminId, userId);
        return ResponseEntity.ok(new ApiResponse("200", "User unbanned"));
    }
}
