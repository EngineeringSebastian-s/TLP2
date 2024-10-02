package practica.com.taller1.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import practica.com.taller1.Models.DAO.encabezado.IEncabezadoDao;
import practica.com.taller1.Models.DAO.detalle.IDetalleDao;
import practica.com.taller1.Models.Entity.Encabezado;
import practica.com.taller1.Models.Entity.Detalle;

import java.util.List;

@Controller
@RequestMapping("/Compras")
public class CompraController {

    @Autowired
    private IEncabezadoDao encabezadoDao;

    @Autowired
    private IDetalleDao detalleDao;

    @GetMapping({"", "/"})
    public String Listar(Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt) {
        model.addAttribute("Title", "Listado de Compras");
        model.addAttribute("Encabezados", encabezadoDao.findAll());
        model.addAttribute("confirmDel", confirmDel);
        model.addAttribute("confirmEdt", confirmEdt);
        return "/Compra/List";
    }

    @GetMapping("/Create/")
    public String Create(Model model) {
        Encabezado encabezado = new Encabezado();
        model.addAttribute("Encabezado", encabezado);
        model.addAttribute("Title", "Formulario de Compra");
        model.addAttribute("TextButton", "Crear Compra");
        model.addAttribute("Action", "Create");
        return "/Compra/Form";
    }

    @PostMapping("/Create/")
    public String Save(@Valid Encabezado encabezado, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("Encabezado", encabezado);
            model.addAttribute("Title", "Formulario de Compra");
            model.addAttribute("TextButton", "Crear Compra");
            model.addAttribute("Action", "Create");
            model.addAttribute("ErrorCtr", "true");
            model.addAttribute("ErrorDes", result.getAllErrors().get(0).getDefaultMessage());
            return "/Compra/Form";
        }

        encabezadoDao.Save(encabezado);
        return "redirect:/Compras";
    }

    @GetMapping("/Details/{id}")
    public String Detalles(@PathVariable Long id, Model model) {
        Encabezado encabezado = encabezadoDao.findOne(id);
        if (encabezado == null) {
            return "redirect:/Compras";
        }

        List<Detalle> detalles = detalleDao.findByEncabezadoId(id);
        model.addAttribute("Encabezado", encabezado);
        model.addAttribute("Detalles", detalles);
        return "/Compra/Details";
    }

    @GetMapping("/Delete/{id}")
    public String Delete(@PathVariable Long id) {

        if (id > 0) {
            encabezadoDao.Delete(id);
        }
        return "redirect:/Compras?confirmDel=true";
    }

    @GetMapping("/Drop")
    public String Drop() {
        encabezadoDao.Drop();
        detalleDao.Drop();
        return "redirect:/Compras?confirmDel=true";
    }
}
