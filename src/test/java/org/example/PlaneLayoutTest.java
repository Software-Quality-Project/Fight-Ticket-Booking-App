package org.example;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlaneLayoutTest {

    private PlaneLayout planeLayout;

    @Before
    public void setUp() {

        // Create a plane layout with 3 rows and 2 columns
        planeLayout = new PlaneLayout(3, 2);
    }

    @Test
    public void testBookSeat() {
        // Test booking a seat
        assertTrue(planeLayout.bookSeat("1-1"));

        // Test booking an already booked seat
        assertFalse(planeLayout.bookSeat("1-1"));

        // Test booking an invalid seat format
        assertFalse(planeLayout.bookSeat("1"));

        // Test booking a seat out of bounds
        assertFalse(planeLayout.bookSeat("4-3"));
    }

    @Test
    public void testDisplayAvailableSeats() {
        // Test displaying available seats
        assertEquals("1-1 1-2 2-1 2-2 3-1 3-2", planeLayout.displayAvailableSeats());

        // Book a seat and test displaying available seats again
        planeLayout.bookSeat("1-1");
        assertEquals("1-2 2-1 2-2 3-1 3-2", planeLayout.displayAvailableSeats());
    }

    @Test
    public void testDisplayPlaneLayout() {
        // Test displaying plane layout
        assertEquals("O O \nO O \nO O \n", planeLayout.displayPlaneLayout());
    }
}


