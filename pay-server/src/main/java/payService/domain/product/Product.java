package payService.domain.product;

import javax.persistence.*;

public class Product {

    private long id;
    private String name;
    private String price;
    private int maxAmount;
    private int amount;

    public Product() {
    }

    public Product(ProductDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.maxAmount = dto.getMaxAmount();
        this.amount = dto.getAmount();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public int getMaxAmount() {
        return maxAmount;
    }
    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", maxAmount=" + maxAmount +
                ", amount=" + amount +
                '}';
    }
}
