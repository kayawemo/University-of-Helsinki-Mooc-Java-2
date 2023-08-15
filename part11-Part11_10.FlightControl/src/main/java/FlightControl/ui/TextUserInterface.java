package FlightControl.ui;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.logic.FlightControlLogic;

import java.util.Scanner;

public class TextUserInterface {

    // I'm thinking of MVC here. The ui needs the controller to interact with the model (domain).
    private FlightControlLogic controller;
    private Scanner scanner;

    public TextUserInterface(FlightControlLogic controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void start() {

        assetControl();
        System.out.println();
        flightControl();
        System.out.println();
    }

    private void flightControl() {

        while (true) {
            System.out.println("Choose an action:\n" +
                    "[1] Print airplanes\n" +
                    "[2] Print flights\n" +
                    "[3] Print airplane details\n" +
                    "[x] Quit\n" +
                    "> ");

            String input = scanner.nextLine();
            if (input.equals("1")) {
                printPlanes();
            } else if (input.equals("2")) {
                printFlight();
            } else if (input.equals("3")) {
                printPlaneDetails();
            } else if (input.equals("x")) {
                break;
            }

        }
    }

    private void printPlaneDetails() {
        System.out.println("Give the airplane id: ");
        Airplane plane = askForAirplane();
        System.out.println(plane);

    }

    private void printFlight() {
        for(Flight flight : controller.getFlights()) {
            System.out.println(flight);
        }
    }

    private void printPlanes() {
        for (Airplane plane : controller.getPlanes()) {
            System.out.println(plane);
        }
    }

    private void assetControl() {

        while(true) {

            System.out.println("Choose an action:\n" +
                    "[1] Add an airplane\n" +
                    "[2] Add a flight\n" +
                    "[x] Exit Airport Asset Control");

            System.out.print(">");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                addPlane();
            }
            if (input.equals("2")){
                addFlight();
            }

            if (input.equals("x")) {
                break;
            }
        }
    }

    private void addFlight() {
        System.out.println("Give the airplane id:");
        Airplane airplane = askForAirplane();
        System.out.println("Give the departure airport id:");
        String departureID = scanner.nextLine();
        System.out.println("Give the destination airport id:");
        String destinationID = scanner.nextLine();

        this.controller.addFlight(airplane, departureID, destinationID);

    }

    private void addPlane() {
        System.out.println("Give the airplane ID: ");
        String ID = scanner.nextLine();
        System.out.println("Give the airplane capacity: ");
        int capacity = Integer.valueOf(scanner.nextLine());
        this.controller.addPlanes(ID, capacity);
    }

    private Airplane askForAirplane() {
        Airplane airplane = null;
        while (airplane == null) {
            String id = scanner.nextLine();
            airplane = controller.getAirplane(id);

            if (airplane == null) {
                System.out.println("No airplane with the id " + id + ".");
            }
        }

        return airplane;
    }





}
