package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;;


@Controller

public class indexController {
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("Titulo", "Clase taller 2");
        return "index";
    }
}
