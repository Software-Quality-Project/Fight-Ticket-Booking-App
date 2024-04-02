package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FlightBookingManagerTest {

    @Test
    public void testGetFlightDetails_FlightExists() {
        // Create a FlightBookingManager object
        FlightBookingManager manager = new FlightBookingManager();

        // Test getting details for an existing flight
        String expectedFlightNumber = "DTK253";
        Flight flight = manager.getFlightDetails(expectedFlightNumber);

        assertNotNull(flight);
        assertEquals(expectedFlightNumber, flight.getFlightNumber());
    }

    @Test
    public void testGetFlightDetails_FlightNotExists() {
        // Create a FlightBookingManager object
        FlightBookingManager manager = new FlightBookingManager();

        // Test getting details for a non-existing flight
        assertNull(manager.getFlightDetails("NONEXISTENT"));
    }
}
