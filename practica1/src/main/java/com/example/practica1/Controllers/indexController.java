package com.example.practica1.Controllers;

import com.example.practica1.Models.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller

public class indexController {
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("title", "Practica 1");
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        User user = new User("Sebastian","Lopez","sebastian.lopez@gmail.com");
        model.addAttribute("title", "Profile");
        model.addAttribute("user", user.getName().concat(user.getLastname()));
        model.addAttribute("mail", user.getMail());
        return "profile";
    }
}
