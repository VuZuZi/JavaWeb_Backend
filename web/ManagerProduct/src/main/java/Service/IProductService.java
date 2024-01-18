package Service;

import Model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void delById(int id);



    Product findById(int idU);

    void updateById(int id, String name, Double price);

    void createProduct(Product p);

    List<Product> findByKey(String k);
}
