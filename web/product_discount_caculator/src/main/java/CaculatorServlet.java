import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/caculator")
public class CaculatorServlet  extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String des = req.getParameter("des");
        Double price = Double.parseDouble(req.getParameter("price"));
        Double percent = Double.parseDouble(req.getParameter("dis"));
        Double discount_amount = price * percent * 0.01;
        price = price-discount_amount;
        req.setAttribute("des",des);
        req.setAttribute("disA",discount_amount);
        req.setAttribute("pri",price);
        System.out.println("heree");
        RequestDispatcher dispatcher = req.getRequestDispatcher("show.jsp");
        dispatcher.forward(req, resp);

    }



    public void destroy() {
    }
}