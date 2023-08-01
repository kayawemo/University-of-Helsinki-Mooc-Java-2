public class ProductWarehouseWithHistory extends  ProductWarehouse {

    private ChangeHistory changeHistory;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        changeHistory = new ChangeHistory();
        changeHistory.add(initialBalance);

    }

    public String history (){
        return changeHistory.toString();
    }

    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        changeHistory.add(super.getBalance());

    }

    public double takeFromWarehouse(double amount) {
        double received = super.takeFromWarehouse(amount);
        changeHistory.add(getBalance());
        return received;
    }

    public void printAnalysis() {
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + this.changeHistory.maxValue());
        System.out.println("Smallest amount of product: " + this.changeHistory.minValue());
        System.out.println("Average: " + this.changeHistory.average());
    }

}
