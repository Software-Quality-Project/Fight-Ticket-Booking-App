package org.example;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlightCancellationManagerTest {

    @Test
    public void testCancelFlight_Success() {
        // Create a FlightCancellationManager object
        FlightCancellationManager manager = new FlightCancellationManager();

        // Test cancelling a booked flight with a valid flight number
        assertTrue(manager.cancelFlight("ABC123"));
    }

    @Test
    public void testCancelFlight_Failure_InvalidFlightNumber() {
        // Create a FlightCancellationManager object
        FlightCancellationManager manager = new FlightCancellationManager();

        // Test cancelling a flight with an invalid flight number (null)
        assertFalse(manager.cancelFlight(null));
    }
}
