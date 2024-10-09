package practica.com.parcial1.Models.DAO.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import practica.com.parcial1.Models.Entity.Product;

import java.util.List;

@Repository
public class RProductDao implements IProductDao {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return em.createQuery("from Product").getResultList();
    }

    @Transactional
    @Override
    public void Save(Product product) {

        if (product.getId() != null && product.getId() > 0) {
            em.merge(product);
        } else {
            em.persist(product);
        }

    }

    @Transactional(readOnly = true)
    @Override
    public Product findOne(Long id) {
        return em.find(Product.class, id);
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        Product product = findOne(id);
        em.remove(product);
    }

    @Transactional
    @Override
    public void Drop() {
        em.createQuery("delete from Inventory ").executeUpdate();
        em.createQuery("delete from Product ").executeUpdate();
    }

}
