/*
Allows us to test this program before making the GUI
 */

public class TerminalInterace {

    public static void main_loop() {
        while (true) {
            String input = Main.input.nextLine();
            if (input.equalsIgnoreCase("read")) {
                SaveManager.Save(Main.input.nextLine());
            } else if (input.equalsIgnoreCase("write") || input.equalsIgnoreCase("add")) {
                SaveManager.Load();
            } else if (input.equalsIgnoreCase("stop") || input.equalsIgnoreCase("end")) {
                break;
            } else {
                System.out.println("Cmd not recognized, Please try again");
            }

        }
    }
}
