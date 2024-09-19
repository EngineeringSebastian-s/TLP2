package practica.com.taller1.Models.DAO.venta;

import practica.com.taller1.Models.Entity.Venta;

import java.util.List;

public interface IVentaDao {
    public List<Venta> findAll();
    public Venta findOne(Long id);
}
