import java.util.ArrayList;

public class ChangeHistory {

    private ArrayList<Double> changeHistory;

    public ChangeHistory() {
        changeHistory = new ArrayList<>();
    }

    public void add(double status) {
        changeHistory.add(status);
    }

    public void clear() {
        changeHistory.clear();
    }

    @Override
    public String toString() {
        return changeHistory.toString();

    }

    public double maxValue () {
        if (changeHistory.size() == 0) {
            return 0.0;
        }
        double max = changeHistory.get(0);
        for (double value : changeHistory) {
            if (max < value) {
                max = value;
            }
        }

        return max;
    }

    public double minValue () {
        if (changeHistory.isEmpty()) {
            return 0.0;
        }
        double min = changeHistory.get(0);
        for (double value : changeHistory) {
            if (min > value) {
                min = value;
            }
        }

        return min;
    }

    public double average() {
        if(changeHistory.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (double value : changeHistory) {
            sum = sum + value;
        }

        return  sum / changeHistory.size();
    }
}
