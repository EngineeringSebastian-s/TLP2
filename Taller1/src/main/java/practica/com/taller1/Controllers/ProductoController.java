package practica.com.taller1.Controllers;

import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import practica.com.taller1.Models.DAO.producto.IProductoDao;
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

    @GetMapping("/Drop")
    public String Drop() {
        productoDao.Drop();
        return "redirect:/Productos?confirmDel=true";
    }
}
