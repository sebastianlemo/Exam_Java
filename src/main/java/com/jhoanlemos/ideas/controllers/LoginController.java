package com.jhoanlemos.ideas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jhoanlemos.ideas.models.User;
import com.jhoanlemos.ideas.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(
        @RequestParam("email") String email,
        @RequestParam("password") String password,
        HttpSession session,
        RedirectAttributes redirectAttributes
    ){
        User user = userService.login(email, password);
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "Contraseña o Usuario Invalido");
            return "redirect:/";
        }
        
        if (session.getAttribute("userId")==null) {
            session.setAttribute("userId", user.getId());
        }

        return "redirect:/ideas";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
