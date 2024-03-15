package DAO.imp;

import DAO.IApart;
import DTO.phongDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class apartmentDAO implements IApart {
    public apartmentDAO() {
    }

    private static String jdbcURL = "jdbc:mysql://localhost:3306/apartment?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "12341234";
    private static final String SELECT_ALL_LIST = "SELECT p.id as 'ma_p', nt.ten as 'ten', nt.phone as 'sdt',hd.ngay_bat_dau as 'ngayBatDau', ht.kieu as 'hinhThuc',p.ghi_chu as 'ghiChu' FROM hop_dong hd join phong p on hd.id_phong = p.id join nguoi_thue nt on hd.id_nguoi_thue = nt.id join hinh_thuc_thanh_toan ht on hd.id_thanh_toan = ht.id";
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
    public List<phongDTO> selectAllInf() {
        List<phongDTO> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LIST);
            ResultSet rs = preparedStatement.executeQuery();
            int stt = 1;
            while (rs.next()){

                       phongDTO p =  new phongDTO( stt++,rs.getString("ma_p"),
                                rs.getString("ten"),
                                rs.getString("sdt"),
                                rs.getString("ngayBatDau"),
                                rs.getString("hinhThuc"),
                                rs.getString("ghiChu"));
                        list.add(p);
                System.out.println(p.toString());

                System.out.println(stt);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    public static void main(String[] args) {
        IApart dao = new apartmentDAO();
        System.out.println("start");
        dao.selectAllInf();
        try {
            System.out.println("1");
            ((apartmentDAO) dao).getConnection();
            System.out.println("done");
        }catch (Exception e){
            System.out.println("eeeeee:"+e);
        }
        System.out.println("donee");
    }

}
