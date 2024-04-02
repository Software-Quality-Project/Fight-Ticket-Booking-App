package org.example;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {
    @Autowired
    private PaymentGatewayManager paymentGatewayManager;

    @Autowired
    private SeatManager seatManager;

    @Autowired
    private FlightInformationProvider flightInformationProvider;

    @Autowired
    private FlightTimeCalculator flightTimeCalculator;

    @Autowired
    private UserAuthenticationManager userAuthenticationManager;

    @GetMapping("/payment")
    public String paymentForm(@RequestParam String flightNumber, @RequestParam String seatNumber, Model model) {
        model.addAttribute("flightNumber", flightNumber);
        model.addAttribute("seatNumber", seatNumber);
        return "payment";
    }

    @PostMapping("/payment")
    public String processPayment(@RequestParam String flightNumber, @RequestParam String seatNumber, @RequestParam double amount, @RequestParam String cardNumber, @RequestParam String expiryDate, @RequestParam String cvv, Model model, HttpSession session) {
        boolean paymentSuccess = paymentGatewayManager.processPayment(amount, cardNumber, expiryDate, cvv);
        if (paymentSuccess) {
            // Get the flight information
            Flight flight = flightInformationProvider.getFlightInformation(flightNumber);
            String flightClass = flight.getFlightClass();
            String departureAirport = flight.getDepartureAirport();
            String destinationAirport = flight.getDestinationAirport();
            String departureDate = flight.getDepartureDate();
            String departureTime = flight.getDepartureTime();
            String arrivalDate = flight.getArrivalDate();
            String arrivalTime = flight.getArrivalTime();

            // Calculate the flight time
            int flightTime = flightTimeCalculator.calculateTotalFlightTime(departureTime, arrivalTime);

            // Create a new ticket and add it to the user
            Ticket ticket = new Ticket(flightNumber, seatNumber, flightClass, departureAirport, destinationAirport, departureDate, departureTime, arrivalDate, arrivalTime, flightTime);
            String username = (String) session.getAttribute("username");
            userAuthenticationManager.addTicketForUser(username, ticket);

            model.addAttribute("message", "Payment successful. Thank you for your purchase.");
            return "redirect:/viewBookings";
        } else {
            model.addAttribute("message", "Payment failed. Please check your payment information and try again.");
            seatManager.cancelSeat(flightNumber, seatNumber);
            return "redirect:/seat?flightNumber=" + flightNumber;
        }
    }
}