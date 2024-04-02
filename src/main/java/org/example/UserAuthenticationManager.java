package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationManager {

    // Create user database
    private Map<String, String> userCredentials;
    private Map<String, List<Ticket>> userTickets;

    // Constructor
    public UserAuthenticationManager() {
        // Initialize the user database with some sample user credentials
        userCredentials = new HashMap<>();
        userCredentials.put("Ronaldo", "ronaldo34");
        userCredentials.put("Biden", "biden897");

        userTickets = new HashMap<>();
    }

    // Method to authenticate user
    public boolean authenticateUser(String username, String password) {
        // Check if the provided username exists in the user database
        if (userCredentials.containsKey(username)) {
            // If the username exists, check if the provided password matches the stored password
            String storedPassword = userCredentials.get(username);
            return storedPassword.equals(password);
        } else {
            return false;
        }
    }

    // Method to register a new user
    public void registerUser(String username, String password) {
        userCredentials.put(username, password);
    }

    // Method to add a ticket for a user
    public void addTicketForUser(String username, Ticket ticket) {
        List<Ticket> tickets = userTickets.get(username);
        if (tickets == null) {
            tickets = new ArrayList<>();
            userTickets.put(username, tickets);
        }
        tickets.add(ticket);
    }

    // Method to get tickets for a user
    public List<Ticket> getTicketsForUser(String username) {
        return userTickets.get(username);
    }
}
