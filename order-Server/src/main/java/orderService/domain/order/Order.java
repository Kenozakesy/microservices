package orderService.domain.order;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=128)
    private long productId;
    
    @Column(nullable=false, length=128)
    private int amount;

    @Column(nullable=false, length=128)
    private boolean delivered;

    public Order() {
    }

    public Order(OrderDTO dto) {
        this.id = dto.getId();
        this.productId = dto.getId();
        this.amount = dto.getAmount();
        this.delivered = dto.isDelivered();
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

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isDelivered() {
        return delivered;
    }
    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
