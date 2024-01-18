package Repository.implement;

import Model.Product;
import Repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();
    static{
        productList.add(new Product(1,"ip4",300));
        productList.add(new Product(2,"ip5",400));
        productList.add(new Product(3,"ip6",500));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void delById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                productList.remove(i);
            }
        }
    }



    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void updateById(int id, String name, Double price) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                productList.get(i).setName(name);
                productList.get(i).setPrice(price);
                break;
            }
        }
    }

    @Override
    public void createProduct(Product p) {
        productList.add(p);
    }

    @Override
    public List<Product> findByKey(String k) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(k)){
                products.add(productList.get(i));
            }
        }
        return products;
    }
}
