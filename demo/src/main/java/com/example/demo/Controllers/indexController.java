package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Models.entity.Usuario;

import org.springframework.ui.Model;;


@Controller

public class indexController {
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("Titulo", "Clase taller 2");
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        Usuario usuario = new Usuario("Pepito","Perez","pp@mail.com");

        model.addAttribute("Titulo", "Clase taller 2");
        model.addAttribute("Usuario", usuario.getNombre().concat(usuario.getApellido()));
        model.addAttribute("Correo", usuario.getEmail());
        return "perfil";
    }

}
