package practica.com.parcial1.Models.DAO.product;

import practica.com.parcial1.Models.Entity.Product;

import java.util.List;

public interface IProductDao {
    List<Product> findAll();

    List<Product> findAnother(Long id);

    void Save(Product product);

    Product findOne(Long id);

    void Delete(Long id);

    void Drop();
}
