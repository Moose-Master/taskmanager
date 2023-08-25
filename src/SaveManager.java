import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

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
            return gson.fromJson(fr, TaskList.class);
        } catch(Exception e) {
            System.out.println("Error in reading json: " + e);
            System.exit(0);
            return null;
        }
    }
    public static TaskList Load() {
        return Load(saveFile);
    }
}
