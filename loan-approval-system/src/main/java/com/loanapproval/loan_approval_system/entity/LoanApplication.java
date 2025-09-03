package com.loanapproval.loan_approval_system.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantName;
    private double amount;
    private int durationMonths;
    private String status; // APPROVED / REJECTED / PENDING
}