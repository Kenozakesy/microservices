package warehouseService.domain.payment;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=128)
    private long productId;

    @Column(nullable=false, length=128)
    private double payment;

    @Column(nullable=false, length=128)
    private int amount;

    @Column(nullable=false, length=128)
    private Date paymentDate;

    public Payment() {
    }

    public Payment(PaymentDTO dto) {
        this.id = dto.getId();
        this.productId = dto.getProductId();
        this.payment = dto.getPayment();
        this.amount = dto.getAmount();
        this.paymentDate = dto.getPaymentDate();
    }

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
}
