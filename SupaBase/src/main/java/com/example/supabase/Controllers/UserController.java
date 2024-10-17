package com.example.supabase.Controllers;

import com.example.supabase.Models.DAO.RUser;
import com.example.supabase.Models.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuarios")
public class UserController {
    @Autowired
    private RUser RepositoryUser;

    @GetMapping
    public List<User> getAllUsers() {
        return RepositoryUser.findAll();
    }

    @PostMapping
    public RUser createUser(@RequestBody User user) {
        return (RUser) RepositoryUser.save(user);
    }

    @PutMapping("/{id}")
    public RUser updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = RepositoryUser.findById(id).orElseThrow()-> new RuntimeException("Usuario no encontrado");
        user.setName(userDetails.getName());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        user.setCreateAt(userDetails.getCreateAt());

        return RepositoryUser.save(user);
    }
}
