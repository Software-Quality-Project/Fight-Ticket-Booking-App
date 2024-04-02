package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class IntegrationTest {

    private FlightBookingManager bookingManager;
    private FlightInformationProvider infoProvider;
    private SeatManager seatManager;
    private FlightCancellationManager cancellationManager;
    private CyclicTripPreventionManager cyclicTripPreventionManager;
    private PaymentGatewayManager paymentGatewayManager;
    private TicketFormatConverter ticketFormatConverter;
    private UserAuthenticationManager userAuthenticationManager;

    @BeforeEach
    public void setUp() {
        // Initialize all necessary components
        bookingManager = new FlightBookingManager();
        infoProvider = new FlightInformationProvider(bookingManager);
        seatManager = new SeatManager();
        cancellationManager = new FlightCancellationManager();
        cyclicTripPreventionManager = new CyclicTripPreventionManager();
        paymentGatewayManager = new PaymentGatewayManager();
        ticketFormatConverter = new TicketFormatConverter();
        userAuthenticationManager = new UserAuthenticationManager();
    }

    @Test
    public void testFlightBooking() {
        // Retrieve flights from the booking manager
        Map<String, Flight> flights = bookingManager.getFlights();
        assertNotNull(flights);
        assertFalse(flights.isEmpty());

        // Ensure flight information provider provides correct flight information
        for (Flight flight : flights.values()) {
            String flightNumber = flight.getFlightNumber();
            assertEquals(flight, infoProvider.getFlightInformation(flightNumber));
        }
    }

    @Test
    public void testSeatBooking() {
        // Attempt to book available seats
        assertTrue(seatManager.selectSeat("DTK253", "1-1"));
        assertTrue(seatManager.selectSeat("XYZ456", "2-3"));

        // Ensure the booked seats are no longer available
        assertFalse(seatManager.selectSeat("DTK253", "1-1"));
        assertFalse(seatManager.selectSeat("XYZ456", "2-3"));
    }

    @Test
    public void testFlightCancellation() {
        // Cancel a booked flight
        assertTrue(cancellationManager.cancelFlight("DTK253"));

        // Attempt to cancel a non-existent flight
        assertFalse(cancellationManager.cancelFlight("ABC123"));
    }

    @Test
    public void testCyclicTripPrevention() {
        CyclicTripPreventionManager cyclicTripPreventionManager = new CyclicTripPreventionManager();

        // Prevent cyclic trip TORONTO to AMSTERDAM, should succeed
        assertTrue(cyclicTripPreventionManager.preventCyclicTrip("TORONTO", "AMSTERDAM"));

        // Prevent cyclic trip AMSTERDAM to TORONTO, should succeed
        assertTrue(cyclicTripPreventionManager.preventCyclicTrip("AMSTERDAM", "TORONTO"));
    }

    @Test
    public void testPaymentProcessing() {
        // Process payment with valid parameters
        assertTrue(paymentGatewayManager.processPayment(100.0, "1234567890123456", "12/25", "123"));

        // Process payment with invalid parameters
        assertFalse(paymentGatewayManager.processPayment(50.0, "1234", "2025", "12"));
    }

    @Test
    public void testTicketFormatConversion() {
        TicketFormatConverter ticketFormatConverter = new TicketFormatConverter();

        // Convert time to 12-hour format
        assertEquals("05:30 PM", ticketFormatConverter.convertTo12HourFormat("17:30"));

        // Convert time to 24-hour format
        assertEquals("17:30", ticketFormatConverter.convertTo24HourFormat("05:30 PM"));
    }

    @Test
    public void testUserAuthentication() {
        // Authenticate existing user
        assertTrue(userAuthenticationManager.authenticateUser("Ronaldo", "ronaldo34"));

        // Authenticate user that does not exit
        assertFalse(userAuthenticationManager.authenticateUser("Messi", "messi10"));

        // Authenticate user with incorrect password
        assertFalse(userAuthenticationManager.authenticateUser("Biden", "biden123"));
    }

    @Test
    public void testAppIntegration() {
        // You can add integration tests for the App class here
        // For example, you can use mocking frameworks like Mockito to mock user input via Scanner
    }
}


