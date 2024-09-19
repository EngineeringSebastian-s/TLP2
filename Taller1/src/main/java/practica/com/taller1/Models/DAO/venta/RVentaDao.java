package practica.com.taller1.Models.DAO.venta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import practica.com.taller1.Models.Entity.Venta;

import java.util.List;

@Repository
public class RVentaDao implements IVentaDao {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Venta> findAll() {
        return em.createQuery("from Venta").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Venta findOne(Long id) {
        return em.find(Venta.class, id);
    }
}
