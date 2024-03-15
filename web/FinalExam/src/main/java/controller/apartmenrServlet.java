package controller;
import DAO.iApartmentDAO;
import DAO.imp.apartmentDAO;
import DTO.phongDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "apartmentServlet", value = {"/", "/apartment"})

public class apartmenrServlet extends HttpServlet{
    private iApartmentDAO dao;
    @Override
    public void init() throws ServletException {
        dao = new apartmentDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
//            System.out.println("----ACtion: "+action);
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "delete":
                    deleteHd(req, resp);
                    break;
                default:
//                    System.out.println("vo day");
                    listApart(req, resp);
//                    System.out.println("dome");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void deleteHd(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
    private void listApart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<phongDTO> listA = dao.selectAllInf();
//        List<phongDTO> listA = new ArrayList<>();
//        listA.add(new phongDTO(1,"s","s","s","s","s","s"));
        String a = "a";
        request.setAttribute("a",a);
        System.out.println("1");
        request.setAttribute("l", listA);
        System.out.println("2");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);
    }

}
