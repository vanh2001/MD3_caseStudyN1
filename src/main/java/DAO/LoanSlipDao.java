package DAO;


import connection.SingletonConnection;
import model.Management.LoanSlip;

import java.sql.*;

public class LoanSlipDao implements ILoanSlipDao {

    public static final String INSERT_LOANSLIP_SQL = "insert into LoanSlip (id_customer, borrowedDate_loan_slip, returnedDate_loan_slip, status_loanSlip) VALUES (?,?,?,?);";
    public static final String INSERT_LOANSLIP_DETAILS = "insert into LoanSlipDetails (id_loanSlip, id_book) VALUES (?,?);";
    public static final String UPDATE_LOANSLIP_SQL = "UPDATE LoanSlip set status_loanSlip = ? where id_loanSlip = ?;";

    @Override
    public void addLoanSlipDetailsTransaction(LoanSlip loanSlip, int[] books) {
        Connection connection = null;
        // Thêm LoanSlip
        PreparedStatement pstmtLoanSlip = null;
        //Thêm LoanSlipDetails
        PreparedStatement pstmtLoanSlipDetails = null;
        ResultSet rs = null;
        try {
            connection = SingletonConnection.getConnection();
            connection.setAutoCommit(false);
            pstmtLoanSlip = connection.prepareStatement(INSERT_LOANSLIP_SQL, Statement.RETURN_GENERATED_KEYS);
            pstmtLoanSlip.setInt(1, loanSlip.getCustomerId());
            pstmtLoanSlip.setString(2, loanSlip.getLoanSlipBorrowedDate());
            pstmtLoanSlip.setString(3, loanSlip.getLoanSlipReturnedDate());
            pstmtLoanSlip.setString(4, loanSlip.getStatusLoanSlip());
            int rowAffected = pstmtLoanSlip.executeUpdate();
            rs = pstmtLoanSlip.getGeneratedKeys();
            int loanSlipId = 0;
            if (rs.next()){
                loanSlipId = rs.getInt(1);
            }
            if (rowAffected == 1){
                String sqlPivot = INSERT_LOANSLIP_DETAILS;
                pstmtLoanSlipDetails = connection.prepareStatement(INSERT_LOANSLIP_DETAILS);
                for (int book : books){
                    pstmtLoanSlipDetails.setInt(1,loanSlipId);
                    pstmtLoanSlipDetails.setInt(2, book);
                    pstmtLoanSlipDetails.executeUpdate();
                }
                connection.commit();
            }else {
                connection.rollback();
            }
        } catch (SQLException e) {
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmtLoanSlip != null) pstmtLoanSlip.close();
                if (pstmtLoanSlipDetails != null) pstmtLoanSlipDetails.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public boolean update(LoanSlip loanSlip) throws SQLException {
        boolean rowUpate;
        try(
                Connection connection = SingletonConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LOANSLIP_SQL);
                ){
            preparedStatement.setString(1, loanSlip.getStatusLoanSlip());
            preparedStatement.setInt(2,loanSlip.getLoanSlipId());
            rowUpate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpate;
    }
}
