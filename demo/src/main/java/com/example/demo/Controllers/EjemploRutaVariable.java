package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/variables")

public class EjemploRutaVariable {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Mandar atributos");
        return "/variables/index";
    }
    

    @GetMapping("/string/{texto}")
    public String variables(@PathVariable String texto, Model model){
        model.addAttribute("titulo","Ruta Variable");
        model.addAttribute("resultado","El texto enviado en la ruta es: " + texto);
        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable String texto,@PathVariable Integer numero, Model model){
        model.addAttribute("titulo","Ruta Variable");
        model.addAttribute("resultado","El mensaje : '" + texto + "' fue enviado " + numero + " veces");
        return "variables/ver";
    }
}
