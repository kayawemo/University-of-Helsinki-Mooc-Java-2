import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> shoppingCart;

    public ShoppingCart() {
        shoppingCart = new HashMap<>();
    }

    public void add(String product, int price) {
        Item item = new Item(product, 1, price);
        for (Item it : shoppingCart.values()) {
            if (it.equals(item)) {
                it.increaseQuantity();
                return;
            }
        }

        shoppingCart.put(product, item);

    }

    public int price() {
        int totalPrice = 0;
        for (Item item : shoppingCart.values()) {
            int price = item.price();
            totalPrice += price;
        }

        return totalPrice;
    }

    public void print() {
        for (Item item : shoppingCart.values()){
            System.out.println(item.getProduct() + ": " + item.getQuantity());
        }
    }
}
