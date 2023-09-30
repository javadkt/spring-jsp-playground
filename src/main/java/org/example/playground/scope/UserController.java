package org.example.playground.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserSession userSession;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        // Perform user authentication and retrieve user data
        String username = "javad";
        int userId = 123;

        // Store user data in the session-scoped bean
        userSession.setUsername(username);
        userSession.setUserId(userId);

        return "login";
    }

    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        // Access user data from the session-scoped bean
        String username = userSession.getUsername();
        int userId = userSession.getUserId();

        // Use the user data to customize the dashboard
        model.addAttribute("username", username);
        model.addAttribute("userId", userId);
        System.out.println("Dashboard Data: " +username);
        return "dashboard";
    }

    @RequestMapping("/logout")
    public String logout() {
        // Clear user session data when the user logs out
        userSession.clear();
        return "redirect:/login";
    }
}
