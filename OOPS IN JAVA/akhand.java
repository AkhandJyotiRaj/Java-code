import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class akhand {

    public static void main(String[] args) {
        // Create the main frame for the Swing window
        JFrame frame = new JFrame("Text Area Saver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the JTextArea for input
        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create the JButton to trigger saving the text
        JButton saveButton = new JButton("Save to File");

        // Add an ActionListener to the button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the JTextArea
                String text = textArea.getText();

                // Write the text to a file (ABC.txt), appending if the file exists
                try {
                    // Define the file path (ABC.txt)
                    Path path = Paths.get("ABC.txt");
                    // Append the text to the file
                    Files.write(path, (text + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    // Clear the text area after saving
                    textArea.setText("");
                    JOptionPane.showMessageDialog(frame, "Text saved successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving text: " + ex.getMessage());
                }
            }
        });

        // Set the layout for the frame
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);

        // Set the frame visibility
        frame.setVisible(true);
    }
}
