package org.example;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewBookingsController {
    @Autowired
    private UserAuthenticationManager userAuthenticationManager;


    @GetMapping("/viewBookings")
    public String viewBookings(HttpSession session, Model model) {
    String username = (String) session.getAttribute("username");
    List<Ticket> tickets = userAuthenticationManager.getTicketsForUser(username);
    model.addAttribute("tickets", tickets);
    return "viewBookings";
}
}
