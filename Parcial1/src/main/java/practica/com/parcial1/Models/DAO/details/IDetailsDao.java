package practica.com.parcial1.Models.DAO.details;

import practica.com.parcial1.Models.Entity.Detail;
import practica.com.parcial1.Models.Entity.Product;

import java.util.List;

public interface IDetailsDao {
    public List<Detail> findAll();

    public List<Detail> findAllOnePurchase(Long purchaseId);

    public void Save(Detail detail);

    public Detail findOne(Long id);

    public void Delete(Long id);

    public void DropDetailsOnePurchase(Long purchaseId);
}
