package practica.com.taller1.Models.DAO.encabezado;

import practica.com.taller1.Models.Entity.Encabezado;
import java.util.List;

public interface IEncabezadoDao {
    public List<Encabezado> findAll();

    public void Save(Encabezado encabezado);

    public Encabezado findOne(Long id);

    public void Delete(Long id);

    public void Drop();
}
