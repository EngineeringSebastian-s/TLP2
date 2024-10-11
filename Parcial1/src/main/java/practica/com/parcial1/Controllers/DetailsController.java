package practica.com.parcial1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica.com.parcial1.Models.DAO.details.IDetailsDao;

@Controller
@RequestMapping("/Detalles")
public class DetailsController {
    @Autowired
    private IDetailsDao detailsDao;

    @GetMapping({"/{id}"})
    public String List(@PathVariable Long id, Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt){
        model.addAttribute("Title", "Detalles de Ventas");
        model.addAttribute("details", detailsDao.findAllOnePurchase(id));
        model.addAttribute("confirmDel", confirmDel);
        model.addAttribute("confirmEdt", confirmEdt);
        return "/Detalles/List";
    }

    @GetMapping("/Delete/{id}")
    public String Delete(@PathVariable Long id) {

        if (id > 0) {
            detailsDao.Delete(id);
        }
        return "redirect:/Detalles?confirmDel=true";
    }

    @GetMapping("/Drop")
    public String Drop() {
        detailsDao.Drop();
        return "redirect:/Productos?confirmDel=true";
    }
}
