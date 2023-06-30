import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Reservation {
    private String pnr;
    private String trainNumber;
    private String trainName;
    private String classType;
    private String dateOfJourney;
    private String fromPlace;
    private String toDestination;

    public Reservation(String pnr, String trainNumber, String trainName, String classType, String dateOfJourney, String fromPlace, String toDestination) {
        this.pnr = pnr;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.fromPlace = fromPlace;
        this.toDestination = toDestination;
    }

    public String getPnr() {
        return pnr;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getClassType() {
        return classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public String getToDestination() {
        return toDestination;
    }
}

class Cancellation {
    private String pnr;

    public Cancellation(String pnr) {
        this.pnr = pnr;
    }

    public String getPnr() {
        return pnr;
    }
}

public class OnlineReservationSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, User> users = new HashMap<>();
    private static Map<String, Reservation> reservations = new HashMap<>();

    public static void main(String[] args) {
        initializeUsers(); // Add some users to the system
        login();
    }

    private static void initializeUsers() {
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));
        // Add more users as needed
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful!");
            showMainMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
            login();
        }
    }

    private static void showMainMenu() {
        System.out.println("Online Reservation System");
        System.out.println("1. Make Reservation");
        System.out.println("2. Cancel Reservation");
        System.out.println("3. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                makeReservation();
                break;
            case 2:
                cancelReservation();
                break;
            case 3:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showMainMenu();
                break;
        }
    }

    private static void makeReservation() {
        System.out.print("Enter PNR number: ");
        String pnr = scanner.nextLine();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter train name: ");
        String trainName = scanner.nextLine();
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey: ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter from place: ");
        String fromPlace = scanner.nextLine();
        System.out.print("Enter to destination: ");
        String toDestination = scanner.nextLine();

        Reservation reservation = new Reservation(pnr, trainNumber, trainName, classType, dateOfJourney, fromPlace, toDestination);
        reservations.put(pnr, reservation);

        System.out.println("Reservation successfully made!");
        showMainMenu();
    }

    private static void cancelReservation() {
        System.out.print("Enter PNR number to cancel: ");
        String pnr = scanner.nextLine();

        Reservation reservation = reservations.get(pnr);
        if (reservation != null) {
            System.out.println("Reservation details:");
            System.out.println("PNR: " + reservation.getPnr());
            System.out.println("Train Number: " + reservation.getTrainNumber());
            System.out.println("Train Name: " + reservation.getTrainName());
            System.out.println("Class Type: " + reservation.getClassType());
            System.out.println("Date of Journey: " + reservation.getDateOfJourney());
            System.out.println("From Place: " + reservation.getFromPlace());
            System.out.println("To Destination: " + reservation.getToDestination());

            System.out.print("Press OK to confirm cancellation or any other key to go back: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("OK")) {
                reservations.remove(pnr);
                System.out.println("Reservation successfully cancelled!");
            }
        } else {
            System.out.println("Invalid PNR number. Please try again.");
            cancelReservation();
        }

        showMainMenu();
    }
}
