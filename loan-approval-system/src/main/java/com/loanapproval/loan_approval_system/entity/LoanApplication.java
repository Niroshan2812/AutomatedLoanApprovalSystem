package com.loanapproval.loan_approval_system.entity;

import jakarta.persistence.*;
import jakarta.transaction.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "loan_applications")
@Getter
@Setter
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private String loanType;
    private Double loanAmount;
    private Integer tenureMonths;
    private String purpose;
    private Double collateralValue;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum Status {PENDING, APPROVED, REJECTED}
}
