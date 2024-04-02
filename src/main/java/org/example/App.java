package org.example;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static UserAuthenticationManager authenticationManager = new UserAuthenticationManager();
    private static SeatManager seatManager = new SeatManager();
    private static PaymentGatewayManager paymentGatewayManager = new PaymentGatewayManager();

    public static void main(String[] args) {
        try {
            // Get username and password from the user
            String username = getUsername();
            String password = getPassword();

            // Authenticate the user
            if (!authenticateUser(username, password)) {
                System.out.println("Authentication failed for user " + username + ".");
                return;
            }

            System.out.println("User " + username + " authenticated successfully.");

            // Flight booking
            bookFlight();
        } catch (Exception e) {
            // Catch any unexpected exceptions
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String getUsername() {
        System.out.print("Enter your username: ");
        return scanner.nextLine();
    }

    private static String getPassword() {
        System.out.print("Enter your password: ");
        return scanner.nextLine();
    }

    private static boolean authenticateUser(String username, String password) {
        return authenticationManager.authenticateUser(username, password);
    }

    private static void bookFlight() {
        try {
            // Prompt the user to enter the flight number
            System.out.print("Enter the flight number,pls: ");
            String flightNumber = scanner.nextLine();

            // Get available seats for the given flight
            String availableSeats = seatManager.getAvailableSeats(flightNumber);
            if (availableSeats.startsWith("Flight")) {
                // Print the message indicating the flight is not found
                System.out.println(availableSeats);

                // Prompt the user to try again with a valid flight number
                while (true) {
                    System.out.print("Please enter a valid flight number: ");
                    flightNumber = scanner.nextLine();
                    availableSeats = seatManager.getAvailableSeats(flightNumber);
                    if (!availableSeats.startsWith("Flight")) {
                        // If a valid flight number is entered, break out of the loop
                        break;
                    }
                    System.out.println("Flight not found. Please try again.");
                }
            }

            // Display available seats
            System.out.println(availableSeats);

            // Prompt the user to select a seat
            System.out.print("Enter the seat number you want to book: ");
            String seatNumber = scanner.nextLine();

            // Book the selected seat
            boolean seatBooked = seatManager.selectSeat(flightNumber, seatNumber);

            if (seatBooked) {
                // We assume the amount for booking the seat is $100.00
                double amount = 100.00;

                // Display the price to the user
                System.out.println("The price for booking the seat is: $" + amount);

                // Prompt the user for payment information
                System.out.print("Enter your card number: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Enter the expiry date (MM/YY): ");
                String expiryDate = scanner.nextLine();
                System.out.print("Enter the CVV: ");
                String cvv = scanner.nextLine();

                // Process payment
                boolean paymentSuccess = paymentGatewayManager.processPayment(amount, cardNumber, expiryDate, cvv);

                // Check if payment was successful
                if (paymentSuccess) {
                    // If payment is successful, print booking confirmation
                    System.out.println("Payment successful. Seat booking confirmed.");
                } else {
                    // If payment fails, cancel the booked seat
                    System.out.println("Payment failed. Seat booking cancelled.");
                    seatManager.cancelSeat(flightNumber, seatNumber);
                }
            } else {
                System.out.println("Failed to book seat " + seatNumber + " for flight " + flightNumber + ". Please try again.");
            }

            // Prompt the user to cancel the booking if they want
            System.out.print("Do you want to cancel the booking? (yes/no): ");
            String cancelOption = scanner.nextLine().trim().toLowerCase();
            if (cancelOption.equals("yes")) {
                // Cancel the booking
                seatManager.cancelSeat(flightNumber, seatNumber);
                System.out.println("Booking cancelled successfully.");
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

