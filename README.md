# Smart-Banking-System---Java
To design and implement a Smart Banking System using Java.  The system allows users to perform banking operations such as viewing accounts,  depositing money, and withdrawing money.  This project demonstrates core Object-Oriented Programming concepts such as:  • Inheritance  • Polymorphism  • Encapsulation  • Abstraction  • Method Overriding  
# 🏦 Smart Banking System (Java OOP Project)

A **console-based Smart Banking System** developed using **Java and Object-Oriented Programming (OOP)** principles.  
This project simulates real-world banking operations such as **account management, deposit, and withdrawal** using a clean OOP architecture.

---

## 🚀 Features

- View all bank accounts  
- Deposit money into account  
- Withdraw money from account  
- Encapsulation for secure data handling  
- Inheritance (Savings & Current Accounts)  
- Polymorphism (method overriding)  
- Abstraction (abstract Account class)  
- Composition (Bank system manages accounts)

---

## 🧠 OOP Concepts Implemented

- **Encapsulation** → Protects account data (id, name, balance)  
- **Inheritance** → SavingsAccount & CurrentAccount extend Account  
- **Polymorphism** → withdraw() method overridden in subclasses  
- **Abstraction** → Account is abstract class  
- **Composition** → Bank class controls the system flow  

---

## 💻 Full Source Code

```java
import java.util.*;

public class SmartBankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.start();
    }
}

class Bank {
    private List<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public Bank() {
        accounts.add(new SavingsAccount("S101", "Shalini", 5000));
        accounts.add(new CurrentAccount("C201", "Arjun", 10000));
    }

    public void start() {
        int choice;

        do {
            System.out.println("\n===== SMART BANKING SYSTEM =====");
            System.out.println("1. View Accounts");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> showAccounts();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> System.out.println("Thank you for using Banking System 🏦");
                default -> System.out.println("Invalid Choice ❌");
            }

        } while (choice != 4);
    }

    private void showAccounts() {
        System.out.println("\n--- ACCOUNT LIST ---");
        for (Account acc : accounts) {
            acc.showDetails();
        }
    }

    private Account findAccount(String id) {
        for (Account acc : accounts) {
            if (acc.getId().equalsIgnoreCase(id)) {
                return acc;
            }
        }
        return null;
    }

    private void deposit() {
        System.out.print("Enter Account ID: ");
        Account acc = findAccount(sc.next());

        if (acc != null) {
            System.out.print("Enter Amount: ");
            acc.deposit(sc.nextDouble());
        } else {
            System.out.println("Account not found ❌");
        }
    }

    private void withdraw() {
        System.out.print("Enter Account ID: ");
        Account acc = findAccount(sc.next());

        if (acc != null) {
            System.out.print("Enter Amount: ");
            acc.withdraw(sc.nextDouble());
        } else {
            System.out.println("Account not found ❌");
        }
    }
}

abstract class Account {
    private String id;
    private String name;
    protected double balance;

    public Account(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ✔ New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ✔ New Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance ❌");
        }
    }

    public void showDetails() {
        System.out.println(id + " | " + name + " | ₹" + balance);
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("[Savings Account Withdrawal]");
        super.withdraw(amount);
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("[Current Account Withdrawal]");
        super.withdraw(amount);
    }
}
<img width="1917" height="812" alt="1" src="https://github.com/user-attachments/assets/0b8e997d-c87b-4bdf-a464-7be2dfb306e5" />
<img width="1918" height="808" alt="2" src="https://github.com/user-attachments/assets/e14314df-434c-4f1b-9eff-047d42a937b7" />

▶️ How to Run
javac SmartBankingSystem.java
java SmartBankingSystem
🧾 Sample Input Flow
1 → View Accounts
2 → Deposit (Enter ID + Amount)
3 → Withdraw (Enter ID + Amount)
4 → Exit
📂 Sample Data
S101 | Shalini | ₹5000
C201 | Arjun   | ₹10000
🎯 Learning Outcomes

This project demonstrates:

Real-world OOP system design
Clean class hierarchy
Modular programming approach
Practical banking system logic
👨‍💻 Author

Java OOP Project built for academic + portfolio use 🚀
Ideal for GitHub showcase and interview discussions.
