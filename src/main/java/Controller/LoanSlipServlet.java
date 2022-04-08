package Controller;

import DAO.LoanSlipDao;
import model.Management.LoanSlip;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoanSlipServlet", value = "/loanslip")
public class LoanSlipServlet extends HttpServlet {
    private LoanSlipDao loanSlipDao;

    public void init() {
        loanSlipDao = new LoanSlipDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "addLoanSlip":
                    addLoanSLipTransaction(request,response);
                    break;
                case "update":
                    showFormUpdate(request,response);
                    break;
                default:
                    listLoanSlip(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listLoanSlip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<LoanSlip> listLoanSlip = loanSlipDao.selectAllLoanSlip();
        request.setAttribute("", listLoanSlip);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void addLoanSLipTransaction(HttpServletRequest request, HttpServletResponse response) {
        LoanSlip loanSlip = new LoanSlip(1,"2022-04-07","2022-04-10","Dang cho muon");
        int book[] = {1,2,3};
        loanSlipDao.addLoanSlipDetailsTransaction(loanSlip,book);
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {

    }
}
