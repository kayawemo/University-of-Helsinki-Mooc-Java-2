package FlightControl.domain;

public class Flight {

    private Airplane airplane;
    private Place departurePlace;

    private Place arrivalPlace;

    public Flight(Airplane airplane, Place departurePlace, Place arrivalPlace) {
        this.airplane = airplane;
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
    }

    public Airplane getAirpalne() {
        return airplane;
    }

    public Place getDepaturePlace() {
        return departurePlace;
    }

    public Place getArrivalPlace() {
        return arrivalPlace;
    }
}
