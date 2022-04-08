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
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteBook(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException{
        int id_book = Integer.parseInt(request.getParameter("id_book"));
        bookDAO.deleteBook(id_book);
        List<Book> listBook= bookDAO.selectAllBook();
        request.setAttribute("listBooks",listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm/listBook.jsp");
        dispatcher.forward(request,response);

    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException{
        int id_book = Integer.parseInt(request.getParameter("id_book"));
        Book existingBook = bookDAO.selectBook(id_book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm/edit.jsp");
        request.setAttribute("book", existingBook);
        dispatcher.forward(request, response);
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> listBook= bookDAO.selectAllBook();
        request.setAttribute("listBooks",listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm/listBook.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm/create.jsp");
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
                    insertBook(request, response);
                    break;
                case "edit":
                    updateBook(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException{
        String id_book1 = request.getParameter("id_book");
        int id_book = Integer.parseInt(id_book1);
        Integer id_title_book = Integer.valueOf(request.getParameter("id_title"));
        String name_book = request.getParameter("name");
        String description_book = request.getParameter("description");
        int amount_book = Integer.parseInt(request.getParameter("amount"));
        String kind_book = request.getParameter("kind");
        String publishing_book = request.getParameter("publishing");
        String status_book = request.getParameter("status");
        Book book = new Book(id_book,id_title_book,name_book,description_book,amount_book,kind_book,publishing_book,status_book);
        bookDAO.updateBook(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id_title_book= Integer.parseInt(request.getParameter("id"));
        String name_book = request.getParameter("name");
        String description_book = request.getParameter("description");
        int amount_book = Integer.parseInt(request.getParameter("amount"));
        String kind_book = request.getParameter("kind");
        String publishing_book = request.getParameter("publishing");
        String status_book = request.getParameter("status");
        Book newBook = new Book(id_title_book,name_book,description_book,amount_book,kind_book,publishing_book,status_book);
        bookDAO.insertBook(newBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm/create.jsp");
        dispatcher.forward(request,response);
    }
}
