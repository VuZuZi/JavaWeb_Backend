import DAO.INotesDAO;
import DAO.noteDAO;
import DTO.NoteDTO;
import Model.Notes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "helloServlet", value = {"/", "/note"})
public class NotesServlet extends HttpServlet {
    private String message;
    private INotesDAO noteDAO = new noteDAO();


    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getParameter("action");
//            System.out.println("----ACtion: "+action);
        if (action == null) {
            action = "";
        }
        try{
            switch (action){
                default:
                    listNotes(request,response);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        // Hello
        String ok = "ok";
        request.setAttribute("ok", ok);
        RequestDispatcher dispatcher = request.getRequestDispatcher("notes/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void destroy() {
    }
    private void listNotes(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<NoteDTO> list = noteDAO.selectAllNote();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("notes/list.jsp");
        dispatcher.forward(request, response);
    }
}