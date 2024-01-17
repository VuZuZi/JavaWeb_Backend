import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "caculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet{
    private   Double result = 0.0;
    private String re;
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double fN = Double.valueOf(req.getParameter("fNumber"));
        Double sN = Double.valueOf(req.getParameter("sNumber"));
        String op = req.getParameter("op");
        switch (op){
            case "+":
                re = String.valueOf((result = fN + sN));
                break;
            case "-":
                re = String.valueOf((result = fN - sN));
                break;
            case "*":
                re = String.valueOf((result = fN * sN));
                break;
            case "/":
                if(sN != 0) {
                    re = String.valueOf((result = fN / sN));
                }else {
                    re = "can't division with 0";
                }
                break;
        }
        req.setAttribute("fN",fN);
        req.setAttribute("sN",sN);
        req.setAttribute("op",op);
        req.setAttribute("re",re);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
        dispatcher.forward(req,resp);
    }
}
