package controller;

import dao.BookDAO;
import model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;

    public void init() {
        bookDAO = new BookDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
//                    showEditForm(request, response);
                    break;
                case "delete":
//                    deleteUser(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response)
    throws ServletException,SQLException,IOException{
        List<Book> listBook= bookDAO.selectAllBook();
        request.setAttribute("listBook",listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listBook.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request,response);
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
                    insertBook(request, response);
                    break;
                case "edit":
//                    updateBook(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException,SQLException{
        int idTitle = Integer.parseInt(request.getParameter("idTitle"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int amount = Integer.parseInt(request.getParameter("amount"));
        String kind = request.getParameter("kind");
        String publishing = request.getParameter("publishing");
        Book newBook = new Book(idTitle,name,description,amount,kind,publishing);
        bookDAO.insertBook(newBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request,response);
    }
}
