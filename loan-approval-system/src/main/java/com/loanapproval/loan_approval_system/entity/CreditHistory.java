package com.loanapproval.loan_approval_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_history")
public class CreditHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name  = "customer_id", nullable = false)
    private Customer customer;

    private Double creditScore;
    private Integer totalLoans;
    private Integer defaults;
    private Double outstandingDebt;
}
