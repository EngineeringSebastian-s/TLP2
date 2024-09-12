package com.example.demo_h2.Models.DAO;

import java.util.List;

import com.example.demo_h2.Models.Entity.Cliente;

public interface IClienteDao {
    public List<Cliente> findAll();
}
