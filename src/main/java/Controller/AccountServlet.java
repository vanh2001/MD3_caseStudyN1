package Controller;

import DAO.UserDAO;
import model.Management.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

@WebServlet(urlPatterns = {"/account","/"})
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "admin":
                request.getRequestDispatcher("/loginadminform.jsp").forward(request,response);
                break;
            case "user":
                request.getRequestDispatcher("/loginUser.jsp").forward(request, response);
            case "adduser":
                request.getRequestDispatcher("/adduser.jsp").forward(request,response);
                break;
            case "showuser":
                List<User> list2 = UserDAO.view();
                request.setAttribute("listUser", list2);
                request.getRequestDispatcher("viewuser.jsp").forward(request,response);
                break;
            case "logout":
                request.getSession().invalidate();
                response.sendRedirect("index.jsp");
                break;
            default:
                HttpSession session = request.getSession(false);
                if (session.getAttribute("admin") != null) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("adminSection.jsp");
                    ((RequestDispatcher) dispatcher).forward(request, response);
                }else {
                    String message = "Please login first";
                    request.setAttribute("messagelog", message);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                }
        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "admin":
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                if (email.equals("admin@gmail.com") && password.equals("12345")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("admin","true");
                    request.getRequestDispatcher("adminSection.jsp").forward(request,response);
                } else {
                    String message = "Invalid email/password";
                    request.setAttribute("messagelogin", message);
                }
                request.getRequestDispatcher("loginadminform.jsp").forward(request, response);
                break;
            case "user":
                String email5 = request.getParameter("email_user");
                String password5 = request.getParameter("password_user");
                if (UserDAO.authenticate(email5,password5)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", email5);
                    request.getRequestDispatcher("homeKH.jsp").forward(request, response);
                } else {
                    String message3 = "Invalid email/password";
                    request.setAttribute("messageloginuser", message3);
                }
                request.getRequestDispatcher("loginuser.jsp").forward(request,response);
                break;
        }
    }
}