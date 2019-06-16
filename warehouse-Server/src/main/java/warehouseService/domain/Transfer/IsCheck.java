package warehouseService.domain.Transfer;

public class IsCheck {

    private boolean check;

    public IsCheck(boolean check) {
        this.check = check;
    }

    public IsCheck() {
    }

    public boolean isCheck() {
        return check;
    }
    public void setCheck(boolean check) {
        this.check = check;
    }
}
