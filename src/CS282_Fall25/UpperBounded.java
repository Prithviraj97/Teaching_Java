package CS282_Fall25;

import java.util.*;

abstract class Transaction {
    double amount;
    Transaction(double amount) { this.amount = amount; }
    abstract String summary();
}

class WireTransfer extends Transaction {
    WireTransfer(double amt) { super(amt); }
    String summary() { return "Wire Transfer: $" + amount; }
}

class CryptoPayment extends Transaction {
    CryptoPayment(double amt) { super(amt); }
    String summary() { return "Crypto Payment: $" + amount; }
}

public class UpperBounded {

    public static void processTransactions(List<? extends Transaction> txList) {
        // Allowed: reading
        for (Transaction tx : txList) {
            System.out.println(tx.summary());
        }

        // txList.add(new WireTransfer(100));  NOT allowed
    }

    public static void main(String[] args) {
        List<WireTransfer> wires = List.of(new WireTransfer(500), new WireTransfer(1200));
        List<CryptoPayment> crypto = List.of(new CryptoPayment(300));

        processTransactions(wires);
        processTransactions(crypto);
    }
}

