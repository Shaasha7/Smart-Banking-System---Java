import java.util.*;

// ===============================
// MAIN CLASS
// ===============================
public class SmartBankingSystem {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.start();
    }
}

// ===============================
// COMPOSITION (SYSTEM CORE)
// ===============================
class Bank {
    private List<Account> accounts;
    private Scanner sc;

    public Bank() {
        accounts = new ArrayList<>();
        sc = new Scanner(System.in);

        // Sample accounts
        accounts.add(new SavingsAccount("S101", "Shalini", 5000));
        accounts.add(new CurrentAccount("C201", "Arjun", 10000));
    }

    public void start() {
        System.out.println("=================================");
        System.out.println("     SMART BANKING SYSTEM");
        System.out.println("=================================");

        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. View Accounts");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showAccounts();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for banking with us 🏦");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    private void showAccounts() {
        System.out.println("\nAccounts:");
        for (Account a : accounts) {
            a.showDetails();
        }
    }

    private Account findAccount(String id) {
        for (Account a : accounts) {
            if (a.getId().equalsIgnoreCase(id)) {
                return a;
            }
        }
        return null;
    }

    private void deposit() {
        System.out.print("Enter Account ID: ");
        String id = sc.next();

        Account acc = findAccount(id);

        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            double amt = sc.nextDouble();
            acc.deposit(amt);
        } else {
            System.out.println("Account not found ❌");
        }
    }

    private void withdraw() {
        System.out.print("Enter Account ID: ");
        String id = sc.next();

        Account acc = findAccount(id);

        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            double amt = sc.nextDouble();
            acc.withdraw(amt);
        } else {
            System.out.println("Account not found ❌");
        }
    }
}

// ===============================
// ENCAPSULATION + ABSTRACTION
// ===============================
abstract class Account {
    private String id;
    private String holderName;
    protected double balance;

    public Account(String id, String holderName, double balance) {
        this.id = id;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + " successfully ✅");
        showBalance();
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + " successfully ✅");
        } else {
            System.out.println("Insufficient balance ❌");
        }
        showBalance();
    }

    public void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showDetails() {
        System.out.println(id + " | " + holderName + " | ₹" + balance);
    }
}

// ===============================
// INHERITANCE - SAVINGS ACCOUNT
// ===============================
class SavingsAccount extends Account {

    public SavingsAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("\n[Savings Account Withdrawal]");
        super.withdraw(amount);
    }
}

// ===============================
// INHERITANCE - CURRENT ACCOUNT
// ===============================
class CurrentAccount extends Account {

    public CurrentAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("\n[Current Account Withdrawal]");
        super.withdraw(amount);
    }
}