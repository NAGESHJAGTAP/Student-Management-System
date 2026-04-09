package com.example.studentapp.service.impl;

import com.example.studentapp.dto.LoginDTO;
import com.example.studentapp.model.User;
import com.example.studentapp.repository.UserRepository;
import com.example.studentapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // LOGIN LOGIC
    @Override
    public User login(LoginDTO loginDTO) {

        User user = userRepository.findByUsername(loginDTO.getUsername()).orElse(null);

        if (user != null && passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return user;
        }

        return null;
    }

    // REGISTER LOGIC
    @Override
    public void register(User user) {

        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Default role
        if (user.getRole() == null) {
            user.setRole("USER");
        }

        userRepository.save(user);
    }
}
