package com.example.demo_h2.Models.Entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "lastname")
    private String Lastname;
    @Column(name = "email")
    private String Email;
    @Column(name = "create_at")
    private Date CreateAt;

    public Cliente(Long id, String name, String lastname, String email, Date createAt) {
        Id = id;
        Name = name;
        Lastname = lastname;
        Email = email;
        CreateAt = createAt;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getLastname() {
        return Lastname;
    }
    public void setLastname(String lastname) {
        Lastname = lastname;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public Date getCreateAt() {
        return CreateAt;
    }
    public void setCreateAt(Date createAt) {
        CreateAt = createAt;
    }

    
}
