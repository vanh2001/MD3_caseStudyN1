package DAO;

import model.Management.LoanSlip;

import java.sql.SQLException;

public interface ILoanSlipDao {
    void addLoanSlipDetailsTransaction(LoanSlip loanSlip, int[] permissions);

    boolean update (LoanSlip loanSlip) throws SQLException;
}
