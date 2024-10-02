package practica.com.parcial1.Models.DAO.producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import practica.com.parcial1.Models.Entity.Producto;

import java.util.List;

@Repository
public class RProductoDao implements IProductoDao {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {
        return em.createQuery("from Producto").getResultList();
    }

    @Transactional
    @Override
    public void Save(Producto producto) {

        if (producto.getId() != null && producto.getId() > 0) {
            em.merge(producto);
        } else {
            em.persist(producto);
        }

    }

    @Transactional(readOnly = true)
    @Override
    public Producto findOne(Long id) {
        return em.find(Producto.class, id);
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        Producto producto = findOne(id);
        em.remove(producto);
    }

    @Transactional
    @Override
    public void Drop() {
        em.createQuery("delete from Producto ").executeUpdate();
    }

}
