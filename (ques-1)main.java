// BankAccount.java
class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

// SavingsAccount.java
class SavingsAccount extends BankAccount {
    private static final double WITHDRAWAL_LIMIT = 1000;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > WITHDRAWAL_LIMIT) {
            System.out.println("Withdrawal amount exceeds the limit of " + WITHDRAWAL_LIMIT);
        } else if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

// CheckingAccount.java
class CheckingAccount extends BankAccount {
    private static final double WITHDRAWAL_FEE = 2.50;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        double totalAmount = amount + WITHDRAWAL_FEE;
        if (amount > 0 && totalAmount <= balance) {
            balance -= totalAmount;
            System.out.println("Withdrawn: " + amount + " (Fee: " + WITHDRAWAL_FEE + ")");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount(2000);
        BankAccount checking = new CheckingAccount(2000);

        System.out.println("Initial Savings Balance: " + savings.getBalance());
        savings.deposit(500);
        savings.withdraw(1200); // exceeds limit
        savings.withdraw(800); // valid
        System.out.println("Final Savings Balance: " + savings.getBalance());

        System.out.println("\nInitial Checking Balance: " + checking.getBalance());
        checking.deposit(500);
        checking.withdraw(1200); // valid with fee
        checking.withdraw(800); // valid with fee
        System.out.println("Final Checking Balance: " + checking.getBalance());
    }
}