package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;


    public AverageSensor () {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    @Override
    public boolean isOn() {
        for (Sensor s : sensors) {
            if (!s.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {

        for (Sensor sensor : sensors) {
            sensor.setOn();
        }

    }

    @Override
    public void setOff() {

        for (Sensor sensor : sensors) {
            sensor.setOff();
        }

    }

    @Override
    public int read() {
        if(!isOn() || this.sensors.isEmpty()) {
            throw new IllegalStateException("Average sensor must be on and must not be empty");
        }
        int avg = this.sensors.stream().map(s -> s.read()).reduce(0, (prev, curr) -> prev + curr) / this.sensors.size();

        readings.add(avg);
        return avg;
    }

    public List<Integer> readings() {
       return this.readings;
    }
}
