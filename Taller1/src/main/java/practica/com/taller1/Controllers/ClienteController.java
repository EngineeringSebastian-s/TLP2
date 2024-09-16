package practica.com.taller1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import practica.com.taller1.Models.DAO.cliente.IClienteDao;
import practica.com.taller1.Models.Entity.Cliente;

import jakarta.validation.Valid;

@Controller
public class ClienteController {

    @Autowired
    private IClienteDao clienteDao;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/listar")
    public String Listar(Model model) {
        model.addAttribute("titulo", "Listado de Clientes");
        model.addAttribute("cliente", clienteDao.findAll());
        return "listar";
    }

    @GetMapping("/form")
    public String crear(Model model) {

        Cliente cliente = new Cliente();

        model.addAttribute("titulo", "Formulario de Cliente");
        model.addAttribute("cliente", cliente);

        return "form";
    }

    //1
    // @PostMapping("/form")
    // public String Guardar(Cliente cliente)
    // {
    //     clienteDao.Save(cliente);

    //     return "redirect:listar";
    // }

    @PostMapping("/form") //para validar se  agrega el valid y el bindingResul, estos siempre deben estar juntos uno tras otro
    public String Guardar(@Valid Cliente cliente, BindingResult result, Model model)
    {

        if(result.hasErrors())
        {
            model.addAttribute("titulo", "Formulario de Cliente ********");
            return "form";
        }

        clienteDao.Save(cliente);
        //Status.setComplete();
        return "redirect:listar";
    }

    @GetMapping("/form/{id}")
    public String Editar(@PathVariable Long id, Model model){
        Cliente cliente=null;

        if(id>0){
            cliente=clienteDao.findOne(id);
        }else{
            return "redirect:/listar";
        }
        model.addAttribute("cliente", cliente);
        model.addAttribute("titulo", "Editar Cliente");
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String Eliminar(@PathVariable Long id){

        if(id>0){
            clienteDao.Delete(id);
        }
        return "redirect:listar";
    }

}


