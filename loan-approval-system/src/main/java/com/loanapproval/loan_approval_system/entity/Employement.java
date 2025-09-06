package com.loanapproval.loan_approval_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "employment")
@Getter
@Setter
public class Employement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    private String employmentType;
    private String employerName;
    private String designation;
    private Integer yearsOfService;
    private Double monthlyIncome;
    private Double otherIncome;
}
