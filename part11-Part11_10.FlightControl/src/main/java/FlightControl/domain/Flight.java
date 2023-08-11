package FlightControl.domain;

public class Flight {

    private Airpalne airpalne;
    private Place depaturePlace;
    private Place arrivalPlace;

    public Flight(Airpalne airpalne, Place depaturePlace, Place arrivalPlace) {
        this.airpalne = airpalne;
        this.depaturePlace = depaturePlace;
        this.arrivalPlace = arrivalPlace;
    }

    public Airpalne getAirpalne() {
        return airpalne;
    }

    public Place getDepaturePlace() {
        return depaturePlace;
    }

    public Place getArrivalPlace() {
        return arrivalPlace;
    }
}
