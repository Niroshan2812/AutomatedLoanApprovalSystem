package com.loanapproval.loan_approval_system.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    @Column(unique = true, nullable = false)
    private String userName;
    @Column (nullable = false)
    private String passwordHash;
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDateTime createdAT;


}

