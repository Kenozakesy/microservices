package warehouseService.domain.order;
import javax.persistence.*;

public class Order {

    private long id;
    private long productId;
    private int amount;
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
