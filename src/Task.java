/*
The task class, individual tasks will be represented by this
 */

import java.util.Date;

public class Task {
    public String Name;
    public String Description;
    public Date DueDate;
    public Urgency Urgency;

    public Task(String name, String description, Date date, Urgency urgency) {
        Name = name;
        Description = description;
        DueDate = date;
        this.Urgency = urgency;
    }
    public enum Urgency {
        None,
        Mild,
        Moderate,
        Critical
    }
}
