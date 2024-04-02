package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FlightBookingManagerTest {

    @Test
    public void testGetFlightDetails_FlightExists() {
        // Create a FlightBookingManager object
        FlightBookingManager manager = new FlightBookingManager();

        // Test getting details for an existing flight
        Flight expectedFlight = new Flight("ABC123", "JFK", "LAX", "Monday", "08:00", "Monday", "12:00", "Economy");
        assertEquals(expectedFlight, manager.getFlightDetails("ABC123"));
    }

    @Test
    public void testGetFlightDetails_FlightNotExists() {
        // Create a FlightBookingManager object
        FlightBookingManager manager = new FlightBookingManager();

        // Test getting details for a non-existing flight
        assertNull(manager.getFlightDetails("NONEXISTENT"));
    }
}
