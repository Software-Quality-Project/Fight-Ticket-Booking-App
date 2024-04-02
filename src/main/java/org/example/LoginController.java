package org.example;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserAuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        if (authenticationManager.authenticateUser(username, password)) {
            session.setAttribute("username", username);
            model.addAttribute("username", username);
            return "redirect:/booking";
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }
}
