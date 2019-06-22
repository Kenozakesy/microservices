package warehouseService.domain.order;

import javax.persistence.*;

public class Deliver { // is keyword should change

    private long id;
    private long productId;
    private int amount;
    private boolean delivered;

    public Deliver() {
    }

    public Deliver(DeliverDTO dto) {
        this.id = dto.getId();
        this.productId = dto.getProductId();
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

    @Override
    public String toString() {
        return "Deliver{" +
                "id=" + id +
                ", productId=" + productId +
                ", amount=" + amount +
                ", delivered=" + delivered +
                '}';
    }
}
