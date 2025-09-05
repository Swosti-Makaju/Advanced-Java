import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorButtonApp extends JFrame implements ActionListener {
    private final JButton redButton, blueButton, greenButton;

    public ColorButtonApp() {
        super("Color Button Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create buttons
        redButton = new JButton("RED");
        blueButton = new JButton("BLUE");
        greenButton = new JButton("GREEN");

        // Add listeners
        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        greenButton.addActionListener(this);

        // Add to frame
        add(redButton);
        add(blueButton);
        add(greenButton);

        // Frame settings
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == redButton) redButton.setBackground(Color.RED);
        else if (src == blueButton) blueButton.setBackground(Color.BLUE);
        else if (src == greenButton) greenButton.setBackground(Color.GREEN);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorButtonApp::new);
    }
}
