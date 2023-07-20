import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> facility;

    public StorageFacility() {
        this.facility = new HashMap<>();
    }

    public void add (String unit, String item) {
        this.facility.putIfAbsent(unit, new ArrayList<>());
        this.facility.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        return this.facility.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        this.facility.get(storageUnit).remove(item);
        if (this.facility.get(storageUnit).size() == 0) {
            this.facility.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits(){

        ArrayList<String> list = new ArrayList<>();
        for (String unit : facility.keySet()) {
            if (facility.values().size() != 0) {
                list.add(unit);
            }
        }
        return list;
    }

}
