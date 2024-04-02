package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FlightTest {

    @Test
    public void testGetters() {
        // Create a Flight object with data
        Flight flight = new Flight("ABC123", "JFK", "LAX", "Monday", "08:00", "Monday", "12:00", "Economy");

        // Test the getters
        assertEquals("ABC123", flight.getFlightNumber());
        assertEquals("JFK", flight.getDepartureAirport());
        assertEquals("LAX", flight.getDestinationAirport());
        assertEquals("Monday", flight.getDepartureDate());
        assertEquals("Economy", flight.getFlightClass());
    }
}
