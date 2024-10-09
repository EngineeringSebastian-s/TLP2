package practica.com.parcial1.Models.DAO.purchase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import practica.com.parcial1.Models.Entity.Purchase;

import java.util.List;

@Repository
public class RPurchaseDao implements IPurchaseDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Purchase> findAll() {

        List<Purchase> purchases = em.createQuery("from Purchase", Purchase.class).getResultList();
        return purchases;
    }

    @Transactional
    @Override
    public Purchase save(Purchase purchase) {
            if (purchase.getId() != null && purchase.getId() > 0) {
                Purchase existingPurchase = em.find(Purchase.class, purchase.getId());
                if (existingPurchase != null) {
                    purchase = em.merge(purchase);
                }
            } else {
                em.persist(purchase);
            }
        return purchase;
    }

    @Transactional(readOnly = true)
    @Override
    public Purchase findOne(Long id) {
        Purchase purchase = null;
        purchase = em.find(Purchase.class, id);
        return purchase;
    }

    @Transactional
    @Override
    public void delete(Long id) { // Cambiado de Delete a delete
            Purchase purchase = findOne(id);
            if (purchase != null) {
                em.remove(purchase);
            }
    }

}
