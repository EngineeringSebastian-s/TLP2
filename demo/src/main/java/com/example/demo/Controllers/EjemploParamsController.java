package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/params")

public class EjemploParamsController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Recibir Parametros del Request HTTP GET");
        return "params/index";
    }
    

    @GetMapping("/mix-params")
    public String variables(@RequestParam(name="saludo", required = false, defaultValue = "Sin mensaje") String texto,@RequestParam Integer numero, Model model){
        model.addAttribute("titulo","Parametros GET");
        model.addAttribute("resultado","El mensaje : '" + texto + "' fue enviado " + numero + " veces");
        return "params/ver";
    }

    @GetMapping("/string")
    public String variables(@RequestParam String texto, Model model){
        model.addAttribute("titulo","Parametros GET");
        model.addAttribute("resultado","El mensaje enviado es : '" + texto);
        return "params/ver";
    }
}
