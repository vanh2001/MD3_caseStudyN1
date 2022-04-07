package Controller;

import DAO.CustomerDAO;
import model.Management.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDao;

    public void init() {
        customerDao = new CustomerDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                    showEditForm(request,response);
                    break;
                case "delete":
                    showDeleteForm(request,response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (IOException ex) {
            throw new ServletException(ex);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingUser = customerDao.selectCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer", existingUser);
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingUser = customerDao.selectCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/delete.jsp");
        request.setAttribute("customer", existingUser);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerDao.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {

            switch (action) {
                case "create":
                    insertCustomer(request,response);
                    break;
                case "edit":
                    updateCustomer(request,response);
                    break;
                case "delete":
                    deleteCustomer(request,response);
                    break;
                default:
                    break;
            }
        } catch (IOException ex) {
            throw new ServletException(ex);

    } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id_customer = Integer.parseInt(request.getParameter("id_customer"));
        customerDao.deleteCustomer(id_customer);

        List<Customer> customerList = customerDao.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id_customer = Integer.parseInt(request.getParameter("id_customer"));
        String name_customer = request.getParameter("name_customer");
        String email_customer = request.getParameter("email_customer");
        String address_customer = request.getParameter("address_customer");
        String birth_customer=request.getParameter("birth_customer");
        String phoneNumber_customer=request.getParameter("phoneNumber_customer");

        Customer customer = new Customer(id_customer, name_customer, email_customer, address_customer,birth_customer,phoneNumber_customer);
        customerDao.updateCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name_customer =request.getParameter("name_customer");
        String email_customer = request.getParameter("email_customer");
        String address_customer = request.getParameter("address_customer");
        String birth_customer=(request.getParameter("birth_customer"));
        String phoneNumber_customer=request.getParameter("phoneNumber_customer");

        Customer newCustomer=new Customer(name_customer,email_customer,address_customer,birth_customer,phoneNumber_customer);
        customerDao.insertCustomer(newCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }
    }
