package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;

import java.util.Collection;
import java.util.HashMap;

public class FlightControlLogic {

    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;
    private HashMap<String, Place> places;

    public FlightControlLogic() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }

    public void addPlanes(String ID, int capacity) {
        Airplane plane = new Airplane(ID, capacity);
        this.airplanes.put(ID, plane);
    }

    public void addFlight(Airplane plane, String departurePlaceID, String destinationPlaceID) {

        // add departure ID and places to the "places" hashmap.
        this.places.putIfAbsent(departurePlaceID, new Place(departurePlaceID));
        this.places.putIfAbsent(departurePlaceID, new Place(destinationPlaceID));

        Flight flight = new Flight(plane, this.places.get(departurePlaceID), this.places.get(destinationPlaceID));
        this.flights.put(flight.toString(), flight);
    }

    public Collection<Airplane> getPlanes() {
        return  this.airplanes.values();
    }

    public Collection<Flight> getFlights() {
        return this.flights.values();
    }

    public Airplane getAirplane (String ID) {
        return this.airplanes.get(ID);
    }
}
