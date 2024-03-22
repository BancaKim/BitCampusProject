import java.awt.*;
import java.awt.event.*;

public class AdapterEx2 extends Frame {

    TextField tf;
    TextArea ta;
    Button clearButton, exitButton;

    // Constructor to setup GUI components and event handlers
    public AdapterEx2() {
        setLayout(new BorderLayout()); // Use BorderLayout for frame
        
        tf = new TextField();
        add(tf, BorderLayout.NORTH); // Add TextField to top
        
        ta = new TextArea();
        add(ta, BorderLayout.CENTER); // Add TextArea to center

        Panel buttonPanel = new Panel(new FlowLayout()); // Panel for buttons
        clearButton = new Button("Clear");
        buttonPanel.add(clearButton);
        exitButton = new Button("Exit");
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH); // Add Panel to bottom

        // TextField action (Enter key) event handler
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ta.append(tf.getText() + "\n"); // Append text to TextArea
                tf.setText(""); // Clear TextField
            }
        });

        // "Clear" button click event handler
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ta.setText(""); // Clear TextArea
            }
        });

        // "Exit" button click event handler
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0); // Terminate the program
            }
        });

        setTitle("Adapter Example"); // "super" Frame sets title
        setSize(300, 200);           // "super" Frame sets initial size
        setVisible(true);            // "super" Frame shows

        // To close the window and exit the program
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0); // Terminate the program
            }
        });
    }

    // The entry main() method
    public static void main(String[] args) {
        new AdapterEx2();  // Let the constructor do the job
    }
}