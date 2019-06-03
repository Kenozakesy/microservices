package warehouseService.domain.payment;

import java.util.Date;

public class PaymentDTO {

    private long id;
    private long productId;
    private double payment;
    private int amount;
    private Date paymentDate;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }
    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getPayment() {
        return payment;
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + id +
                ", productId=" + productId +
                ", payment=" + payment +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
