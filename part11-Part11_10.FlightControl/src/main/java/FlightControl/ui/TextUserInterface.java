package FlightControl.ui;

import FlightControl.domain.Airplane;
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
