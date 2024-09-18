package practica.com.taller1.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import practica.com.taller1.Models.DAO.producto.IProductoDao;
import practica.com.taller1.Models.Entity.Cliente;
import practica.com.taller1.Models.Entity.Producto;

@Controller
@RequestMapping("/Productos")
public class ProductoController {
    @Autowired
    private IProductoDao productoDao;

    @GetMapping({"", "/"})
    public String Listar(Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt) {
        model.addAttribute("titulo", "Listado de Productos");
        model.addAttribute("producto", productoDao.findAll());
        model.addAttribute("confirmDel", confirmDel);
        model.addAttribute("confirmEdt", confirmEdt);
        return "/Producto/List";
    }

    @GetMapping("/Create/")
    public String Create(Model model) {

        Producto producto = new Producto();

        model.addAttribute("Product", producto);
        model.addAttribute("Title", "Formulario de Cliente");
        model.addAttribute("TextButton", "Crear Producto");
        model.addAttribute("Action", "Create");

        return "/Producto/Form";
    }

    @PostMapping("/Create/")
    public String Save(@Valid Producto producto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("Product", producto);
            model.addAttribute("Title", "Formulario de Cliente");
            model.addAttribute("TextButton", "Crear Producto");
            model.addAttribute("Action", "Create");
            model.addAttribute("ErrorCtr", "true");
            return "/Producto/Form";
        }

        productoDao.Save(producto);
        return "redirect:/Productos";
    }

    @GetMapping("/Edit/{id}")
    public String Edit(@PathVariable Long id, Model model) {
        if (id <= 0) {
            return "redirect:/Clientes";
        }

        Producto producto = productoDao.findOne(id);

        if (producto == null) {
            return "redirect:/Productos";
        }
        model.addAttribute("Product", producto);
        model.addAttribute("Title", "Formulario de Cliente");
        model.addAttribute("TextButton", "Editar Producto");
        model.addAttribute("Action", "Edit");
        return "/Producto/Form";
    }

    @PostMapping("/Edit/{id}")
    public String Edit(@Valid Producto producto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("Product", producto);
            model.addAttribute("Title", "Formulario de Producto");
            model.addAttribute("TextButton", "Editar Producto");
            model.addAttribute("Action", "Edit");
            model.addAttribute("ErrorEdt", "true");
            return "/Producto/Form";
        }

        productoDao.Save(producto);
        return "redirect:/Productos";
    }

    @GetMapping("/Delete/{id}")
    public String Delete(@PathVariable Long id) {

        if (id > 0) {
            productoDao.Delete(id);
        }
        return "redirect:/Productos?confirmDel=true";
    }

    @GetMapping("/Drop")
    public String Drop() {
        productoDao.Drop();
        return "redirect:/Productos?confirmDel=true";
    }
}
