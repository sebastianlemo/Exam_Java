package com.jhoanlemos.ideas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jhoanlemos.ideas.models.Idea;
import com.jhoanlemos.ideas.models.User;
import com.jhoanlemos.ideas.services.IdeaService;
import com.jhoanlemos.ideas.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ideas")
public class IdeasController {
    
    private final UserService userService;
    private final IdeaService ideaService;    

    public IdeasController(UserService userService, IdeaService ideaService) {
        this.userService = userService;
        this.ideaService = ideaService;
    }


    @GetMapping("")
    public String ideas(Model model,
    HttpSession session
    ){
        Long userId = (Long) session.getAttribute("userId");
        if (userId==null) {
            return "redirect:/";
        }
        // Idea idea = (Idea) session.getAttribute("idea");
        // User userCrea = (User) idea.getUser();
        User user = userService.finById(userId);

        model.addAttribute("user", user);
        model.addAttribute("ideas", ideaService.findAll());
        // model.addAttribute("userCrea", userCrea);
        return "ideas.jsp";
    }


    @GetMapping("/new")
    public String ideaNew( @ModelAttribute("idea") Idea idea,
    HttpSession session, 
    Model model){
        Long userId = (Long) session.getAttribute("userId");
        if (userId==null) {
            return "redirect:/";
        }
        return "crearIdea.jsp";
    }

    @GetMapping("/{ideasId}")
    public String mostrar(
    @PathVariable("ideasId") Long id,
    Model model,
    HttpSession session
    ){   
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        Idea idea = ideaService.findById(id);
        if (idea ==null) {
            return "redirect:/ideas";
        }
        model.addAttribute("idea", idea);
        model.addAttribute("userId", userId);
        return "mostrarIdea.jsp";
    }

    @GetMapping("/{ideasId}/edit")
    public String edit(
        @PathVariable("ideasId") Long id,
        Model model,
        HttpSession session
    ){
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        Idea idea = ideaService.findById(id);
        User user = idea.getUser();
        if (user.getId()!=userId) {
            return "redirect:/ideas";
        }

        model.addAttribute("idea", idea);

        return "editIdea.jsp";
    }

    @PutMapping("/{ideasId}/update")
    public String update(
        @PathVariable("ideasId") Long id,@Valid  @ModelAttribute("idea") Idea idea, BindingResult result, RedirectAttributes redirectAttributes
    ){
        
        Idea ideaU = ideaService.findById(id);
        User user =(User) ideaU.getUser();

        // if (result.hasErrors()) {
        //     FieldError error = new FieldError("description", "description", "no puede estar vacio");
        //     result.addError(error);
        //     return "redirect:/ideas/{ideasId}/edit";
        // }

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Tiene que tener en 3 y 50 caracteres");
            return "redirect:/ideas/{ideasId}/edit";
        }

        ideaService.update(id, idea, user);

        return "redirect:/ideas";
    }





    @PostMapping("/new")
    public String createIdea(@Valid @ModelAttribute("idea") Idea idea,
    BindingResult result,
    HttpSession session
    ){  
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.finById(userId);
        if (userId==null) {
            return "redirect:/";
        }
        // if (idea.equals(null)) {
        //     redirectAttributes.addFlashAttribute("error", "No puede estar vacio");
        //     return "redirect:/ideas/new";
        // }
        if (result.hasErrors()) {
            FieldError error = new FieldError("description", "description", "vacio");
            result.addError(error);
            return "crearIdea.jsp";
        }
        ideaService.save(idea, user);
        // session.setAttribute("idea", idea);
        // System.out.println("idea");
        // System.out.println(session.getAttribute("idea"));
        return "redirect:/ideas";
    }


}
