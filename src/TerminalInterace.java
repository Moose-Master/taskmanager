/*
Allows us to test this program before making the GUI
 */

import java.util.Date;

public class TerminalInterace {
    static TaskList t_list = SaveManager.Load();
    public static void main_loop() {
        while (true) {
            System.out.println("What would you like to do? ");
            String input = Main.input.nextLine();
            if (input.equalsIgnoreCase("read")) {
                for(Task t : t_list.Tasks) {
                    System.out.println("\n" +"Name " + t.Name + "\n" + "Description " + t.Description + "\n" + "Urgency " + t.Urgency + "\n" + "DueDate " + t.DueDate);
                }
            } else if (input.equalsIgnoreCase("write") || input.equalsIgnoreCase("add")) {
                save_text();
            } else if (input.equalsIgnoreCase("stop") || input.equalsIgnoreCase("end") || input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.exit(0);
            } else if(input.equalsIgnoreCase("remove") || input.equalsIgnoreCase("delete")) {
                remove_task();
            } else {
                System.out.println("Cmd not recognized, Please try again");
            }

        }
    }

    public static void remove_task() {
        System.out.println("Name? ");
        int index;
        while((index = t_list.GetTask(Main.input.nextLine())) == -1) {
            System.out.println("Task doesn't exist!");
        }
        t_list.Tasks.remove(index);
        t_list.Update();
    }

    public static void save_text(){
        System.out.println("Name? ");
        String t_name;
        while(t_list.GetTask(t_name = Main.input.nextLine()) != -1) {
            System.out.println("Task already exists");
        }
        System.out.println(("Desrption? "));
        String t_descrpt = Main.input.nextLine();
        System.out.println("On a scale from 0-3 how uragent is it?");
        String t_urgancy_1 = Main.input.nextLine();
        String t_urgancy;
        if (t_urgancy_1.equalsIgnoreCase("0"))
             t_urgancy = "None";
        else if (t_urgancy_1.equalsIgnoreCase("1"))
             t_urgancy = "Mild";
        else if (t_urgancy_1.equalsIgnoreCase("2"))
             t_urgancy = "Moderate";
        else if (t_urgancy_1.equalsIgnoreCase("3"))
            t_urgancy = "Critical";
        else
            t_urgancy = "None";
        t_list.Add(new Task(t_name,t_descrpt,new Date(),Urgency.valueOf(t_urgancy)));
        t_list.Update();
    }

}

