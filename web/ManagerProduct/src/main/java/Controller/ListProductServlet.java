package Controller;
import Model.Product;
import Service.IProductService;
import Service.implement.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "productServlet",value = {"/", "/product"})
public class ListProductServlet extends HttpServlet{
    private String action = null;
    private IProductService iProductService = new ProductService();
    private List<Product> products;
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "search":
                String k = req.getParameter("key");
                System.out.println("day la k:"+k);
                List<Product> products2 = iProductService.findByKey(k);
                req.setAttribute("list",products2);
                req.getRequestDispatcher("./product/list.jsp").forward(req,resp);
                break;
            case "inf":
//                System.out.println("vao inf");
                int id = Integer.parseInt(req.getParameter("id"));
                System.out.println("id = "+id);
                Product pView = iProductService.findById(id);
                req.setAttribute("p",pView);
                req.getRequestDispatcher("./product/view.jsp").forward(req,resp);
            case "view":
                req.getRequestDispatcher("./product/view.jsp");break;
            case "create":
//
                req.getRequestDispatcher("./product/create.jsp").forward(req,resp);
                break;
            case "update":
                System.out.println("vao1");
                int idU = Integer.parseInt(req.getParameter("id"));
                Product product =  iProductService.findById(idU);
                req.setAttribute("pUpdate",product);
                req.getRequestDispatcher("./product/update.jsp").forward(req,resp);
                break;
            case "delete":
//                System.out.println("vao");
                int idD = Integer.parseInt(req.getParameter("id"));
                iProductService.delById(idD);
                req.setAttribute("list",products);
                req.getRequestDispatcher("./product/list.jsp").forward(req,resp);
                break;
            default:
                products = iProductService.findAll();
//                System.out.println("0000000000");
                req.setAttribute("list",products);
                req.getRequestDispatcher("./product/list.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    action = req.getParameter("action");
    if (action == null){
        action = "";
    }
    switch (action){
        case "create":
            System.out.println("create vào");
            int idC = Integer.parseInt(req.getParameter("id"));
            String nameC = req.getParameter("nameNew");
            Double priceC = Double.valueOf(req.getParameter("price"));
            Product p = new Product(idC,nameC,priceC);
            iProductService.createProduct(p);
            req.setAttribute("list",products);
            req.getRequestDispatcher("./product/list.jsp").forward(req,resp);

            break;
        case "update":
            System.out.println("vào 2");
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            Double price = Double.parseDouble(req.getParameter("price"));
            System.out.println("vao"+id+name+price);
            iProductService.updateById(id,name,price);
            req.setAttribute("list",products);
//            resp.sendRedirect("/");
            req.getRequestDispatcher("./product/list.jsp").forward(req,resp);

            break;
    }
    }
}
