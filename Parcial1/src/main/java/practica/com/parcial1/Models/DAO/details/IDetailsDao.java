package practica.com.parcial1.Models.DAO.details;

import practica.com.parcial1.Models.Entity.Detail;
import practica.com.parcial1.Models.Entity.Product;

import java.util.List;

public interface IDetailsDao {
    List<Detail> findAll();

    List<Detail> findAllOnePurchase(Long purchaseId);

    void Save(Detail detail);

    Detail findOne(Long id);

    void Delete(Long id);

    void DropDetailsOnePurchase(Long purchaseId);
}
