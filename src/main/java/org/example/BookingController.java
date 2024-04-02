package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {
    @Autowired
    private FlightInformationProvider flightInformationProvider;

    @GetMapping("/booking")
    public String bookingForm(Model model) {
        model.addAttribute("flights", flightInformationProvider.getWeeklyFlights());
        return "booking";
    }

    @PostMapping("/booking")
    public String bookFlight(@RequestParam String flightNumber, Model model) {
        Flight flight = flightInformationProvider.getFlightInformation(flightNumber);
        model.addAttribute("flight", flight);
        return "redirect:/seat?flightNumber=" + flightNumber;
    }
}