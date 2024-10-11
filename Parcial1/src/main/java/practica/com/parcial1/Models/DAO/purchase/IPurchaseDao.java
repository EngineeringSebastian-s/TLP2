package practica.com.parcial1.Models.DAO.purchase;

import practica.com.parcial1.Models.Entity.Purchase;

import java.util.List;

public interface IPurchaseDao {
    public List<Purchase> findAll();

    public List<Purchase> findAnother(Long id);

    public void Save(Purchase purchase);

    public Purchase findOne (Long id);

    public void Delete(Long id);

    public void Drop();
}
