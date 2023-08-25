import java.util.ArrayList;
import java.util.List;

/*
The list of tasks and extra information, such as the task set's name and user
 */
public class TaskList {
    public String Name;
    public List<Task> Tasks;

    public TaskList() {
        Name = "Default";
        Tasks = new ArrayList<>();
    }
}
