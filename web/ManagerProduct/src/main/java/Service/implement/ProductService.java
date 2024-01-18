package Service.implement;

import Model.Product;
import Repository.IProductRepository;
import Repository.implement.ProductRepository;
import Service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void delById(int id) {
        iProductRepository.delById(id);
    }



    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void updateById(int id, String name, Double price) {
        iProductRepository.updateById(id,name,price);
    }

    @Override
    public void createProduct(Product p) {
        iProductRepository.createProduct(p);
    }

    @Override
    public List<Product> findByKey(String k) {

        return iProductRepository.findByKey(k);
    }
}
