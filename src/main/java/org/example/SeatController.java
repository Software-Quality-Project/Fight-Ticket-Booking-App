package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SeatController {
    @Autowired
    private SeatManager seatManager;

    @GetMapping("/seat")
    public String seatForm(@RequestParam String flightNumber, Model model) {
        String availableSeats = seatManager.getAvailableSeats(flightNumber);
        model.addAttribute("availableSeats", availableSeats);
        model.addAttribute("flightNumber", flightNumber);
        return "seat";
    }

    @PostMapping("/seat")
    public String selectSeat(@RequestParam String flightNumber, @RequestParam String seatNumber, Model model) {
        boolean seatSelected = seatManager.selectSeat(flightNumber, seatNumber);
        if (seatSelected) {
            model.addAttribute("message", "Seat selected successfully. Proceed to payment.");
            return "redirect:/payment?flightNumber=" + flightNumber + "&seatNumber=" + seatNumber;
        } else {
            model.addAttribute("message", "Seat selection failed. Please try again.");
            return "redirect:/seat?flightNumber=" + flightNumber;
        }
    }
}