package controller;


import DAO.IProductDAO;
import DAO.ProductDAO;
import DTO.ProductDTO;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "servlet", value = {"/", "/product"})
public class ProductServlet extends HttpServlet {
    private String message;
    private IProductDAO dao;

    public void init() {
        dao = new ProductDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
//            System.out.println("----ACtion: "+action);
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "permision":


                    break;

                case "priceSearch":
                    String pKey = request.getParameter("priceSearch");
                    searchByPrice(request,response,pKey);
//                        System.out.println("---------1111dssadsasad------"+country);
                    break;
                case "searchByName":
                    String key = request.getParameter("nameSearch");
                    searchByName(request,response,key);
//                        System.out.println("---------1111dssadsasad------"+key);
                    break;
                case "create":
                    createProduct(request,response);
                    break;
                case "edit":
                    break;
                case "delete":
                    deleteProduct(request,response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void searchByPrice(HttpServletRequest request, HttpServletResponse response, String key) throws ServletException, IOException {
        List<ProductDTO> list = dao.searchByPrice(key);
        request.setAttribute("list", list);
        request.setAttribute("key",key);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response, String key) throws ServletException, IOException {
        List<ProductDTO> list = dao.searchByName(key);
        request.setAttribute("list", list);
        request.setAttribute("key",key);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.deleteProdcut(id);

        List<ProductDTO> list = dao.selectAllProduct();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDTO> list = dao.selectAllProduct();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString() );
//        }
        request.setAttribute("a","done");
        request.setAttribute("list",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertProduct(request, response);
                    break;
                case "edit":
                    updateProduct(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {

    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        int quan = Integer.valueOf(request.getParameter("quan"));
        String color = request.getParameter("color");
        String des = request.getParameter("des");
        ProductDTO product = new ProductDTO(name, price,quan,color,des);
        dao.insert(product);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//            dispatcher.forward(request, response);
        response.sendRedirect("/product");
    }

    public void destroy() {
    }
}
