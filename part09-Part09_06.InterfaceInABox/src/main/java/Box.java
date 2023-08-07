import java.util.ArrayList;

public class Box implements Packable {

    private double capacity;
    private ArrayList<Packable> packables;

    public Box (double capacity) {
        this.capacity = capacity;
        this.packables = new ArrayList<>();
    }

    public void add (Packable packable) {
        if (this.capacity >= packable.weight()) {
            this.capacity -= packable.weight();
            packables.add(packable);
        }
    }

    public double weight() {
        double weight = 0;
        for (Packable packable : packables) {
            weight += packable.weight();
        }
        return weight;
    }

    public String toString() {

        return this.getClass().getName() + ": " + packables.size() + " items, total weight " + this.weight()+ " kg";
    }
}
