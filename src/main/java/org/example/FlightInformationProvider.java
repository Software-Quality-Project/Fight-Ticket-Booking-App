package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightInformationProvider {

    private Map<String, Flight> weeklyFlights;

    // Constructor
    public FlightInformationProvider(FlightBookingManager bookingManager) {
        // Initialize the list with weekly flights from the FlightBookingManager
        weeklyFlights = bookingManager.getFlights();
    }

    // Method to get flight information by flight number
    public Flight getFlightInformation(String flightNumber) {
        // Retrieve the flight information from the weeklyFlights map
        return weeklyFlights.get(flightNumber);
    }

    // Method to get the list of weekly flights
    public List<Flight> getWeeklyFlights() {
        return new ArrayList<>(weeklyFlights.values());
    }
}
