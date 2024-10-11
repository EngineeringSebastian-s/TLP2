package practica.com.parcial1.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import practica.com.parcial1.Models.DAO.details.IDetailsDao;
import practica.com.parcial1.Models.DAO.product.IProductDao;
import practica.com.parcial1.Models.DAO.purchase.IPurchaseDao;
import practica.com.parcial1.Models.Entity.Detail;
import practica.com.parcial1.Models.Entity.Product;
import practica.com.parcial1.Models.Entity.Purchase;

import java.util.List;

@Controller
@RequestMapping("/Detalles")
public class DetailsController {
    @Autowired
    private IDetailsDao detailsDao;
    private final IProductDao productDao;
    private final IPurchaseDao purchaseDao;

    public DetailsController(IProductDao productDao, IPurchaseDao purchaseDao) {
        this.productDao = productDao;
        this.purchaseDao = purchaseDao;
    }


    @GetMapping({"/{id_purchase}"})
    public String List(@PathVariable Long id_purchase, Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt) {
        if (!detailsDao.findAllOnePurchase(id_purchase).isEmpty()) {
            model.addAttribute("Title", "Detalles de Ventas");
            model.addAttribute("details", detailsDao.findAllOnePurchase(id_purchase));
            model.addAttribute("confirmDel", confirmDel);
            model.addAttribute("confirmEdt", confirmEdt);
            return "/Detalles/List";
        }
        return "redirect:/Ventas?confirmDel=true";
    }

    @GetMapping("/Create/")
    public String Create(Model model) {

        Detail detail = new Detail();

        model.addAttribute("Detail", detail);
        List<Product> products = productDao.findAnother(0L);
        List<Purchase> purchases = purchaseDao.findAnother(0L);
        model.addAttribute("Products", products);
        model.addAttribute("Purchases", purchases);
        model.addAttribute("Title", "Formulario de Detalles");
        model.addAttribute("TextButton", "Crear Detalle");
        model.addAttribute("Action", "Create");

        return "/Detalles/Form";
    }

    @PostMapping("/Create/")
    public String Save(@Valid Detail detail, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("Detail", detail);
            List<Product> products = productDao.findAnother(0L);
            List<Purchase> purchases = purchaseDao.findAnother(0L);
            model.addAttribute("Products", products);
            model.addAttribute("Purchases", purchases);
            model.addAttribute("Title", "Formulario de Detalles");
            model.addAttribute("TextButton", "Crear Detalle");
            model.addAttribute("Action", "Create");
            model.addAttribute("ErrorCtr", "true");
            model.addAttribute("ErrorDes", result.getAllErrors().get(0).getDefaultMessage());
            return "/Detalles/Form";
        }
        detailsDao.Save(detail);
        return "redirect:/Ventas";
    }

    @GetMapping("/Edit/{id}")
    public String Edit(@PathVariable Long id, Model model) {
        if (id <= 0) {
            return "redirect:/Ventas";
        }


        Detail detail = detailsDao.findOne(id);

        if (detail == null) {
            return "redirect:/Ventas";
        }

        List<Product> products = productDao.findAnother(detail.getProduct().getId());
        List<Purchase> purchases = purchaseDao.findAnother(detail.getPurchase().getId());

        model.addAttribute("Detail", detail);
        model.addAttribute("Products", products);
        model.addAttribute("Purchases", purchases);
        model.addAttribute("Title", "Formulario de Detalles");
        model.addAttribute("TextButton", "Editar Detalle");
        model.addAttribute("Action", "Edit");
        return "/Detalles/Form";
    }

    @PostMapping("/Edit/{id}")
    public String Edit(@Valid Detail detail, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("Detail", detail);
            List<Product> products = productDao.findAnother(detail.getProduct().getId());
            List<Purchase> purchases = purchaseDao.findAnother(detail.getPurchase().getId());
            model.addAttribute("Products", products);
            model.addAttribute("Purchases", purchases);
            model.addAttribute("Title", "Formulario de Detalles");
            model.addAttribute("TextButton", "Editar Detalle");
            model.addAttribute("Action", "Edit");
            model.addAttribute("ErrorEdt", "true");
            model.addAttribute("ErrorDes", result.getAllErrors().get(0).getDefaultMessage());
            return "/Detalles/Form";
        }

        detailsDao.Save(detail);
        return "redirect:/Ventas";
    }

    @GetMapping("/Delete/{id_purchase}")
    public String Delete(@PathVariable Long id_purchase) {
        Detail detail = detailsDao.findOne(id_purchase);
        Long purchaseId = detail.getPurchase().getId();
        if (id_purchase > 0) {
            detailsDao.Delete(id_purchase);

            if (detailsDao.findAllOnePurchase(purchaseId).isEmpty()) {
                return "redirect:/Ventas/?confirmDel=true";
            }
        }

        return "redirect:/Detalles/" + purchaseId + "?confirmDel=true";
    }

    @GetMapping("/Drop")
    public String Drop() {
        List<Detail> details = detailsDao.findAll();
        Long purchaseId = details.get(0).getPurchase().getId();
        detailsDao.DropDetailsOnePurchase(purchaseId);
        return "redirect:/Ventas/?confirmDel=true";
    }
}
