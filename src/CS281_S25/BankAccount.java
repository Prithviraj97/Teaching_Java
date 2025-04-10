package cs281_s25;
public class BankAccount {
    // Private fields - encapsulated
    private String accountNumber;
    private double balance;
    private String ownerName;
    
    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getOwnerName() {
        return ownerName;
    }
    
    // Setters with validation
    public void setAccountNumber(String accountNumber) {
        if (accountNumber != null && accountNumber.length() == 10) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Invalid account number!");
        }
    }
    
    public void setOwnerName(String ownerName) {
        if (ownerName != null && !ownerName.isEmpty()) {
            this.ownerName = ownerName;
        } else {
            System.out.println("Owner name cannot be empty!");
        }
    }
    
    // No setter for balance - it changes through methods
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(amount + " deposited. New balance: " + this.balance);
        } else {
            System.out.println("Cannot deposit negative amount!");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + this.balance);
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
}