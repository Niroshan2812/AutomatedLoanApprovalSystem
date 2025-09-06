package com.loanapproval.loan_approval_system.repository;

import com.loanapproval.loan_approval_system.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepostory extends JpaRepository<LoanApplication, Long> {
}
