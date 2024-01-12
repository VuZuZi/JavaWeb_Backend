package com.example.demo1;

import java.io.*;
import java.util.Date;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

//        // Hello
        PrintWriter out = response.getWriter();
        Date today = new Date();

        out.println("<html><body>");
        out.println("<h1>" + today + "</h1>");
        out.println("</body></html>");

//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//
//
//        writer.println("<h1>" + today + "</h1>");
//        writer.println("</html>");
    }

    public void destroy() {
    }
}