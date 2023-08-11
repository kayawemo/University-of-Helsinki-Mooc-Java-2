package mooc.logic;

import mooc.ui.UserInterface;

public class ApplicationLogic {

    private UserInterface ui;

    public ApplicationLogic(UserInterface ui) {

        this.ui = ui;

    }

    public void execute(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Te Application logic is working");
            ui.update();
        }
    }
}
