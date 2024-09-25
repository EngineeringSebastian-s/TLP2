package practica.com.taller1.Controllers;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import practica.com.taller1.Models.DAO.cliente.IClienteDao;
import practica.com.taller1.Models.Entity.Cliente;

import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/Clientes")
public class ClienteController {

    @Autowired
    private IClienteDao clienteDao;

    @GetMapping({"", "/"})
    public String List(Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt) {
        model.addAttribute("Title", "Listado de Clientes");
        model.addAttribute("Client", clienteDao.findAll());
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
            model.addAttribute("ErrorDes", result.getAllErrors().get(0).getDefaultMessage());
            return "/Cliente/Form";
        }

        clienteDao.Save(cliente);
        return "redirect:/Clientes";
    }

    @GetMapping("/Edit/{id}")
    public String Edit(@PathVariable Long id, Model model) {
        if (id <= 0) {
            return "redirect:/Clientes";
        }

        Cliente cliente = clienteDao.findOne(id);

        if (cliente == null) {
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
            model.addAttribute("ErrorDes", result.getAllErrors().get(0).getDefaultMessage());
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

    @GetMapping("/Download")
    public void Download(HttpServletResponse response) {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=Clientes.csv");

        List<Cliente> clientes = clienteDao.findAll();
        try (PrintWriter writer = response.getWriter()) {
            writer.println("Id,Name,Lastname,Email,CreateAt");
            for (Cliente cliente : clientes) {
                writer.println(String.join(",",
                        String.valueOf(cliente.getId()),
                        cliente.getName(),
                        cliente.getLastname(),
                        cliente.getEmail(),
                        String.valueOf(cliente.getCreateAt())
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


