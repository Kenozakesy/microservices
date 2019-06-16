package warehouseService.domain.order;

public class OrderDTO {

    private int id;
    private long productId;
    private int amount;
    private boolean delivered;

    public OrderDTO(long productId, int amount) {
        this.productId = productId;
        this.amount = amount;
        this.delivered = false;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
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
        return "OrderDTO{" +
                "id=" + id +
                ", productId=" + productId +
                ", amount=" + amount +
                ", delivered=" + delivered +
                '}';
    }
}
