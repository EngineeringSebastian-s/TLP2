package practica.com.parcial1.Controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica.com.parcial1.Models.DAO.purchase.IPurchaseDao;
import practica.com.parcial1.Models.Entity.Purchase;
import practica.com.parcial1.Models.Entity.User;

import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/Ventas")
public class PurchaseController {
    @Autowired
    private IPurchaseDao purchaseDao;

    @GetMapping({"/",""})
    public String List(Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt){
        model.addAttribute("Title", "Listado de Ventas");
        model.addAttribute("Sales", purchaseDao.findAll());
        model.addAttribute("confirmDel", confirmDel);
        model.addAttribute("confirmEdt", confirmEdt);
        return "/Compras/List";
    }

    @GetMapping("/Delete/{id}")
    public String Delete(@PathVariable Long id) {

        if (id > 0) {
            purchaseDao.Delete(id);
        }
        return "redirect:/Ventas?confirmDel=true";
    }

    @GetMapping("/Drop")
    public String Drop() {
        purchaseDao.Drop();
        return "redirect:/Ventas?confirmDel=true";
    }

    @GetMapping("/Download")
    public void Download(HttpServletResponse response) {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=Ventas.csv");

        List<Purchase> purchases = purchaseDao.findAll();
        try (PrintWriter writer = response.getWriter()) {
            writer.println("Id,Client,Products,Discount,SubTotal,Total,CreateAt");
            for (Purchase purchase : purchases) {
                writer.println(String.join(",",
                                String.valueOf(purchase.getId()),
                                purchase.getUser().getName() + purchase.getUser().getLastname(),
                                String.valueOf(purchase.getDetails().size()),
                                String.valueOf(purchase.getDiscountTotal()),
                                String.valueOf(purchase.getSubTotal()),
                                String.valueOf(purchase.getTotal()),
                                String.valueOf(purchase.getDate())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
