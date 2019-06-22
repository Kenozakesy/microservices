package warehouseService.domain.order;

public class DeliverDTO {

    private long id;
    private long productId;
    private int amount;
    private boolean delivered;

    public DeliverDTO(long productId, int amount) {
        this.productId = productId;
        this.amount = amount;
        this.delivered = false;
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
        return "DeliverDTO{" +
                "id=" + id +
                ", productId=" + productId +
                ", amount=" + amount +
                ", delivered=" + delivered +
                '}';
    }
}
