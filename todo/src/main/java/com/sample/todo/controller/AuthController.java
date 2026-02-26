package com.sample.todo.controller;


import com.sample.todo.model.User;
import com.sample.todo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class AuthController {
    private final UserService userService;



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // You should add DTO here later for security!
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // 1. Verify user exists
        // 2. Check password
        // 3. Generate Token
        String token = jwtUtil.generateToken(loginRequest.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
