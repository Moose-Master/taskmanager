import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GuiManager {
    public TaskList Tasks;
    JFrame Frame;
    JPanel Panel;
    public GuiManager() {
        Frame = new JFrame();
        Panel = new JPanel();
        Panel.setBorder(BorderFactory.createEmptyBorder(400, 400, 400, 400));
        Panel.setLayout(new GridLayout(0, 1));
        Panel.setBackground(Color.BLACK);
        Frame.add(Panel, BorderLayout.CENTER);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setTitle("Task Manager");
        Frame.pack();
        Frame.setVisible(true);
    }
    public void Update() {

    }
}
