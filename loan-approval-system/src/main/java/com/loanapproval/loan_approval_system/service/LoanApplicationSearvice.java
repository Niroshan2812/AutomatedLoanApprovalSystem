package com.loanapproval.loan_approval_system.service;

import com.loanapproval.loan_approval_system.entity.LoanApplication;
import com.loanapproval.loan_approval_system.repository.LoanApplicationRepostory;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationSearvice  {
    private final LoanApplicationRepostory loanApplicationRepostory;


    public LoanApplicationSearvice(LoanApplicationRepostory loanApplicationRepostory) {
        this.loanApplicationRepostory = loanApplicationRepostory;
    }

    public LoanApplication saveLoanApplication(LoanApplication loanApplication) {
        return loanApplicationRepostory.save(loanApplication);
    }
}
