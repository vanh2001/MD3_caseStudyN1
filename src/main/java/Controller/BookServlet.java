package Controller;

import DAO.BookDAO;
import model.Management.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;

    public void init() {
        bookDAO = new BookDAO();}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

//        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
//                    deleteUser(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> listBook= bookDAO.selectAllBook();
        request.setAttribute("listBooks",listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm/listBook.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm/create.jsp");
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
            throws SQLException, ServletException, IOException {
        int id_title_book= Integer.parseInt(request.getParameter("id_title_book"));
        String name_book = request.getParameter("name_book");
        String description_book = request.getParameter("description_book");
        int amount_book = Integer.parseInt(request.getParameter("amount_book"));
        String kind_book = request.getParameter("kind_book");
        String publishing_book = request.getParameter("publishing_book");
        String status_book = request.getParameter("status_book");
        Book newBook = new Book(id_title_book,name_book,description_book,amount_book,kind_book,publishing_book,status_book);
        bookDAO.insertBook(newBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request,response);
    }
}
