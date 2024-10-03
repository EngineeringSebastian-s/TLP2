package practica.com.taller1.Models.DAO.encabezado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import practica.com.taller1.Models.Entity.Encabezado;

import java.util.List;

@Repository
public class REncabezadoDao implements IEncabezadoDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Encabezado> findAll() {
        return em.createQuery("from Encabezado").getResultList();
    }

    @Transactional
    @Override
    public void Save(Encabezado encabezado) {
        if (encabezado.getId() != null && encabezado.getId() > 0) {
            em.merge(encabezado);
        } else {
            em.persist(encabezado);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Encabezado findOne(Long id) {
        return em.find(Encabezado.class, id);
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        Encabezado encabezado = findOne(id);
        if (encabezado != null) {
            em.remove(encabezado);
        }
    }

    @Transactional
    @Override
    public void Drop() {
        em.createQuery("delete from Encabezado").executeUpdate();
    }
}
