package com.example.supabase.Controllers;

import com.example.supabase.Models.DAO.RUser;
import com.example.supabase.Models.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
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

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return RepositoryUser.findById(id).orElseThrow(()-> new RuntimeException("Usuario con id "+id+" no encontrado"));
    }

    @PostMapping
    public RUser createUser(@RequestBody User newUser) {
        return (RUser) RepositoryUser.save(newUser);
    }

    @PutMapping("/{id}")
    public RUser updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return (RUser) RepositoryUser.findById(id)
                .map(user ->{
                    user.setName(userDetails.getName());
                    user.setPassword(userDetails.getPassword());
                    user.setEmail(userDetails.getEmail());
                    user.setRole(userDetails.getRole());
                    return RepositoryUser.save(user);
                })
                .orElseGet(()->{
                    return RepositoryUser.save(userDetails);
                });
    }
}
