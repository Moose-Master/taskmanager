import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/*
Saves and loads lists of tasks
 */
public class SaveManager {
    public static final String saveFile = "tasks.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void Save(TaskList tasks, String file) {
        try(FileWriter fw = new FileWriter(file)) {
            gson.toJson(tasks, TaskList.class, fw);
        } catch(Exception e) {
            System.out.println("Error in formatting json: " + e);
            System.exit(0);
        }
    }
    public static void Save(TaskList tasks) {
        Save(tasks, saveFile);
    }
    public static TaskList Load(String file) {
        try(FileReader fr = new FileReader(file)) {
            TaskList t = gson.fromJson(fr, TaskList.class);
            if(t == null) {
                t = new TaskList();
                Save(t);
            } else if(t.Tasks == null) {
                t.Tasks = new ArrayList<>();
                Save(t);
            }
            return t;
        } catch(Exception e) {
            System.out.println("Error in reading json: " + e + "\nCreating new tasks file");
            TaskList t = new TaskList();
            Save(t);
            return t;
        }
    }
    public static TaskList Load() {
        return Load(saveFile);
    }
}
