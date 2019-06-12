package orderService.domain.order;

public class OrderDTO {

    private int id;
    private int productId;
    private int amount;
    private boolean delivered;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
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
