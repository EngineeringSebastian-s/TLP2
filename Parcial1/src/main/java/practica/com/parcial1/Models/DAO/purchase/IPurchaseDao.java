package practica.com.parcial1.Models.DAO.purchase;

import practica.com.parcial1.Models.Entity.Purchase;

import java.util.List;

public interface IPurchaseDao {
    List<Purchase> findAll();

    Purchase Save(Purchase purchase);

    Purchase findOne (Long id);

    void Delete(Long id);

    public void Drop();
}
