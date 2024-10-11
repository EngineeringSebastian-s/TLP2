package practica.com.parcial1.Controllers;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import practica.com.parcial1.Models.DAO.user.IUserDao;
import practica.com.parcial1.Models.Entity.User;

import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/Clientes")
public class ClientController {

    @Autowired
    private IUserDao userDao;

    @GetMapping({"", "/"})
    public String List(Model model, @RequestParam(required = false) boolean confirmDel, @RequestParam(required = false) boolean confirmEdt) {
        model.addAttribute("Title", "Listado de Clientes");
        model.addAttribute("Client", userDao.findAllClients());
        model.addAttribute("confirmDel", confirmDel);
        model.addAttribute("confirmEdt", confirmEdt);
        return "/Cliente/List";
    }

    @GetMapping("/Create/")
    public String Create(Model model) {

        User user = new User();

        model.addAttribute("Client", user);
        model.addAttribute("Title", "Formulario de Cliente");
        model.addAttribute("TextButton", "Crear Cliente");
        model.addAttribute("Action", "Create");

        return "/Cliente/Form";
    }

    @PostMapping("/Create/")
    public String Save(@Valid User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("Client", user);
            model.addAttribute("Title", "Formulario de Cliente");
            model.addAttribute("TextButton", "Crear Cliente");
            model.addAttribute("Action", "Create");
            model.addAttribute("ErrorCtr", "true");
            model.addAttribute("ErrorDes", result.getAllErrors().get(0).getDefaultMessage());
            return "/Cliente/Form";
        }

        userDao.Save(user);
        return "redirect:/Clientes";
    }

    @GetMapping("/Edit/{id}")
    public String Edit(@PathVariable Long id, Model model) {
        if (id <= 0) {
            return "redirect:/Clientes";
        }

        User user = userDao.findOne(id);

        if (user == null) {
            return "redirect:/Clientes";
        }
        model.addAttribute("Client", user);
        model.addAttribute("Title", "Formulario de Cliente");
        model.addAttribute("TextButton", "Editar Cliente");
        model.addAttribute("Action", "Edit");
        return "/Cliente/Form";
    }

    @PostMapping("/Edit/{id}")
    public String Edit(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("Client", user);
            model.addAttribute("Title", "Formulario de Cliente");
            model.addAttribute("TextButton", "Editar Cliente");
            model.addAttribute("Action", "Edit");
            model.addAttribute("ErrorEdt", "true");
            model.addAttribute("ErrorDes", result.getAllErrors().get(0).getDefaultMessage());
            return "/Cliente/Form";
        }

        userDao.Save(user);
        return "redirect:/Clientes";
    }

    @GetMapping("/Delete/{id}")
    public String Delete(@PathVariable Long id) {

        if (id > 0) {
            userDao.Delete(id);
        }
        return "redirect:/Clientes?confirmDel=true";
    }

    @GetMapping("/Drop")
    public String Drop() {
        userDao.Drop();
        return "redirect:/Clientes?confirmDel=true";
    }

    @GetMapping("/Download")
    public void Download(HttpServletResponse response) {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=Clientes.csv");

        List<User> users = userDao.findAllClients();
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


