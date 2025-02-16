import java.awt.*;
import java.awt.event.*;

public class SimpleAWTApp {
    public static void main(String[] args) {
        // Create a Frame (window) and Button
        Frame frame = new Frame("AWT Button Example");
        Button button = new Button("Click Me");

        // Add Button ActionListener to display a message when clicked
        button.addActionListener(e -> System.out.println("Button clicked!"));

        // Add Button to Frame and set Frame properties
        frame.add(button);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        // Close application when window is closed
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
