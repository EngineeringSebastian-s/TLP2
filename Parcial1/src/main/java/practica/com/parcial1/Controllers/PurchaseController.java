package practica.com.parcial1.Controllers;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import practica.com.parcial1.Models.DAO.purchase.IPurchaseDao;
import practica.com.parcial1.Models.DAO.user.IUserDao;
import practica.com.parcial1.Models.Entity.Product;
import practica.com.parcial1.Models.Entity.Purchase;
import practica.com.parcial1.Models.Entity.User;

import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/Ventas")
public class PurchaseController {
    @Autowired
    private IPurchaseDao purchaseDao;
    private final IUserDao userDao;

    public PurchaseController(IUserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping({"/", ""})
    public String List(Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt) {
        model.addAttribute("Title", "Listado de Ventas");
        model.addAttribute("Sales", purchaseDao.findAll());
        model.addAttribute("confirmDel", confirmDel);
        model.addAttribute("confirmEdt", confirmEdt);
        return "/Compras/List";
    }

    @GetMapping("/Create/")
    public String Create(Model model) {

        Purchase purchase = new Purchase();

        model.addAttribute("Sale", purchase);
        model.addAttribute("Title", "Formulario de Compra");
        model.addAttribute("TextButton", "Hacer Compra");
        model.addAttribute("Action", "Create");

        return "/Compras/Form";
    }

    @PostMapping("/Create/")
    public String Save(@Valid Purchase purchase, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("Sale", purchase);
            model.addAttribute("Title", "Formulario de Compras");
            model.addAttribute("TextButton", "Hacer Compra");
            model.addAttribute("Action", "Create");
            model.addAttribute("ErrorCtr", "true");
            model.addAttribute("ErrorDes", result.getAllErrors().get(0).getDefaultMessage());
            return "/Compras/Form";
        }

        purchaseDao.Save(purchase);
        return "redirect:/Ventas";
    }

    @GetMapping("/Edit/{id}")
    public String Edit(@PathVariable Long id, Model model) {
        if (id <= 0) {
            return "redirect:/Ventas";
        }
        Purchase purchase = purchaseDao.findOne(id);

        if (purchase == null) {
            return "redirect:/Ventas";
        }

        List<User> users = userDao.findAnotherClients(purchase.getUser().getId());
        model.addAttribute("Sale", purchase);
        model.addAttribute("Users", users);
        model.addAttribute("Title", "Formulario de Ventas");
        model.addAttribute("TextButton", "Editar Venta");
        model.addAttribute("Action", "Edit");
        return "/Compras/Form";
    }

    @PostMapping("/Edit/{id}")
    public String Edit(@Valid Purchase purchase, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("Sale", purchase);
            List<User> users = userDao.findAnotherClients(purchase.getUser().getId());
            model.addAttribute("Users", users);
            model.addAttribute("Title", "Formulario de Ventas");
            model.addAttribute("TextButton", "Editar Venta");
            model.addAttribute("Action", "Edit");
            model.addAttribute("ErrorEdt", "true");
            model.addAttribute("ErrorDes", result.getAllErrors().get(0).getDefaultMessage());
            return "/Compras/Form";
        }

        purchaseDao.Save(purchase);
        return "redirect:/Ventas";
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
