package com.jhoanlemos.ideas.controllers;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import com.jhoanlemos.ideas.models.User;
// import com.jhoanlemos.ideas.services.UserService;

// import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    // private final UserService userService;

    // public HomeController(UserService userService) {
    //     this.userService = userService;
    // }

    @GetMapping("/")
    public String home( @ModelAttribute("user") User user){
        return "index.jsp";
    }

    // @GetMapping("/ideas")
    // public String ideas(Model model,
    // HttpSession session
    // ){
    //     Long userId = (Long) session.getAttribute("userId");
    //     if (userId==null) {
    //         return "redirect:/";
    //     }
    //     User user = userService.finById(userId);
    //     model.addAttribute("user", user);
    //     return "ideas.jsp";
    // }
}
