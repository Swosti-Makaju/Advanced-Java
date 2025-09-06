/*
 * Write a program that divides the frame into five regions by using border layout and then add panels in the east, north and center region. Finally add some descriptive label in the north panel, buttons with icon in the east panel and a sample form in the center panel. You can further subdivide the center panel, if necessary. Prepare a program with three text boxes First Number, Second Number, and Result and four buttons add, subtract, multiply and divide. Handle the events to perform the required operation and display results
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple calculator application that demonstrates the use of BorderLayout,
 * JPanels, and basic event handling in Java Swing.
 * The frame is divided into three main regions: North, East, and Center.
 * The Center region contains the main calculator form, and the other regions
 * have descriptive labels and control buttons.
 */
public class CalculatorApp extends JFrame implements ActionListener {

    // Center Panel Components
    private final JTextField firstNumberField;
    private final JTextField secondNumberField;
    private final JTextField resultField;
    private final JButton addButton;
    private final JButton subtractButton;
    private final JButton multiplyButton;
    private final JButton divideButton;

    /**
     * Constructs the main application frame.
     */
    public CalculatorApp() {
        // Set up the main frame properties
        super("Border Layout Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10)); // Use BorderLayout with gaps

        // --- North Panel: Descriptive Label ---
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(240, 240, 240));
        JLabel northLabel = new JLabel("Welcome to the Calculator Application", SwingConstants.CENTER);
        northLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        northPanel.add(northLabel);
        this.add(northPanel, BorderLayout.NORTH);

        // --- East Panel: Control Buttons with Icons ---
        JPanel eastPanel = new JPanel(new GridLayout(4, 1, 10, 10)); // 4 rows, 1 col, with gaps
        eastPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10)); // Add padding
        eastPanel.setBackground(new Color(220, 220, 220));

        // Create buttons with text as a simple "icon" to represent the operation
        this.addButton = new JButton("+");
        this.subtractButton = new JButton("-");
        this.multiplyButton = new JButton("×");
        this.divideButton = new JButton("÷");

        // Add action listeners to the buttons
        this.addButton.addActionListener(this);
        this.subtractButton.addActionListener(this);
        this.multiplyButton.addActionListener(this);
        this.divideButton.addActionListener(this);

        // Add tooltips to explain button function
        this.addButton.setToolTipText("Add numbers");
        this.subtractButton.setToolTipText("Subtract numbers");
        this.multiplyButton.setToolTipText("Multiply numbers");
        this.divideButton.setToolTipText("Divide numbers");

        // Add buttons to the east panel
        eastPanel.add(this.addButton);
        eastPanel.add(this.subtractButton);
        eastPanel.add(this.multiplyButton);
        eastPanel.add(this.divideButton);
        this.add(eastPanel, BorderLayout.EAST);

        // --- Center Panel: The Main Calculator Form ---
        JPanel centerPanel = new JPanel(new BorderLayout(20, 20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding
        centerPanel.setBackground(new Color(250, 250, 250));

        // Create a sub-panel for the input fields and labels
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Enter Numbers"));
        
        // Initialize text fields
        this.firstNumberField = new JTextField(15);
        this.secondNumberField = new JTextField(15);
        this.resultField = new JTextField(15);
        this.resultField.setEditable(false); // Result field is read-only

        // Add labels and fields to the form panel
        formPanel.add(new JLabel("First Number:"));
        formPanel.add(this.firstNumberField);
        formPanel.add(new JLabel("Second Number:"));
        formPanel.add(this.secondNumberField);
        formPanel.add(new JLabel("Result:"));
        formPanel.add(this.resultField);
        
        centerPanel.add(formPanel, BorderLayout.CENTER);

        // Add the center panel to the main frame
        this.add(centerPanel, BorderLayout.CENTER);

        // Set the size and make the frame visible
        this.setSize(600, 350);
        this.setLocationRelativeTo(null); // Center the frame on the screen
        this.setVisible(true);
    }

    /**
     * Handles the button click events.
     * @param e The ActionEvent generated by the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Get input from text fields and parse to double
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            // Check which button was clicked and perform the operation
            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                // Handle division by zero
                if (num2 == 0) {
                    resultField.setText("Error: Div by zero");
                    return;
                }
                result = num1 / num2;
            }

            // Display the result
            resultField.setText(String.format("%.2f", result));

        } catch (NumberFormatException ex) {
            // Handle invalid input (non-numeric text)
            resultField.setText("Invalid Input");
        }
    }

    /**
     * Main method to start the application.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread
        SwingUtilities.invokeLater(CalculatorApp::new);
    }
}
