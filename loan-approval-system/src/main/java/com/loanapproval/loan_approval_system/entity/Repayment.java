package com.loanapproval.loan_approval_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "replayments")
@Getter
@Setter
public class Repayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repaymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id", nullable = false)
    private LoanApplication loanApplication;

    private LocalDate dueDate;
    private Double amountDue;
    private Double amountPaid;
    private LocalDate paymentDate;
    private String status;

}
