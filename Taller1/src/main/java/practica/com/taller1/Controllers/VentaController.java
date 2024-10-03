package practica.com.taller1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica.com.taller1.Models.DAO.venta.IVentaDao;

@Controller
@RequestMapping("/Ventas")
public class VentaController {
    @Autowired
    private IVentaDao ventaDao;

    @GetMapping({"/",""})
    public String List(Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt){
        model.addAttribute("Title", "Listado de Ventas");
        model.addAttribute("Sale", ventaDao.findAll());
        model.addAttribute("confirmDel", confirmDel);
        model.addAttribute("confirmEdt", confirmEdt);
        return "/Venta/List";
    }
}
