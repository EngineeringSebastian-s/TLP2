package practica.com.parcial1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica.com.parcial1.Models.DAO.purchase.IPurchaseDao;

@Controller
@RequestMapping("/Ventas")
public class PurchaseController {
    @Autowired
    private IPurchaseDao purchaseDao;

    @GetMapping({"/",""})
    public String List(Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt){
        model.addAttribute("Title", "Listado de Ventas");
        model.addAttribute("Sale", purchaseDao.findAll());
        model.addAttribute("confirmDel", confirmDel);
        model.addAttribute("confirmEdt", confirmEdt);
        return "/Compras/List";
    }
}
