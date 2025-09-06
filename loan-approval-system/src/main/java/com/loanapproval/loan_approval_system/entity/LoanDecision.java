package com.loanapproval.loan_approval_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "loan_decisions")
@Getter
@Setter
public class LoanDecision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long decisionId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lonn_id", nullable = false)
    private LoanApplication loanApplication;

    private String action;
    private Double approvedAmount;
    private Double interestRate;
    private String reasoning;
    private String decidedBy;
    private LocalDate decisionDate;

}
