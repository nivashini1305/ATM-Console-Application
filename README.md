# ATM-Console-Application
# ATM Management System


## Class Diagram

## Overview
The ATM Management System is a Java-based console application that provides functionalities for both Admin and User operations. The Admin can manage users and view transactions, while users can perform banking operations like deposits, withdrawals, PIN changes, and transaction history viewing. The system also includes a method for handling banknotes efficiently to track the denominations dispensed during withdrawals.


## Class Diagram

![ATM CONSOLE APPLICATION Excelidraw](https://github.com/user-attachments/assets/3049cb5f-5007-4e1c-8157-e5f68fe62650)

## Output Preview

https://github.com/user-attachments/assets/01a997f2-b6e0-4add-b9e3-e296c3a63563


## Features

### Admin Operations
- Login as Admin.
- Add a new user.
- Delete an existing user.
- View transactions:
  - Specific user transactions.
  - Admin transactions.
  - All user transactions.
- Deposit money into the ATM.
- Logout.

### User Operations
- Login as User.
- Deposit money.
- Withdraw money:
  - Displays the number of notes supplied.
  - Uses a duplicate notes method to prevent modifying the original note array until final calculations.
- Change PIN.
- View transaction history.
- Logout.
- Exit the program (optional by the user).

## Installation & Setup
1. Clone the repository from GitHub:
   ```sh
   git clone <https://github.com/nivashini1305/ATM-Console-Application>
   ```
2. Open the project in any Java IDE (Eclipse, IntelliJ IDEA, or VS Code with Java support).
3. Compile and run the Java program:
   ```sh
   javac ATM.java
   java ATM
   ```

## Usage
1. Run the application.
2. Select `Admin Login` or `User Login`.
3. Perform operations as per the selected role.
4. Admin can manage users and transactions.
5. Users can deposit, withdraw, change PIN, and check transaction history.
6. Logout when done.

## Technologies Used
- Java (Core Java, OOPs Concepts)
## Author
- Nivashini Govindaraj
- GitHub: https://github.com/nivashini1305
- Mail: nivashinigovindaraj05@gmail.com
- LinkedIn: https://www.linkedin.com/in/nivashini-govindaraj-7431a0316/




