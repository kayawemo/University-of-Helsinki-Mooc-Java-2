import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private int maxWeight;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        super();
        this.maxWeight = capacity;
        items = new ArrayList<>();
    }


    @Override
    public void add(Item item) {

        if (this.maxWeight >= item.getWeight()) {
            this.maxWeight -= item.getWeight();
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        for (Item it: items) {
            if(it.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
