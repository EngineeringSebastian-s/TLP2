package practica.com.parcial1.Models.DAO.details;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import practica.com.parcial1.Models.Entity.Detail;

import java.util.List;

@Repository
public class RDetailsDao implements IDetailsDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Detail> findAll() {
        return em.createQuery("from Detail").getResultList();
    }

    @Transactional
    @Override
    public void Save(Detail detail) {
        if (detail.getId() != null && detail.getId() > 0) {
            em.merge(detail);
        } else {
            em.persist(detail);
        }

    }

    @Transactional(readOnly = true)
    @Override
    public Detail findOne(Long id) {
        return em.find(Detail.class, id);
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        Detail detail = findOne(id);
        em.remove(detail);
    }

    @Transactional
    @Override
    public void Drop() {
        List<Detail> details = findAll();
        for (Detail detail : details) {
            em.remove(detail);
        }
    }
}
