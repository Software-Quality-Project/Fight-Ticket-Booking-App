package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class AppTest {

    private FlightBookingManager bookingManager;

    @BeforeEach
    public void setUp() {
        bookingManager = new FlightBookingManager();
    }

    @Test
    public void testGetFlights() {
        Map<String, Flight> flights = bookingManager.getFlights();
        Assertions.assertNotNull(flights);
        Assertions.assertEquals(2, flights.size());
    }

    @Test
    public void testGetFlightDetailsExistingFlight() {
        String flightNumber = "DTK253";
        Flight flight = bookingManager.getFlightDetails(flightNumber);
        Assertions.assertNotNull(flight);
        Assertions.assertEquals(flightNumber, flight.getFlightNumber());
    }

    @Test
    public void testGetFlightDetailsNonExistingFlight() {
        String flightNumber = "NonExistingFlight";
        Flight flight = bookingManager.getFlightDetails(flightNumber);
        Assertions.assertNull(flight);
    }
}
