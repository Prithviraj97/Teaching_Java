package CS282;

// Abstract class for payments
abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    // Abstract method: must be implemented differently by each payment type
    abstract void processPayment();

    // Concrete method: shared by all payments
    void generateReceipt() {
        System.out.println("Receipt: Payment of $" + amount + " completed.");
    }
}

// Concrete subclass for Credit Card payments
class CreditCardPayment extends Payment {
    String cardNumber;

    CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    void processPayment() {
        System.out.println("Processing credit card payment of $" + amount 
                           + " using card: " + cardNumber);
    }
}

// Concrete subclass for PayPal payments
class PayPalPayment extends Payment {
    String email;

    PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }

    @Override
    void processPayment() {
        System.out.println("Processing PayPal payment of $" + amount 
                           + " from account: " + email);
    }
}

//add another method called 'BankTransferPayment' that extends Payment and implements processPayment() accordingly.

public class PaymentDemo {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment(120.50, "1234-5678-9876-5432");
        Payment p2 = new PayPalPayment(75.00, "user@example.com");

        p1.processPayment();
        p1.generateReceipt();

        p2.processPayment();
        p2.generateReceipt();
    }
}
