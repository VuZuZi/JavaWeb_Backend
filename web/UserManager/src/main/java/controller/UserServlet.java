package controller;

import DAO.IUserDAO;
import DAO.UserDAO;
import model.User;

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

@WebServlet(name = "UserServlet",value = {"/", "/user"})
public class UserServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private IUserDAO userDAO;

        public void init() {
            userDAO = new UserDAO();
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            try {
                switch (action) {
                    case "create":
                        insertUser(request, response);
                        break;
                    case "edit":
                        updateUser(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String action = request.getParameter("action");
            System.out.println("----ACtion: "+action);
            if (action == null) {
                action = "";
            }

            try {
                switch (action) {
                    case "searchByCountry":
                        String country = request.getParameter("countrySearch");
                        searchByCountry(request,response,country);
                        System.out.println("---------1111dssadsasad------"+country);
                        break;
                    case "searchByName":
                        String key = request.getParameter("nameSearch");
                        searchByName(request,response,key);
                        System.out.println("---------1111dssadsasad------"+key);
                        break;
                    case "create":
                        showNewForm(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "delete":
                        deleteUser(request, response);
                        break;
                    default:
                        listUser(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

    private void searchByCountry(HttpServletRequest request, HttpServletResponse response, String country)
        throws SQLException, ServletException, IOException{
        List<User> listUser = userDAO.searchByCountry(country);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response, String key)
            throws SQLException, ServletException, IOException {
        List<User> listUser = userDAO.searchByName(key);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);

    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            List<User> listUser = userDAO.selectAllUsers();
            request.setAttribute("listUser", listUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
            dispatcher.forward(request, response);
        }

        private void showNewForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
            dispatcher.forward(request, response);
        }


        private void showEditForm(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            User existingUser = userDAO.selectUser(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
            request.setAttribute("user", existingUser);
            dispatcher.forward(request, response);

        }

        private void insertUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");
            User newUser = new User(name, email, country);
            userDAO.insertUser(newUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
            dispatcher.forward(request, response);
        }

        private void updateUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");

            User book = new User(id, name, email, country);
            userDAO.updateUser(book);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
            dispatcher.forward(request, response);
        }

        private void deleteUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            int id = Integer.parseInt(request.getParameter("id"));
            userDAO.deleteUser(id);

            List<User> listUser = userDAO.selectAllUsers();
            request.setAttribute("listUser", listUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
            dispatcher.forward(request, response);
        }
    }