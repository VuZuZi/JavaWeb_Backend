package DAO;

import DTO.ProductDTO;
import model.ModelSource;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    void insert(ProductDTO p)throws SQLException;

    List<ProductDTO> selectAllProduct ();

    boolean deleteProdcut(int id) throws SQLException;

    boolean updateProduct(ProductDTO p) throws SQLException;

    List<ProductDTO> searchByName(String key);

    ProductDTO getModelById(int id);

    List<ProductDTO> searchByPrice(String key);
}
