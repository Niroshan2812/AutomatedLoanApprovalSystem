-- Employment Table
CREATE TABLE employment (
                            employment_id SERIAL PRIMARY KEY,
                            customer_id INT NOT NULL REFERENCES customers(customer_id) ON DELETE CASCADE,
                            employment_type VARCHAR(50),
                            employer_name VARCHAR(200),
                            designation VARCHAR(100),
                            years_of_service INT,
                            monthly_income NUMERIC(15, 2),
                            other_income NUMERIC(15, 2)
);

-- Loan Applications Table
CREATE TABLE loan_applications (
                                   loan_id SERIAL PRIMARY KEY,
                                   customer_id INT NOT NULL REFERENCES customers(customer_id) ON DELETE CASCADE,
                                   loan_type VARCHAR(50) NOT NULL,
                                   loan_amount NUMERIC(15, 2) NOT NULL,
                                   tenure_months INT NOT NULL,
                                   purpose TEXT,
                                   collateral_value NUMERIC(15, 2),
                                   status VARCHAR(20) NOT NULL CHECK (status IN ('PENDING', 'APPROVED', 'REJECTED')),
                                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   updated_at TIMESTAMP
);

-- Loan Decisions Table
CREATE TABLE loan_decisions (
                                decision_id SERIAL PRIMARY KEY,
                                loan_id INT NOT NULL REFERENCES loan_applications(loan_id) ON DELETE CASCADE,
                                action VARCHAR(20) NOT NULL CHECK (action IN ('Approved', 'Rejected', 'Modified terms')),
    approved_amount NUMERIC(15, 2),
    interest_rate NUMERIC(5, 2),
    reasoning TEXT,
    decided_by VARCHAR(20) NOT NULL CHECK (decided_by IN ('RL_AGENT', 'ADMIN')),
    decision_date DATE
);

-- Repayments Table
CREATE TABLE repayments (
                            repayment_id SERIAL PRIMARY KEY,
                            loan_id INT NOT NULL REFERENCES loan_applications(loan_id) ON DELETE CASCADE,
                            due_date DATE NOT NULL,
                            amount_due NUMERIC(15, 2) NOT NULL,
                            amount_paid NUMERIC(15, 2),
                            payment_date DATE,
                            status VARCHAR(20) NOT NULL CHECK (status IN ('Pending', 'Paid', 'Late', 'Default'))
);

-- Credit History Table
CREATE TABLE credit_history (
                                history_id SERIAL PRIMARY KEY,
                                customer_id INT NOT NULL REFERENCES customers(customer_id) ON DELETE CASCADE,
                                credit_score INT,
                                total_loans INT,
                                defaults INT,
                                outstanding_debt NUMERIC(15, 2)
);

-- Admin Audit Log Table
CREATE TABLE admin_audit_log (
                                 log_id SERIAL PRIMARY KEY,
                                 admin_id INT NOT NULL REFERENCES users(user_id) ON DELETE SET NULL, -- Use ON DELETE SET NULL if admin user can be deleted
                                 action VARCHAR(100) NOT NULL,
                                 target_id INT,
                                 timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);