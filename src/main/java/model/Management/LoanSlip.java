package model.Management;

public class LoanSlip {
    private int loanSlipId;
    private int customerId;
    private String loanSlipBorrowedDate;
    private String loanSlipReturnedDate;
    private String statusLoanSlip;

    public LoanSlip() {
    }

    public LoanSlip(int loanSlipId, int customerId, String loanSlipBorrowedDate, String loanSlipReturnedDate, String statusLoanSlip) {
        this.loanSlipId = loanSlipId;
        this.customerId = customerId;
        this.loanSlipBorrowedDate = loanSlipBorrowedDate;
        this.loanSlipReturnedDate = loanSlipReturnedDate;
        this.statusLoanSlip = statusLoanSlip;
    }

    public int getLoanSlipId() {
        return loanSlipId;
    }

    public void setLoanSlipId(int loanSlipId) {
        this.loanSlipId = loanSlipId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getLoanSlipBorrowedDate() {
        return loanSlipBorrowedDate;
    }

    public void setLoanSlipBorrowedDate(String loanSlipBorrowedDate) {
        this.loanSlipBorrowedDate = loanSlipBorrowedDate;
    }

    public String getLoanSlipReturnedDate() {
        return loanSlipReturnedDate;
    }

    public void setLoanSlipReturnedDate(String loanSlipReturnedDate) {
        this.loanSlipReturnedDate = loanSlipReturnedDate;
    }

    public String getStatusLoanSlip() {
        return statusLoanSlip;
    }

    public void setStatusLoanSlip(String statusLoanSlip) {
        this.statusLoanSlip = statusLoanSlip;
    }
}
