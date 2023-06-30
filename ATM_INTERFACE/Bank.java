import java.util.HashMap;
import java.util.Map;

public class Bank {
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
