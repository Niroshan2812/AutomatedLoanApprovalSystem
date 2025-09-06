package com.loanapproval.loan_approval_system.controller;

import com.loanapproval.loan_approval_system.entity.Users;
import com.loanapproval.loan_approval_system.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthContoller {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthContoller(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register (@RequestBody Users users){
        users.setPasswordHash(passwordEncoder.encode(users.getPasswordHash()));
        userRepository.save(users);
        return "User registered successfully";
    }
}
