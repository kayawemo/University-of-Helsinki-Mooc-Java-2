import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> vehicleRegistry;


    public VehicleRegistry() {
        this.vehicleRegistry = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
       if (this.vehicleRegistry.containsKey(licensePlate)){
           return false;
       } else {
           this.vehicleRegistry.put(licensePlate, owner);
           return true;
       }

    }

    public String get(LicensePlate licensePlate) {
        if(this.vehicleRegistry.containsKey(licensePlate)){
            return this.vehicleRegistry.get(licensePlate);
        } else {
            return  null;
        }
    }

    public boolean remove(LicensePlate licensePlate) {
        if (this.vehicleRegistry.containsKey(licensePlate)) {
            vehicleRegistry.remove(licensePlate);
            return true;
        } else {
            return false;
        }
    }

    public void printLicensePlates() {
        for (LicensePlate li : this.vehicleRegistry.keySet()) {
            System.out.println(li);
        }
    }

    public void printOwners() {
        ArrayList<String> owners = new ArrayList<String>();
        for (String owner : this.vehicleRegistry.values()) {
            if (!(owners.contains(owner)))
            owners.add(owner);
        }

        for (String owner : owners) {
            System.out.println(owner);
        }
    }

}
