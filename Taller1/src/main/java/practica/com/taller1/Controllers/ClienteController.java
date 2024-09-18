package practica.com.taller1.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import practica.com.taller1.Models.DAO.cliente.IClienteDao;
import practica.com.taller1.Models.Entity.Cliente;

@Controller
@RequestMapping("/Clientes")
public class ClienteController {

    @Autowired
    private IClienteDao clienteDao;

    @GetMapping({"", "/"})
    public String Listar(Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt) {
        model.addAttribute("titulo", "Listado de Clientes");
        model.addAttribute("cliente", clienteDao.findAll());
        model.addAttribute("confirmDel", confirmDel);
        model.addAttribute("confirmEdt", confirmEdt);
        return "/Cliente/List";
    }

    @GetMapping("/Create/")
    public String Create(Model model) {

        Cliente cliente = new Cliente();

        model.addAttribute("Client", cliente);
        model.addAttribute("Title", "Formulario de Cliente");
        model.addAttribute("TextButton", "Crear Cliente");
        model.addAttribute("Action", "Create");

        return "/Cliente/Form";
    }

    @PostMapping("/Create/")
    public String Save(@Valid Cliente cliente, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("Client", cliente);
            model.addAttribute("Title", "Formulario de Cliente");
            model.addAttribute("TextButton", "Crear Cliente");
            model.addAttribute("Action", "Create");
            model.addAttribute("ErrorCtr", "true");
            return "/Cliente/Form";
        }

        clienteDao.Save(cliente);
        return "redirect:/Clientes";
    }

    @GetMapping("/Edit/{id}")
    public String Edit(@PathVariable Long id, Model model) {
        Cliente cliente = null;

        if (id > 0) {
            cliente = clienteDao.findOne(id);
        } else {
            return "redirect:/Clientes";
        }
        model.addAttribute("Client", cliente);
        model.addAttribute("Title", "Formulario de Cliente");
        model.addAttribute("TextButton", "Editar Cliente");
        model.addAttribute("Action", "Edit");
        return "/Cliente/Form";
    }

    @PostMapping("/Edit/{id}")
    public String Edit(@Valid Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("Client", cliente);
            model.addAttribute("Title", "Formulario de Cliente");
            model.addAttribute("TextButton", "Editar Cliente");
            model.addAttribute("Action", "Edit");
            model.addAttribute("ErrorEdt", "true");
            return "/Cliente/Form";
        }

        clienteDao.Save(cliente);
        return "redirect:/Clientes";
    }

    @GetMapping("/Delete/{id}")
    public String Delete(@PathVariable Long id) {

        if (id > 0) {
            clienteDao.Delete(id);
        }
        return "redirect:/Clientes?confirmDel=true";
    }

    @GetMapping("/Drop")
    public String Drop() {
        clienteDao.Drop();
        return "redirect:/Clientes?confirmDel=true";
    }

}


