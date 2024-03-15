package DAO;

import DTO.ProductDTO;
import model.ModelSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{
    private static String jdbcURL = "jdbc:mysql://localhost:3306/manager_product?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "12341234";

    private static final String SELECT_ALL_PRODUCT = "SELECT p.id,p.ten,p.gia, p.so_luong,p.mau,p.mo_ta, dm.ten_muc FROM manager_product.product p join danh_muc dm on p.id_muc = dm.id;";
    private static final String DELETE_PRODUCT_SQL = "delete from product where id = ?;";
    private static final String FIND_BY_NAME = "SELECT p.id,p.ten,p.gia, p.so_luong,p.mau,p.mo_ta, dm.ten_muc FROM manager_product.product p join danh_muc dm on p.id_muc = dm.id where ten like ?;";
    private static final String FIND_BY_PRICE = "SELECT p.id,p.ten,p.gia, p.so_luong,p.mau,p.mo_ta, dm.ten_muc FROM manager_product.product p join danh_muc dm on p.id_muc = dm.id where gia <= ?;";

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insert(ProductDTO p) throws SQLException {

    }

    @Override
    public List<ProductDTO> selectAllProduct() {
        List<ProductDTO> list = new ArrayList<>();
        int stt = 0;

        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                double gia = rs.getDouble("gia");
                int so_luong = rs.getInt("so_luong");
                String mau = rs.getString("mau");
                String mo_ta = rs.getString("mo_ta");
                String ten_muc = rs.getString("ten_muc");
                 ProductDTO dto = new ProductDTO(++stt,id,ten,gia,so_luong,mau,mo_ta,ten_muc);
//                System.out.println(dto.toString());
                 list.add(dto);
//                int id, String ten, double gia, int so_luong, String mau, String mo_ta, String ten_muc
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public boolean deleteProdcut(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(ProductDTO p) throws SQLException {
        return false;
    }

    @Override
    public List<ProductDTO> searchByName(String key) {
        List<ProductDTO> list = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
        ) {
            preparedStatement.setString(1,'%'+key+"%");
            System.out.println("=================");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            int stt = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                double gia = rs.getDouble("gia");
                int so_luong = rs.getInt("so_luong");
                String mau = rs.getString("mau");
                String mo_ta = rs.getString("mo_ta");
                String ten_muc = rs.getString("ten_muc");
                ProductDTO dto = new ProductDTO(++stt,id,ten,gia,so_luong,mau,mo_ta,ten_muc);
                System.out.println("search by name-------------------");
                System.out.println(dto.toString());
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ProductDTO getModelById(int id) {
        return null;
    }

    @Override
    public List<ProductDTO> searchByPrice(String key) {
        List<ProductDTO> list = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_PRICE);
        ) {
            preparedStatement.setString(1,key);
            System.out.println("=================");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            int stt = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                double gia = rs.getDouble("gia");
                int so_luong = rs.getInt("so_luong");
                String mau = rs.getString("mau");
                String mo_ta = rs.getString("mo_ta");
                String ten_muc = rs.getString("ten_muc");
                ProductDTO dto = new ProductDTO(++stt,id,ten,gia,so_luong,mau,mo_ta,ten_muc);
                System.out.println("search by name-------------------");
//                System.out.println(dto.toString());
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
