package practica.com.parcial1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping({"", "/", "/Home"})
    public String index(Model model) {
        model.addAttribute("Title", "Home E-Commerce");
        return "Index";
    }

    @GetMapping("/App")
    public String indexClient(Model model) {
        model.addAttribute("Title", "Dashboard E-Commerce");
        return "/Cliente/Index";
    }

    @GetMapping("/Admin")
    public String indexAdmin(Model model) {
        model.addAttribute("Title", "Admin E-Commerce");
        return "/Administrador/Index";
    }
}
