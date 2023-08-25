/*
Allows us to test this program before making the GUI
 */

public class TerminalInterace {

    public static void main_loop() {
        while (true) {
            String input = Main.input.nextLine();
            if (input.equalsIgnoreCase("read")) {
                System.out.println("List of tasks goes here");
            } else if (input.equalsIgnoreCase("write") || input.equalsIgnoreCase("add")) {
                System.out.println("A way to add stuff goes here");
            } else if (input.equalsIgnoreCase("stop") || input.equalsIgnoreCase("end")) {
                break;
            } else {
                System.out.println("Cmd not recognized, Please try again");
            }

        }
    }
}
