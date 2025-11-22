//11.Design a Swing application that contains three radio buttons labeled "Red", "Green", and "Blue". When the user selects a radio button, the background color of the window should change to the selected color. Implement event handling using an ItemListener.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChangerApp extends JFrame implements ItemListener {

    private JRadioButton redButton, greenButton, blueButton;
    private ButtonGroup colorGroup;

    public ColorChangerApp() {
        super("Radio Button Color Changer");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create radio buttons
        redButton = new JRadioButton("Red");
        greenButton = new JRadioButton("Green");
        blueButton = new JRadioButton("Blue");

        // Group them so only one can be selected
        colorGroup = new ButtonGroup();
        colorGroup.add(redButton);
        colorGroup.add(greenButton);
        colorGroup.add(blueButton);

        // Add ItemListener
        redButton.addItemListener(this);
        greenButton.addItemListener(this);
        blueButton.addItemListener(this);

        // Add components to frame
        add(redButton);
        add(greenButton);
        add(blueButton);

        // Window setup
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (redButton.isSelected()) {
            getContentPane().setBackground(Color.RED);
        } 
        else if (greenButton.isSelected()) {
            getContentPane().setBackground(Color.GREEN);
        } 
        else if (blueButton.isSelected()) {
            getContentPane().setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorChangerApp::new);
    }
}
