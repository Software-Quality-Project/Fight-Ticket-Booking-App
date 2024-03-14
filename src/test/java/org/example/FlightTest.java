package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FlightTest {

    @Test
    public void testGetters() {
        // Create a Flight object with data
        Flight flight = new Flight("ABC123", "JFK", "LAX", "2024-12-01", "Economy");

        // Test the getters
        assertEquals("ABC123", flight.getFlightNumber());
        assertEquals("JFK", flight.getDepartureAirport());
        assertEquals("LAX", flight.getDestinationAirport());
        assertEquals("2024-12-01", flight.getDepartureDate());
        assertEquals("Economy", flight.getSeatClass());
    }
}
