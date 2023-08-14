package FlightControl;


import FlightControl.logic.FlightControlLogic;
import FlightControl.ui.TextUserInterface;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        // Write the main program here. It is useful to create some classes of your own.
        Scanner scanner = new Scanner(System.in);
        FlightControlLogic controller = new FlightControlLogic();
        TextUserInterface ui = new TextUserInterface(controller, scanner);

        ui.start();
    }
}
