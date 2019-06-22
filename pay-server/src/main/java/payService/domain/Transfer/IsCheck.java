package payService.domain.Transfer;

public class IsCheck {

    private boolean check;
    private String description;
    private double refund;

    public IsCheck(boolean check, String description, double refund) {
        this.check = check;
        this.description = description;
        this.refund = refund;
    }

    public IsCheck() {
    }

    public boolean isCheck() {
        return check;
    }
    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getRefund() {
        return refund;
    }
    public void setRefund(double refund) {
        this.refund = refund;
    }
}
