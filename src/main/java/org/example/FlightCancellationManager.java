package org.example;
import java.util.HashMap;
import java.util.Map;

public class FlightCancellationManager {

    private Map<String, Flight> flightDatabase;

    // Constructor
    public FlightCancellationManager() {
        // Initialize the flight database
        flightDatabase = new HashMap<>();

        // Initialize flight database with  flights from FlightBookingManager
        FlightBookingManager bookingManager = new FlightBookingManager();
        for (Flight flight : bookingManager.getFlights().values()) {
            flightDatabase.put(flight.getFlightNumber(), flight);
        }
    }

    // Method to cancel a booked flight
    public boolean cancelFlight(String flightNumber) {
        // Check if the flight number is valid
        if (!isValidFlightNumber(flightNumber)) {
            System.out.println("Failed to cancel flight " + flightNumber + ". Invalid flight number.");
            return false;
        }

        // Check if the flight exists in the database
        if (!flightDatabase.containsKey(flightNumber)) {
            System.out.println("Failed to cancel flight " + flightNumber + ". Flight not found in the database.");
            return false;
        }

        // Perform cancellation operation
        Flight cancelledFlight = flightDatabase.remove(flightNumber);
        if (cancelledFlight != null) {
            System.out.println("Flight " + flightNumber + " successfully cancelled.");
            return true;
        } else {
            System.out.println("Failed to cancel flight " + flightNumber + ". Please try again later.");
            return false;
        }
    }

    // Method to validate flight number format
    private boolean isValidFlightNumber(String flightNumber) {
        // We are assuming any non-null flight number is valid
        return flightNumber != null;
    }
}
