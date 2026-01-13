# NKOCET_ATM

A simple ATM simulation project demonstrating basic banking operations using Object-Oriented Programming (OOP) concepts. This repository contains implementations in both **Python** and **Java**.

## Features

- **Authentication**: Secure login with simulated Customer Number and PIN.
- **Account Types**: Support for both Current and Savings accounts.
- **Operations**:
  - Balance Enquiry
  - Cash Withdrawal
  - Cash Deposit
- **Validation**:
  - Checks for sufficient funds before withdrawal.
  - Input validation for numbers and menu choices.

## Getting Started

### Prerequisites

- **Python**: Python 3.x installed.
- **Java**: JDK (Java Development Kit) installed.

### How to Run

#### Python Version
1. Open a terminal/command prompt.
2. Navigate to the project directory.
3. Run the script:
   ```bash
   python ATM.py
   ```
   *(Note: Uncomment `atm.login()` in the `__main__` block if you want to enable the login simulation)*

#### Java Version
1. Open a terminal/command prompt.
2. Navigate to the project directory.
3. Compile the Java files:
   ```bash
   javac ATM.java
   ```
4. Run the application:
   ```bash
   java ATM
   ```

## Default Credentials (for Login simulation)
| Customer Number | PIN |
|-----------------|-----|
| 11111           | 111 |
| 11112           | 222 |
| 11113           | 333 |
| 11114           | 444 |
