//12.Write a Java Swing program to create a toolbar with three buttons. Each button should display an icon (New, Login, and Logout). Place the toolbar at the top of the window using a suitable layout. When a button is clicked, display a message dialog showing the name of the action (e.g., “New File Created”, “Login Successful”, “Logged Out”).

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Toolbar extends JFrame implements ActionListener {

    private JButton newButton, loginButton, logoutButton;

    public Toolbar() {
        super("Toolbar Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create toolbar
        JToolBar toolbar = new JToolBar();

        // Create buttons with icons
newButton = new JButton("New");
loginButton = new JButton("Login");
logoutButton = new JButton("Logout");


      
        // Add ActionListener
        newButton.addActionListener(this);
        loginButton.addActionListener(this);
        logoutButton.addActionListener(this);

        // Add buttons to toolbar
        toolbar.add(newButton);
        toolbar.add(loginButton);
        toolbar.add(logoutButton);

        // Add toolbar to frame (North position)
        add(toolbar, BorderLayout.NORTH);

        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newButton)
            JOptionPane.showMessageDialog(this, "New File Created");
        else if (e.getSource() == loginButton)
            JOptionPane.showMessageDialog(this, "Login Successful");
        else if (e.getSource() == logoutButton)
            JOptionPane.showMessageDialog(this, "Logged Out");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Toolbar::new);
    }
}
