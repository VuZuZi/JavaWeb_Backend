package Repository;

import Model.Product;

import java.util.List;

public interface IProductRepository {
List<Product> findAll();

    void delById(int id);



    Product findById(int id);

    void updateById(int id, String name, Double price);

    void createProduct(Product p);

    List<Product> findByKey(String k);
}
