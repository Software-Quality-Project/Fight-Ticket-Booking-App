package org.example;

import java.util.HashMap;
import java.util.Map;

public class UserAuthenticationManager {

    // Create user database
    private Map<String, String> userCredentials;

    // Constructor
    public UserAuthenticationManager() {
        // Initialize the user database with some sample user credentials
        userCredentials = new HashMap<>();
        userCredentials.put("Ronaldo", "ronaldo34");
        userCredentials.put("Biden", "biden897");
    }

    // Method to authenticate user
    public boolean authenticateUser(String username, String password) {
        // Check if the provided username exists in the user database
        if (userCredentials.containsKey(username)) {
            // If the username exists, check if the provided password matches the stored password
            String storedPassword = userCredentials.get(username);
            return storedPassword.equals(password);
        } else {
            // If the username doesn't exist in the user database, add the new user
            userCredentials.put(username, password);

            return true;
        }
    }
}
