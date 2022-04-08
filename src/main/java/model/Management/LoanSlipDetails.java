package model.Management;

public class LoanSlipDetails {
    private int detailsId;
    private int loanSlipId;
    private String statusLoanSlip;

    public LoanSlipDetails() {
    }

    public LoanSlipDetails(int detailsId, int loanSlipId, String statusLoanSlip) {
        this.detailsId = detailsId;
        this.loanSlipId = loanSlipId;
        this.statusLoanSlip = statusLoanSlip;
    }

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public int getLoanSlipId() {
        return loanSlipId;
    }

    public void setLoanSlipId(int loanSlipId) {
        this.loanSlipId = loanSlipId;
    }

    public String getStatusLoanSlip() {
        return statusLoanSlip;
    }

    public void setStatusLoanSlip(String statusLoanSlip) {
        this.statusLoanSlip = statusLoanSlip;
    }
}
