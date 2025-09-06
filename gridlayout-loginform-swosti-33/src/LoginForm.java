/*
 * Create a Simple Login Form using GridLayout in Java.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Login Form");

        // Set GridLayout with 3 rows and 2 columns
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        // Create labels
        JLabel lblUser = new JLabel("Username:");
        JLabel lblPass = new JLabel("Password:");

        // Create text fields
        JTextField txtUser = new JTextField();
        JPasswordField txtPass = new JPasswordField();

        // Create button
        JButton btnLogin = new JButton("Login");

        // Create message label
        JLabel lblMessage = new JLabel("");

        // Add action listener
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = txtUser.getText();
                String pass = new String(txtPass.getPassword());

                if (user.equals("admin") && pass.equals("1234")) {
                    lblMessage.setText("Login Successful!");
                } else {
                    lblMessage.setText("Invalid Username or Password");
                }
            }
        });

        // Add components to frame
        frame.add(lblUser);
        frame.add(txtUser);
        frame.add(lblPass);
        frame.add(txtPass);
        frame.add(btnLogin);
        frame.add(lblMessage);

        // Frame settings
        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
