package warehouseService.domain.product;


import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=128)
    private String name;

    @Column(nullable=false, length=128)
    private double price;

    @Column(nullable=false, length=128)
    private int maxAmount;

    @Min(value = 0, message = "should not be less than 18")
    @Column(nullable=false, length=128)
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

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
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
