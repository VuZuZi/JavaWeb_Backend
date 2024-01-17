package com.example.list_customer;



import Model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "customerServlet", value = "/customer", loadOnStartup = 1)
public class CustomerServlet extends HttpServlet {
    private String message;
    private List a = new ArrayList<Customer>();
    public void init() {
        message = "Hello World!";
        a.add(new Customer("NgA","1/1/2001","Hà Nội","image/1.jpeg"));
        a.add(new Customer("NgB","1/1/2001","Hà Nội", "image/2.jpeg"));
        a.add(new Customer("NgC","1/1/2001","Hà Nội","image/image4.jpg"));
        a.add(new Customer("NgD","1/1/2001","Hà Nội","image/1.jpeg"));
        a.add(new Customer("NgE","1/1/2001","Hà Nội","image/1.jpeg"));
        a.add(new Customer("NgF","1/1/2001","Hà Nội","image/1.jpeg"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("list",a);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}