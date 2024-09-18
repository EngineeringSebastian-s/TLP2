package practica.com.taller1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica.com.taller1.Models.DAO.producto.IProductoDao;

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
