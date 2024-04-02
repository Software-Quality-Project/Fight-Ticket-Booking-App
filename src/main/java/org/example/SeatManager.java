package org.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
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
            return false;
        }

        return seatBooked;
    }

    // Method to get available seats for a flight
    public String getAvailableSeats(String flightNumber) {
        // Check if the flight exists
        if (!planeLayouts.containsKey(flightNumber)) {
            return "Flight " + flightNumber + " not found.";
        }

        // Get the plane layout for the flight
        PlaneLayout layout = planeLayouts.get(flightNumber);

        // StringBuilder to construct the available seats string
        StringBuilder sb = new StringBuilder();
        sb.append("Available seats for flight ").append(flightNumber).append(":\n");

        // Iterate over the layout to find available seats
        for (int i = 0; i < layout.getRows(); i++) {
            for (int j = 0; j < layout.getColumns(); j++) {
                if (layout.getSeatStatus(i, j) == 'O') {
                    sb.append((i + 1)).append("-").append((j + 1)).append(" "); // Append available seat
                }
            }
        }

        return sb.toString().trim(); // Return the constructed string
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

    public void cancelSeat(String flightNumber, String seatNumber) {
        // Check if the flight exists in the planeLayouts map
        if (!planeLayouts.containsKey(flightNumber)) {
            System.out.println("Flight " + flightNumber + " not found.");
            return;
        }

        // Get the plane layout for the specified flight
        PlaneLayout planeLayout = planeLayouts.get(flightNumber);

        // Convert seatNumber to row and column index, "row-column"
        String[] parts = seatNumber.split("-");
        if (parts.length != 2) {
            System.out.println("Invalid seat number format.");
            return;
        }

        try {
            int row = Integer.parseInt(parts[0]) - 1; // Convert to zero-based index
            int column = Integer.parseInt(parts[1]) - 1; // Convert to zero-based index

            // Check if the seat indices are valid
            if (row >= 0 && row < planeLayout.getRows() && column >= 0 && column < planeLayout.getColumns()) {
                char seatStatus = planeLayout.getSeatStatus(row, column);
                if (seatStatus == 'B') {
                    // Mark the seat as available again
                    planeLayout.getLayout()[row][column] = 'O'; // 'O' represents available seat
                    System.out.println("Seat " + seatNumber + " for flight " + flightNumber + " has been cancelled and is now available.");
                } else {
                    System.out.println("Seat " + seatNumber + " for flight " + flightNumber + " is not booked.");
                }
            } else {
                System.out.println("Invalid seat number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid seat number format.");
        }
    }

}

