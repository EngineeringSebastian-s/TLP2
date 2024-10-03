package practica.com.parcial1.Models.DAO.producto;

import practica.com.parcial1.Models.Entity.Producto;

import java.util.List;

public interface IProductoDao {
    public List<Producto> findAll();

    public void Save(Producto producto);

    public Producto findOne(Long id);

    public void Delete(Long id);

    public void Drop();
}
