package com.example.demo.Models.entity;

public class Usuario {
    private String Nombre,Apellido,Email;
 
     
    
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String email) {
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


}
