import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ATMSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        boolean loggedIn = false;

        // Prompt for user ID and PIN
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine(); 

        
        User user = bank.authenticateUser(userID, pin);
        if (user != null) {
            loggedIn = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid User ID or PIN. Exiting...");
            System.exit(0);
        }

        // Main menu loop
        while (loggedIn) {
            printMainMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    displayTransactionHistory(user);
                    break;
                case 2:
                    performWithdrawal(user);
                    break;
                case 3:
                    performDeposit(user);
                    break;
                case 4:
                    performTransfer(user);
                    break;
                case 5:
                    checkBalance(user);
                    break;
                case 6:
                    loggedIn = false;
                    System.out.println("Logged out. Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\nATM Main Menu");
        System.out.println("1. View Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Check Balance");
        System.out.println("6. Quit");
        System.out.print("Enter your choice: ");
    }

    private static void displayTransactionHistory(User user) {
        System.out.println("\nTransaction History");
        System.out.println(user.getTransactionHistory());
    }

    private static void performWithdrawal(User user) {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        boolean success = user.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    private static void performDeposit(User user) {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        user.deposit(amount);
        System.out.println("Deposit successful!");
    }

    private static void performTransfer(User user) {
        System.out.print("Enter recipient's user ID: ");
        int recipientID = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter transfer amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        boolean success = user.transfer(recipientID, amount);
        if (success) {
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Invalid recipient ID or insufficient balance. Transfer failed.");
        }
    }

    private static void checkBalance(User user) {
        System.out.println("Current Balance: $" + user.getBalance());
    }

    public static class Bank {
        private Map<Integer, User> users;

        public Bank() {
            users = new HashMap<>();
            // Add some sample user accounts
            users.put(123, new User(123, 456, 1000.0));
            users.put(456, new User(456, 789, 2000.0));
        }

        public User authenticateUser(int userID, int pin) {
            User user = users.get(userID);
            if (user != null && user.validatePIN(pin)) {
                return user;
            }
            return null;
        }
    }

    public static class User {
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
            
            return false;
        }

        public String getTransactionHistory() {
            StringBuilder sb = new StringBuilder();
            for (String transaction : transactionHistory) {
                sb.append(transaction).append("\n");
            }
            return sb.toString();
        }

        public double getBalance() {
            return balance;
        }
    }
}
