package practica.com.parcial1.Controllers;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import practica.com.parcial1.Models.DAO.product.IProductDao;
import practica.com.parcial1.Models.Entity.Product;

import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/Productos")
public class ProductController {
    @Autowired
    private IProductDao productoDao;

    @GetMapping({"", "/"})
    public String Listar(Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt) {
        model.addAttribute("Title", "Listado de Productos");
        model.addAttribute("Product", productoDao.findAll());
        model.addAttribute("confirmDel", confirmDel);
        model.addAttribute("confirmEdt", confirmEdt);
        return "/Producto/List";
    }

    @GetMapping("/Create/")
    public String Create(Model model) {

        Product product = new Product();

        model.addAttribute("Product", product);
        model.addAttribute("Title", "Formulario de Producto");
        model.addAttribute("TextButton", "Crear Producto");
        model.addAttribute("Action", "Create");

        return "/Producto/Form";
    }

    @PostMapping("/Create/")
    public String Save(@Valid Product product, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("Product", product);
            model.addAttribute("Title", "Formulario de Producto");
            model.addAttribute("TextButton", "Crear Producto");
            model.addAttribute("Action", "Create");
            model.addAttribute("ErrorCtr", "true");
            model.addAttribute("ErrorDes", result.getAllErrors().get(0).getDefaultMessage());
            return "/Producto/Form";
        }

        productoDao.Save(product);
        return "redirect:/Productos";
    }

    @GetMapping("/Edit/{id}")
    public String Edit(@PathVariable Long id, Model model) {
        if (id <= 0) {
            return "redirect:/Clientes";
        }

        Product product = productoDao.findOne(id);

        if (product == null) {
            return "redirect:/Productos";
        }
        model.addAttribute("Product", product);
        model.addAttribute("Title", "Formulario de Producto");
        model.addAttribute("TextButton", "Editar Producto");
        model.addAttribute("Action", "Edit");
        return "/Producto/Form";
    }

    @PostMapping("/Edit/{id}")
    public String Edit(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("Product", product);
            model.addAttribute("Title", "Formulario de Producto");
            model.addAttribute("TextButton", "Editar Producto");
            model.addAttribute("Action", "Edit");
            model.addAttribute("ErrorEdt", "true");
            model.addAttribute("ErrorDes", result.getAllErrors().get(0).getDefaultMessage());
            return "/Producto/Form";
        }

        productoDao.Save(product);
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

    @GetMapping("/Download")
    public void Download(HttpServletResponse response) {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=Productos.csv");

        List<Product> products = productoDao.findAll();
        try (PrintWriter writer = response.getWriter()) {
            writer.println("Id,Name,Description,UnitValue,Stock");
            for (Product product : products) {
                writer.println(String.join(",",
                                String.valueOf(product.getId()),
                                product.getName(),
                                product.getDescription(),
                                String.valueOf(product.getUnitValue())
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
