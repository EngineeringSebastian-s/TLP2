package com.example.demo_h2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo_h2.Models.DAO.IClienteDao;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ClientesController {
    @Autowired
    private IClienteDao clienteDao;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("Titulo", "Listado de Clientes");
        model.addAttribute("Clientes", clienteDao.findAll());
        return "listar";
    }
}
