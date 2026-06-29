package com.aplorax.controller;

import com.aplorax.model.User;
import com.aplorax.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        String token = userService.login(email, password);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PutMapping("/profile")
    public ResponseEntity<User> updateProfile(@RequestBody User profileData,
            Authentication authentication) {
        String email = authentication.getName();
        User updatedUser = userService.updateProfile(email, profileData);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/profile/metrics")
    public ResponseEntity<Map<String, Double>> getMetrics(Authentication authentication) {
        String email = authentication.getName();
        User user = userService.findByEmail(email);
        double tmb = userService.calculateTMB(user);
        double tdee = userService.calculateTDEE(user);
        double goal = userService.calculateCalorieGoal(user);
        return ResponseEntity.ok(Map.of(
                "tmb", Math.round(tmb * 10.0) / 10.0,
                "tdee", Math.round(tdee * 10.0) / 10.0,
                "calorieGoal", Math.round(goal * 10.0) / 10.0));
    }

}