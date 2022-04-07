package Controller;

import DAO.LibrabianDAO;
import DAO.UserDAO;
import model.Management.LibrarianBean;
import model.Management.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/account","/"})
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action){
            case "admin":
                request.getRequestDispatcher("loginadminform.jsp").forward(request,response);
                break;
            case "librarian":
                request.getRequestDispatcher("loginlibrarionform.jsp").forward(request,response);
                break;
            case "addlibrarian":
                request.getRequestDispatcher("addlibrarianform.jsp").forward(request,response);
                break;
            case "user":
                request.getRequestDispatcher("loginuser.jsp").forward(request,response);
            case "adduser":
                request.getRequestDispatcher("adduser.jsp").forward(request,response);
                break;
            case "deletelib":
                String sid=request.getParameter("id");
                int id=Integer.parseInt(sid);
                LibrabianDAO.delete(id);
                response.sendRedirect("viewlibrarian.jsp");
                break;
            case "editlib":
                String sid1=request.getParameter("id");
                int id1=Integer.parseInt(sid1);
                LibrarianBean bean=LibrabianDAO.viewbyId(id1);
                request.setAttribute("lib",bean);
                request.getRequestDispatcher("editlibrarianform.jsp").forward(request,response);
                break;
            case "showlib":
//                List<LibrarianBean> list=LibrarianDao.view();
                List<LibrarianBean> list = LibrabianDAO.view();
                request.setAttribute("listLib", list);
                request.getRequestDispatcher("viewlibrarian.jsp").forward(request,response);
                break;
            case "showuser":
                List<User> list2=UserDAO.view();
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
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                }else if(session.getAttribute("email") != null){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("loginlib.jsp");
                    dispatcher.forward(request, response);
                }else {
                    String message = "Please login fisrt";
                    request.setAttribute("messagelog", message);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                }
        }
    }


    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "admin":
                String email=request.getParameter("email");
                String password=request.getParameter("password");
                if(email.equals("admin@gmail.com")&&password.equals("123456")){
                    HttpSession session=request.getSession();
                    session.setAttribute("admin","true");

                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }else{
                    String message = "Invalid email/password";
                    request.setAttribute("messagelogin", message);
                }
                request.getRequestDispatcher("loginadminform.jsp").forward(request,response);
                break;
            case "librarian":
                String email3=request.getParameter("email");
                String password3=request.getParameter("password");
                if(LibrabianDAO.authenticate(email3, password3)){
                    HttpSession session=request.getSession();
                    session.setAttribute("email",email3);
                    request.getRequestDispatcher("loginlib.jsp").forward(request,response);
                }else{
                    String message = "Invalid email/password";
                    request.setAttribute("messageloginlib", message);
                }
                request.getRequestDispatcher("loginlibrarionform.jsp").forward(request,response);
                break;
            case "addlibrarian":
                String name1=request.getParameter("name");
                String email1=request.getParameter("email");
                String password1=request.getParameter("password");
                String smobile1=request.getParameter("mobile");
                long mobile=Long.parseLong(smobile1);
                LibrarianBean bean=new LibrarianBean(name1, email1, password1, mobile);
                LibrabianDAO.save(bean);
                String message = "Successfully added librarian";
                request.setAttribute("messageaddlib", message);
                request.getRequestDispatcher("addlibrarianform.jsp").forward(request,response);
                break;
            case "adduser":
                String name4=request.getParameter("name");
                String email4=request.getParameter("email");
                String password4=request.getParameter("password");
                String sphone4=request.getParameter("phone");
                long phone=Long.parseLong(sphone4);
                User bean4=new User(name4, email4, password4, phone);
                UserDAO.save(bean4);
                String message2 = "Register Successfully! Click User for back to Login User Form";
                request.setAttribute("messageadduserres", message2);
                request.getRequestDispatcher("adduser.jsp").forward(request,response);
                break;
            case "user":
                String email5=request.getParameter("email");
                String password5=request.getParameter("password");
                if(UserDAO.authenticate(email5, password5)){
                    HttpSession session=request.getSession();
                    session.setAttribute("user",email5);
                    request.getRequestDispatcher("homeKH.jsp").forward(request,response);
                }else{
                    String message3 = "Invalid email/password";
                    request.setAttribute("messageloginuser", message3);
                }
                request.getRequestDispatcher("loginuser.jsp").forward(request,response);
                break;
            case "editlib":
                String sid=request.getParameter("id");
                int id2=Integer.parseInt(sid);
                String name2=request.getParameter("name");
                String email2=request.getParameter("email");
                String password2=request.getParameter("password");
                String smobile2=request.getParameter("mobile");
                long mobile2=Long.parseLong(smobile2);
                LibrarianBean bean2=new LibrarianBean(id2,name2, email2, password2, mobile2);
                LibrabianDAO.update(bean2);
                response.sendRedirect("viewlibrarian.jsp");
                break;
        }
    }
}