package com.example.demo_h2.Models.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo_h2.Models.Entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ClienteDaoImp implements IClienteDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        // TODO Auto-generated method stub
        return em.createQuery("from cliente ").getResultList();
    }

}
