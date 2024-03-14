package org.example;

import java.util.HashMap;
import java.util.Map;

public class SeatManager {

    private Map<String, PlaneLayout> planeLayouts;

    public SeatManager() {
        // Initialize the map to store plane layouts
        planeLayouts = new HashMap<>();


        // Load plane layouts for existing flights
        loadPlaneLayouts();
    }

    // Method to load plane layouts for existing flights
    private void loadPlaneLayouts() {
       // create plane layouts for two flights
        PlaneLayout DTK253Layout = new PlaneLayout(3, 2);
        // Marking one seat as booked
        DTK253Layout.bookSeat("2-1");
        // Store layout for flight DTK253
        planeLayouts.put("DTK253", DTK253Layout);

        // Layout for flight XYZ456
        PlaneLayout xyz456Layout = new PlaneLayout(2, 3);
        // Marking one seat as booked
        xyz456Layout.bookSeat("1-2");
        // Store layout for flight XYZ456
        planeLayouts.put("XYZ456", xyz456Layout);
    }

    // Method to select a seat for a flight
    public boolean selectSeat(String flightNumber, String seatNumber) {
        // Check if the flight exists
        if (!planeLayouts.containsKey(flightNumber)) {
            System.out.println("Flight " + flightNumber + " not found.");
            return false;
        }

        // Get the plane layout for the flight
        PlaneLayout layout = planeLayouts.get(flightNumber);
        // Attempt to book the seat
        boolean seatBooked = layout.bookSeat(seatNumber);

        // Display appropriate message based on seat booking result
        if (seatBooked) {
            System.out.println("Seat " + seatNumber + " successfully booked for flight " + flightNumber + ".");
        } else {
            System.out.println("Seat " + seatNumber + " is already booked or invalid.");
        }

        return seatBooked;
    }

    // Method to get available seats for a flight
    public void getAvailableSeats(String flightNumber) {
        // Check if the flight exists
        if (!planeLayouts.containsKey(flightNumber)) {
            System.out.println("Flight " + flightNumber + " not found.");
            return;
        }

        // Get the plane layout for the flight
        PlaneLayout layout = planeLayouts.get(flightNumber);
        // Display available seats for the flight
        System.out.println("Available seats for flight " + flightNumber + ":");
        layout.displayAvailableSeats();
    }

    // Method to view plane layout for a flight
    public void viewPlaneLayout(String flightNumber) {
        // Check if the flight exists
        if (!planeLayouts.containsKey(flightNumber)) {
            System.out.println("Flight " + flightNumber + " not found.");
            return;
        }

        // Get the plane layout for the flight
        PlaneLayout layout = planeLayouts.get(flightNumber);
        // Display plane layout for the flight
        System.out.println("Plane layout for flight " + flightNumber + ":");
        layout.displayPlaneLayout();
    }
}

