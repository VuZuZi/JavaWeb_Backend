package DAO;

import DTO.NoteDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class noteDAO implements INotesDAO{
    private static String jdbcURL = "jdbc:mysql://localhost:3306/notes?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "12341234";

    private static final String SELECT_ALL_NOTES = "SELECT id,title,des,type_name FROM notes.note n join type_note tn on n.type_id = tn.type_id";

    public noteDAO() {
    }
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
    public List<NoteDTO> selectAllNote()  {
        List<NoteDTO> list = new ArrayList<>();
        int n =1;

        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NOTES);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
//                System.out.println(id);
                String title = rs.getString("title");
                String des = rs.getString("des");
                String type = rs.getString("type_name");
                list.add(new NoteDTO(id,n++,title,des,type));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
