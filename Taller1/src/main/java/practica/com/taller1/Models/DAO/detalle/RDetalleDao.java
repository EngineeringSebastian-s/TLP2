package practica.com.taller1.Models.DAO.detalle;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import practica.com.taller1.Models.Entity.Detalle;

import java.util.List;

@Repository
public class RDetalleDao implements IDetalleDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Detalle> findAll() {
        return em.createQuery("from Detalle").getResultList();
    }

    @Transactional
    @Override
    public void Save(Detalle detalle) {
        if (detalle.getId() != null && detalle.getId() > 0) {
            em.merge(detalle);
        } else {
            em.persist(detalle);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Detalle findOne(Long id) {
        return em.find(Detalle.class, id);
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        Detalle detalle = findOne(id);
        if (detalle != null) {
            em.remove(detalle);
        }
    }

    @Transactional
    @Override
    public void Drop() {
        em.createQuery("delete from Detalle").executeUpdate();
    }

    // Implementación del método para encontrar detalles por Encabezado ID
    @Transactional(readOnly = true)
    @Override
    public List<Detalle> findByEncabezadoId(Long encabezadoId) {
        return em.createQuery("from Detalle where header.id = :encabezadoId", Detalle.class)
                .setParameter("encabezadoId", encabezadoId)
                .getResultList();
    }

}
