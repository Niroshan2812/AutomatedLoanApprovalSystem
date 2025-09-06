CREATE TABLE users(
    user_id SERIAL PRIMARY KEY,
    userName VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL CHECK ( role IN ('ADMIN', 'CUSTOMER') ),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL  REFERENCES users(user_id) ON DELETE CASCADE,
    full_name VARCHAR(200) NOT NULL,
    nic_passport VARCHAR(50) NOT NULL UNIQUE,
    dob DATE,
    gender VARCHAR(10),
    marital_status VARCHAR(20),
    dependents INT,
    address TEXT,
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE
);