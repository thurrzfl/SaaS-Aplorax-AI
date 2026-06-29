package com.aplorax.service;

import com.aplorax.config.JwtUtil;
import com.aplorax.model.User;
import com.aplorax.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email já cadastrado!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("Email não encontrado!");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Senha incorreta!");
        }

        return jwtUtil.generateToken(email);
    }

    public User updateProfile(String email, User profileData) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("Usuário não encontrado!");
        }

        user.setWeight(profileData.getWeight());
        user.setHeight(profileData.getHeight());
        user.setAge(profileData.getAge());
        user.setGender(profileData.getGender());
        user.setGoal(profileData.getGoal());
        user.setActivityLevel(profileData.getActivityLevel());

        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public double calculateTMB(User user) {
        if (user.getGender() == User.Gender.MALE) {
            return (10 * user.getWeight())
                    + (6.25 * user.getHeight())
                    - (5 * user.getAge())
                    + 5;
        } else {
            return (10 * user.getWeight())
                    + (6.25 * user.getHeight())
                    - (5 * user.getAge())
                    - 161;
        }
    }

    public double calculateTDEE(User user) {
        double tmb = calculateTMB(user);
        double factor = switch (user.getActivityLevel()) {
            case SEDENTARY -> 1.2;
            case LIGHT -> 1.375;
            case MODERATE -> 1.55;
            case VERY_ACTIVE -> 1.725;
            case ATHLETE -> 1.9;
        };
        return tmb * factor;
    }

    public double calculateCalorieGoal(User user) {
        double tdee = calculateTDEE(user);
        return switch (user.getGoal()) {
            case LOSE_WEIGHT -> tdee - 400;
            case GAIN_MUSCLE -> tdee + 300;
            case MAINTAIN -> tdee;
        };
    }

}