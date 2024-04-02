package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SeatManagerTest {

    private SeatManager seatManager;

    @Before
    public void setUp() {
        seatManager = new SeatManager();
    }

    @Test
    public void testSelectSeat() {
        // Test booking a seat
        assertTrue(seatManager.selectSeat("DTK253", "1-1"));

        // Test booking an already booked seat
        assertFalse(seatManager.selectSeat("DTK253", "2-1"));

        // Test booking a seat on a non-existing flight
        assertFalse(seatManager.selectSeat("DEF789", "1-1"));
    }

    @Test
    public void testGetAvailableSeats() {
        // Test getting available seats
        System.out.println("Available seats for flight DTK253:");
        seatManager.getAvailableSeats("DTK253");

        // Test getting available seats for a non-existing flight
        System.out.println("Available seats for flight DEF789:");
        seatManager.getAvailableSeats("DEF789");
    }

    @Test
    public void testViewPlaneLayout() {
        // Test viewing plane layout
        System.out.println("Plane layout for flight DTK253:");
        seatManager.viewPlaneLayout("DTK253");

        // Test viewing plane layout for a non-existing flight
        System.out.println("Plane layout for flight DEF789:");
        seatManager.viewPlaneLayout("DEF789");
    }
}
