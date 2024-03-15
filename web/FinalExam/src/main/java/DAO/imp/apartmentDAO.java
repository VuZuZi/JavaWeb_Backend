package DAO.imp;

import DAO.iApartmentDAO;
import DTO.phongDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class apartmentDAO implements iApartmentDAO {
    public apartmentDAO() {
    }

    private static String jdbcURL = "jdbc:mysql://localhost:3306/apartment?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "12341234";
    private static final String SELECT_ALL_LIST = "SELECT p.id as 'ma_p', nt.ten as 'ten', nt.phone as 'sdt',hd.ngay_bat_dau as 'ngay', ht.kieu as 'kieu',p.ghi_chu " +
            "FROM hop_dong hd join phong p on hd.id_phong = p.id " +
            "join nguoi_thue nt on hd.id_nguoi_thue = nt.id " +
            "join hinh_thuc_thanh_toan ht on hd.id_thanh_toan = ht.id";
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
                System.out.println();
                int st = stt;
                String maP = rs.getString("ma_p");
                String ten = rs.getString("ten");
                String sdt = rs.getString("sdt");
                String ngay = rs.getString("ngay");
                String kieu = rs.getString("kieu");
                String note = rs.getString("ghi_chu");
                System.out.println(maP + "============"+ ten + "============="+ sdt + "============="+ "============="+ngay+ "============="+kieu+"======"+note);
//                        p.id as 'ma_p', nt.ten as 'ten', nt.phone as 'sdt',hd.ngay_bat_dau as 'ngay', ht.kieu as 'kieu',p.ghi_chu
//                phongDTO dto = new phongDTO( stt,
//                            rs.getString("ma_p"),
//                                rs.getString("ten"),
//                                rs.getString("sdt"),
//                                rs.getString("ngay"),
//                                rs.getString("kieu"),
//                                rs.getString("ghi_chu")
//                        );
                list.add(new phongDTO(st,maP,ten,sdt,ngay,kieu,note));
                stt++;
//                System.out.println("=============="+dto.getTenKhachHang());
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("loi o day-----------------");
        }
        return list;
    }

//    public static void main(String[] args) {
//        iApartmentDAO dao = new apartmentDAO();
//        System.out.println("start");
//        try {
//            System.out.println("1");
//            dao.getConnection();
//            System.out.println("done");
//        }catch (Exception e){
//            System.out.println("eeeeee:"+e);
//        }
//        System.out.println("donee");
//    }

}
