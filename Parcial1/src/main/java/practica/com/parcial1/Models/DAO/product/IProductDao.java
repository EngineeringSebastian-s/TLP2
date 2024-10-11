package practica.com.parcial1.Models.DAO.product;

import practica.com.parcial1.Models.Entity.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> findAll();

    public List<Product> findAnother(Long id);

    public void Save(Product product);

    public Product findOne(Long id);

    public void Delete(Long id);

    public void Drop();
}
