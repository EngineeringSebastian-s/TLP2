package practica.com.parcial1.Models.DAO.cliente;

import practica.com.parcial1.Models.Entity.Cliente;

import java.util.List;

public interface IClienteDao {
    public List<Cliente> findAll();

    public void Save(Cliente cliente);

    public Cliente findOne(Long id);

    public void Delete(Long id);

    public void Drop();
}
