package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    private UserAuthenticationManager authenticationManager;

    @GetMapping("/register")
    public String registrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        if (authenticationManager.authenticateUser(username, password)) {
            model.addAttribute("message", "User already exists.");
            return "register";
        } else {
            authenticationManager.registerUser(username, password);
            model.addAttribute("message", "Registration successful. Please login.");
            return "login";
        }
    }
}
