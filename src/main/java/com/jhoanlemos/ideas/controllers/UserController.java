package com.jhoanlemos.ideas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhoanlemos.ideas.models.User;
import com.jhoanlemos.ideas.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/new")
    public String nuevo(
        @Valid @ModelAttribute("user") User user, 
        BindingResult result,
        HttpSession session
        ){
            if (userService.emailDuplicated(user.getEmail())) {
                FieldError error = new FieldError("email", "email", "El email ya se encuentra registrado");
                result.addError(error);
            }
            System.out.println("error");
            System.out.println(userService.invalidPassword(user));
            if (userService.invalidPassword(user)) {
                FieldError error = new FieldError("passwordConfirmation", "passwordConfirmation", "La contraseña no coincide");
                result.addError(error);
            }
            
            if (result.hasErrors()) {
                return "index.jsp";
            }

            userService.save(user);
            if (session.getAttribute("userId") == null) {
                session.setAttribute("userId", user.getId());
            }

            return "redirect:/ideas";
        }
}
