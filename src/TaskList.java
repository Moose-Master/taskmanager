import java.util.ArrayList;
import java.util.List;

/*
The list of tasks and extra information, such as the task set's name and user
 */
public class TaskList {
    public String Name;
    public List<Task> Tasks;
    public GuiManager Gui;
    public String FileName;
    public NetworkSync NetworkSynchronizer;

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
}
