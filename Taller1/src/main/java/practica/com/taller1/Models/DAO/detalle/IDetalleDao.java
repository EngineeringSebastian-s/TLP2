package practica.com.taller1.Models.DAO.detalle;

import practica.com.taller1.Models.Entity.Detalle;
import java.util.List;

public interface IDetalleDao {
    public List<Detalle> findAll();

    public void Save(Detalle detalle);

    public Detalle findOne(Long id);

    public void Delete(Long id);

    public void Drop();

    public List<Detalle> findByEncabezadoId(Long encabezadoId);
}
