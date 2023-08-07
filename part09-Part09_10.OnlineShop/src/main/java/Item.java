import java.util.Objects;

public class Item {

    private String product;
    private int quantity;
    private int unitPrice;

    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.quantity = qty;
        this.unitPrice = unitPrice;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int price () {
        return unitPrice * quantity;
    }

    public void increaseQuantity () {
        this.quantity ++;
    }

    @Override
    public String toString() {
        return this.product + ": " + this.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(product, item.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
