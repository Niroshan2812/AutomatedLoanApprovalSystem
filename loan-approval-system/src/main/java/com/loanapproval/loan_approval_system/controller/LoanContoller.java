package com.loanapproval.loan_approval_system.controller;

import com.loanapproval.loan_approval_system.entity.LoanApplication;
import com.loanapproval.loan_approval_system.repository.LoanApplicationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanContoller {
    private final LoanApplicationRepository loanApplicationRepository;

    public LoanContoller(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    @PostMapping("/apply")
    public LoanApplication apply(@RequestBody LoanApplication loanApplication) {
        loanApplication.setStatus("PENDING");
        return loanApplicationRepository.save(loanApplication);
    }

    @GetMapping
    public List<LoanApplication> getAll() {
        return loanApplicationRepository.findAll();
    }
}
