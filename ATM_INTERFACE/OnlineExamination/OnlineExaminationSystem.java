import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineExaminationSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, String> users = new HashMap<>();
    private static String currentUser;

    public static void main(String[] args) {
        boolean isRunning = true;

      
        users.put("shri", "shri123");
        users.put("dhiraj", "dhiraj123");
        users.put("teju", "teju123");

        while (isRunning) {
            printMainMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    updateProfile();
                    break;
                case 3:
                    startExam();
                    break;
                case 4:
                    logout();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\nOnline Examination System");
        System.out.println("1. Login");
        System.out.println("2. Update Profile and Password");
        System.out.println("3. Start Exam");
        System.out.println("4. Logout");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username;
            System.out.println("Login successful! Welcome, " + currentUser + "!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void updateProfile() {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        users.put(newUsername, newPassword);
        users.remove(currentUser);
        currentUser = newUsername;

        System.out.println("Profile and password updated successfully!");
    }

    private static void startExam() {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }

        System.out.println("Starting exam...");
       
    }

    private static void logout() {
        currentUser = null;
        System.out.println("Logged out successfully.");
    }
}
