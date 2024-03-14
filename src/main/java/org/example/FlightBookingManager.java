package org.example;

import java.util.HashMap;
import java.util.Map;

public class FlightBookingManager {

    // Create flight database
    private Map<String, Flight> flights;

    // Constructor
    public FlightBookingManager() {
        // Initialize the flight database
        flights = new HashMap<>();
        flights.put("DTK253", new Flight("DTK253", "TORONTO", "AMSTERDAM", "2024-12-01", "Economy"));
        flights.put("XYZ456", new Flight("XYZ456", "CAIRO", "NAIROBI", "2024-12-10", "Business"));

    }

    // Method to get all flights
    public Map<String, Flight> getFlights() {
        return flights;
    }

    // Method to get flight details by flight number
    public Flight getFlightDetails(String flightNumber) {
        // Check if the flight exists in the database
        if (flights.containsKey(flightNumber)) {
            return flights.get(flightNumber);
        } else {
            // Return null if the flight does not exist
            return null;
        }
    }
}
