package org.example;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class FlightInformationProviderTest {

    private FlightInformationProvider provider;

    @Before
    public void setUp() {
        // Create a FlightBookingManager with flights
        FlightBookingManager bookingManager = new FlightBookingManager();
        provider = new FlightInformationProvider(bookingManager);
    }

    @Test
    public void testGetFlightInformation() {
        // Test retrieving existing flight information
        Flight flight = provider.getFlightInformation("DTK253");
        assertNotNull("Flight DTK253 should exist", flight);
        assertEquals("DTK253", flight.getFlightNumber());
        assertEquals("TORONTO", flight.getDepartureAirport());
        assertEquals("AMSTERDAM", flight.getDestinationAirport());
        assertEquals("2024-12-01", flight.getDepartureDate());
        assertEquals("Economy", flight.getSeatClass());

        // Test retrieving non-existing flight information
        Flight nonExistingFlight = provider.getFlightInformation("ABC123");
        assertNull("Flight ABC123 should not exist", nonExistingFlight);
    }

    @Test
    public void testGetWeeklyFlights() {
        // Test retrieving the list of weekly flights
        Map<String, Flight> weeklyFlights = new HashMap<>(provider.getWeeklyFlights().size());
        for (Flight flight : provider.getWeeklyFlights()) {
            weeklyFlights.put(flight.getFlightNumber(), flight);
        }

        assertNotNull("Weekly flights list should not be null", weeklyFlights);
        assertEquals("Number of weekly flights should be 2", 2, weeklyFlights.size());
        assertNotNull("Weekly flights list should contain flight DTK253", weeklyFlights.get("DTK253"));
        assertNotNull("Weekly flights list should contain flight XYZ456", weeklyFlights.get("XYZ456"));
    }
}
