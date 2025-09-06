package com.loanapproval.loan_approval_system.controller;

import com.loanapproval.loan_approval_system.entity.LoanApplication;
import com.loanapproval.loan_approval_system.service.LoanApplicationSearvice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
public class LoanApplicationContoller {

    private final LoanApplicationSearvice loanApplicationSearvice;

    public LoanApplicationContoller(LoanApplicationSearvice loanApplicationSearvice) {
        this.loanApplicationSearvice = loanApplicationSearvice;
    }

    @PostMapping("/apply")
    public ResponseEntity<LoanApplication> applyForLoan(@RequestBody LoanApplication loanApplication) {
        LoanApplication savedApplication = loanApplicationSearvice.saveLoanApplication(loanApplication);
        return ResponseEntity.ok(savedApplication);
    }
}
