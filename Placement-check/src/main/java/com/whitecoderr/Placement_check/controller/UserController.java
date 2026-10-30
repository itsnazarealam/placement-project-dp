package com.whitecoderr.Placement_check.controller;

import com.whitecoderr.Placement_check.dto.LoginResponse;
import com.whitecoderr.Placement_check.dto.UserResponse;
import com.whitecoderr.Placement_check.model.User;
import com.whitecoderr.Placement_check.repository.UserRepository;
import com.whitecoderr.Placement_check.security.JwtUtil;
import com.whitecoderr.Placement_check.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserController(
            UserService userService,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (user.getUserMail() == null || user.getUserMail().isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email is required"));
        }
        if (userRepository.findByUserMail(user.getUserMail()) != null) {
            return ResponseEntity.status(409).body(Map.of("message", "Email already registered"));
        }
        User saved = userService.registerUser(user);
        return ResponseEntity.ok(toUserResponse(saved));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        String email = loginRequest.getUserMail();
        System.out.println(email);
        User user = userRepository.findByUserMail(loginRequest.getUserMail());
        System.out.println(user);
        if (user == null) {
            return ResponseEntity.status(404).body(Map.of("message", "User not found"));
        }
        if (!userService.verifyPassword(loginRequest.getUserPassword(), user.getUserPassword())) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid password"));
        }
        String token = jwtUtil.generateToken(user.getUserMail(), user.getRole());
        return ResponseEntity.ok(new LoginResponse(
                token,
                user.getRole(),
                user.getUsername(),
                user.getUserId(),
                user.getUserMail()
        ));
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication authentication) {
        if (authentication == null || authentication.getName() == null) {
            return ResponseEntity.status(401).body(Map.of("message", "Unauthorized"));
        }
        User user = userRepository.findByUserMail(authentication.getName());
        if (user == null) {
            return ResponseEntity.status(404).body(Map.of("message", "User not found"));
        }
        return ResponseEntity.ok(toUserResponse(user));
    }

    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword(
            @RequestParam String userMail,
            @RequestParam String newPassword) {
        User user = userRepository.findByUserMail(userMail);
        if (user == null) {
            return ResponseEntity.status(404).body(Map.of("message", "User not found"));
        }
        user.setUserPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        return ResponseEntity.ok(Map.of("message", "Password reset successful!"));
    }

    private static UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getUserMail(),
                user.getRole()
        );
    }
}
