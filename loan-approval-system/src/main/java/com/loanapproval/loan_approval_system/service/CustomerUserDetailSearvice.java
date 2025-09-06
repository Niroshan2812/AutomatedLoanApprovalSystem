package com.loanapproval.loan_approval_system.service;

import com.loanapproval.loan_approval_system.entity.Users;
import com.loanapproval.loan_approval_system.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailSearvice implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomerUserDetailSearvice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByuserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return org.springframework.security.core.userdetails.User.builder()
                .username(users.getUserName())
                .password(users.getPasswordHash())
                .roles(users.getRole().name())
                .build();
    }
}
