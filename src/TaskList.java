import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/*
The list of tasks and extra information, such as the task set's name and user
 */
public class TaskList {
    @Expose
    public String Name;
    @Expose
    public List<Task> Tasks;
    public transient GuiManager Gui;
    public transient String FileName;
    public transient NetworkSync NetworkSynchronizer;

    public TaskList() {
        Name = "Default";
        Tasks = new ArrayList<>();
        FileName = SaveManager.saveFile;
        NetworkSynchronizer = null;
        Gui = new GuiManager();
    }
    public void Add(Task task) {
        Tasks.add(task);
        Update();
    }
    public void Update() {
        SaveManager.Save(this, FileName);
        if(NetworkSynchronizer != null) NetworkSynchronizer.Sync(this);
        if(Gui != null) Gui.Update();
    }
    public int GetTask(String name) {
        for(int i = 0;i < Tasks.size();i++) {
            if (Tasks.get(i).Name.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
}
