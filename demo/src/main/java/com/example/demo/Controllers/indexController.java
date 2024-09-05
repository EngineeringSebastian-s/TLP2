package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Models.entity.Usuario;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/app")

public class indexController {
    @GetMapping({"/index","/"})
    public String index(Model model){
        model.addAttribute("Titulo", "Inicio");
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        Usuario usuario = new Usuario("Pepito","Perez","pp@mail.com");

        model.addAttribute("Titulo", "Perfil");
        model.addAttribute("Usuario", usuario.getNombre().concat(usuario.getApellido()));
        model.addAttribute("Correo", usuario.getEmail());
        return "perfil";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Usuario> usuarios = new ArrayList<>();
        model.addAttribute("Titulo", "Usuarios");

        usuarios.add(new Usuario("Pepito","Perez","Pepito.perez@gmail.com"));
        usuarios.add(new Usuario("Sarita","Perez","Sarita.perez@gmail.com"));
        usuarios.add(new Usuario("Samuel","Perez","Samuel.perez@gmail.com"));
        usuarios.add(new Usuario("Sultanito","Perez","Sultanito.perez@gmail.com"));

        model.addAttribute("Usuarios", usuarios);
        
        return "list";
    }

}
