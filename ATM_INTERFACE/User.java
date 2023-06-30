import java.util.ArrayList;
import java.util.List;

public class User {
    private int userID;
    private int pin;
    private double balance;
    private List<String> transactionHistory;

    public User(int userID, int pin, double balance) {
        this.userID = userID;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean validatePIN(int pin) {
        return this.pin == pin;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        String transaction = "Withdraw: -$" + amount;
        transactionHistory.add(transaction);
        return true;
    }

    public void deposit(double amount) {
        balance += amount;
        String transaction = "Deposit: +$" + amount;
        transactionHistory.add(transaction);
    }

    public boolean transfer(int recipientID, double amount) {
        // Implement the logic for transferring funds to another user
        return false;
    }

    public String getTransactionHistory() {
        StringBuilder sb = new StringBuilder();
        for (String transaction : transactionHistory) {
            sb.append(transaction).append("\n");
        }
        return sb.toString();
    }
}
