import java.util.Scanner;

class BankAccount {
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("  [ERROR] Deposit amount must be positive!");
            return;
        }
        balance += amount;
        System.out.println("  [SUCCESS] Rs." + amount + " deposited successfully.");
        System.out.println("  Updated Balance : Rs." + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("  [ERROR] Withdrawal amount must be positive!");
        } else if (amount > balance) {
            System.out.println("  [ERROR] Insufficient funds! Available balance: Rs." + balance);
        } else {
            balance -= amount;
            System.out.println("  [SUCCESS] Rs." + amount + " withdrawn successfully.");
            System.out.println("  Remaining Balance : Rs." + balance);
        }
    }

    public void displayDetails() {
        System.out.println("  ----------------------------------------");
        System.out.println("  Account Number  : " + accountNumber);
        System.out.println("  Account Holder  : " + holderName);
        System.out.println("  Balance         : Rs." + balance);
        System.out.println("  ----------------------------------------");
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName,
            double balance, double interestRate) {
        super(accountNumber, holderName, balance); // Call parent constructor
        this.interestRate = interestRate;
    }

    // Apply annual interest to the account
    public void applyInterest() {
        double interest = (balance * interestRate) / 100;
        balance += interest;
        System.out.println("  [INTEREST] Rate       : " + interestRate + "%");
        System.out.println("  [INTEREST] Amount     : Rs." + interest);
        System.out.println("  [INTEREST] New Balance: Rs." + balance);
    }

    // Override displayDetails to show account type
    @Override
    public void displayDetails() {
        System.out.println("  Account Type    : SAVINGS ACCOUNT");
        super.displayDetails();
        System.out.println("  Interest Rate   : " + interestRate + "% per annum");
        System.out.println("  ----------------------------------------");
    }
}

// ============================================================
// DERIVED CLASS 2 : CurrentAccount
// Inherits from BankAccount
// Extra Feature: Overdraft Limit
// ============================================================
class CurrentAccount extends BankAccount {
    private double overdraftLimit; // How much can be borrowed beyond 0
    // Constructor

    public CurrentAccount(String accountNumber, String holderName,
            double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance); // Call parent constructor
        this.overdraftLimit = overdraftLimit;
    }

    // Override withdraw to allow overdraft
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("  [ERROR] Withdrawal amount must be positive!");
        } else if (amount > balance + overdraftLimit) {
            System.out.println("  [ERROR] Exceeds overdraft limit!");
            System.out.println("  Available (with overdraft): Rs." + (balance + overdraftLimit));
        } else {
            balance -= amount;
            System.out.println("  [SUCCESS] Rs." + amount + " withdrawn.");
            if (balance < 0) {
                System.out.println("  [WARNING] Account is in overdraft! Balance: Rs." + balance);
            } else {
                System.out.println("  Remaining Balance : Rs." + balance);
            }
        }
    }

    // Override displayDetails to show account type
    @Override
    public void displayDetails() {
        System.out.println("  Account Type    : CURRENT ACCOUNT");
        super.displayDetails();
        System.out.println("  Overdraft Limit : Rs." + overdraftLimit);
        System.out.println("  ----------------------------------------");
    }
}

// ============================================================
// MAIN CLASS : BankSystem
// ============================================================
public class BankSystem {
    static void printHeader(String title) {
        System.out.println("\n  ========================================");
        System.out.println("      " + title);
        System.out.println("  ========================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printHeader("WELCOME TO ANTIGRAVITY BANK");
        // -------------------------------------------------------
        // PART 1 : Savings Account Demo
        // -------------------------------------------------------
        printHeader("SAVINGS ACCOUNT DEMO");
        SavingsAccount savings = new SavingsAccount("SB10234", "Riya Sharma", 15000, 5.0);
        savings.displayDetails();
        System.out.println("\n  >> Depositing Rs.5000...");
        savings.deposit(5000);
        System.out.println("\n  >> Withdrawing Rs.3000...");
        savings.withdraw(3000);
        System.out.println("\n  >> Applying Annual Interest...");
        savings.applyInterest();
        System.out.println("\n  >> Trying to withdraw more than balance...");
        savings.withdraw(50000);
        // -------------------------------------------------------
        // PART 2 : Current Account Demo
        // -------------------------------------------------------
        printHeader("CURRENT ACCOUNT DEMO");
        CurrentAccount current = new CurrentAccount("CA99821", "Aryan Mehta", 8000, 5000);
        current.displayDetails();
        System.out.println("\n  >> Depositing Rs.2000...");
        current.deposit(2000);
        System.out.println("\n  >> Withdrawing Rs.9000 (uses overdraft)...");
        current.withdraw(9000);
        System.out.println("\n  >> Trying to exceed overdraft limit...");
        current.withdraw(10000);
        // -------------------------------------------------------
        // PART 3 : Interactive Section
        // -------------------------------------------------------
        printHeader("CREATE YOUR OWN ACCOUNT");
        System.out.print("  Enter Account Holder Name : ");
        String name = sc.nextLine();
        System.out.print("  Enter Account Number      : ");
        String accNo = sc.nextLine();
        System.out.print("  Enter Initial Balance (Rs.): ");
        double bal = sc.nextDouble();
        System.out.println("\n  Select Account Type:");
        System.out.println("  1. Savings Account");
        System.out.println("  2. Current Account");
        System.out.print("  Your choice: ");
        int choice = sc.nextInt();
        BankAccount account = null;
        if (choice == 1) {
            System.out.print("  Enter Interest Rate (%): ");
            double rate = sc.nextDouble();
            account = new SavingsAccount(accNo, name, bal, rate);
        } else if (choice == 2) {
            System.out.print("  Enter Overdraft Limit (Rs.): ");
            double limit = sc.nextDouble();
            account = new CurrentAccount(accNo, name, bal, limit);
        } else {
            System.out.println("  Invalid choice. Exiting.");
            sc.close();
            return;
        }
        // -------------------------------------------------------
        // PART 4 : Menu-Driven Operations
        // -------------------------------------------------------
        int option;
        do {
            printHeader("BANKING MENU");
            System.out.println("  1. View Account Details");
            System.out.println("  2. Deposit Money");
            System.out.println("  3. Withdraw Money");
            if (account instanceof SavingsAccount) {
                System.out.println("  4. Apply Annual Interest");
            }
            System.out.println("  0. Exit");
            System.out.print("\n  Enter your choice: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    account.displayDetails();
                    break;
                case 2:
                    System.out.print("  Enter deposit amount (Rs.): ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 3:
                    System.out.print("  Enter withdrawal amount (Rs.): ");
                    double wit = sc.nextDouble();
                    account.withdraw(wit);
                    break;
                case 4:
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).applyInterest();
                    } else {
                        System.out.println("  [ERROR] Invalid option for Current Account.");
                    }
                    break;
                case 0:
                    System.out.println("\n  Thank you for banking with us! Goodbye!");
                    break;
                default:
                    System.out.println("  Invalid choice. Please try again.");
            }
        } while (option != 0);
        sc.close();
    }
}