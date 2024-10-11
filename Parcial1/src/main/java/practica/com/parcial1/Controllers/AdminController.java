package practica.com.parcial1.Controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica.com.parcial1.Models.DAO.user.IUserDao;
import practica.com.parcial1.Models.Entity.User;

import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/Administradores")
public class AdminController {
    @Autowired
    private IUserDao userDao;

    @GetMapping({"", "/"})
    public String List(Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt) {
        model.addAttribute("Title", "Listado de Administradores");
        model.addAttribute("Client", userDao.findAllAdmins());
        model.addAttribute("confirmDel", confirmDel);
        model.addAttribute("confirmEdt", confirmEdt);
        return "/Administrador/List";
    }

    @GetMapping("/Download")
    public void Download(HttpServletResponse response) {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=Administradores.csv");

        List<User> users = userDao.findAllAdmins();
        try (PrintWriter writer = response.getWriter()) {
            writer.println("Id,Name,Lastname,Email,CreateAt");
            for (User user : users) {
                writer.println(String.join(",",
                                String.valueOf(user.getId()),
                                user.getName(),
                                user.getLastname(),
                                user.getEmail(),
                                String.valueOf(user.getCreateAt())
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
