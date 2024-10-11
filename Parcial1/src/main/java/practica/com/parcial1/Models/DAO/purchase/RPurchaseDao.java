package practica.com.parcial1.Models.DAO.purchase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import practica.com.parcial1.Models.Entity.Purchase;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RPurchaseDao implements IPurchaseDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Purchase> findAll() {
        return em.createQuery("from Purchase", Purchase.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Purchase> findAnother(Long id) {
        List<Purchase> purchases = findAll();
        return purchases.stream()
                .filter(purchase -> !purchase.getId().equals(id))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void Save(Purchase purchase) {
        if (purchase.getId() != null && purchase.getId() > 0) {
            try {
                Purchase existingPurchase = em.find(Purchase.class, purchase.getId());
                if (existingPurchase != null) {
                    purchase.setDetails(existingPurchase.getDetails());
                    em.merge(purchase);
                }
            } catch (Exception e) {
                throw new PersistenceException(e);
            }
        } else {
            try {
                em.persist(purchase);
            } catch (Exception e) {
                throw new PersistenceException(e);
            }
        }
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
    public void Delete(Long id) {
        Purchase purchase = findOne(id);
        if (purchase != null) {
            em.remove(purchase);
        }
    }

    @Transactional
    @Override
    public void Drop() {
        List<Purchase> purchases = findAll();
        for (Purchase purchase : purchases) {
            em.remove(purchase);
        }
    }

}
