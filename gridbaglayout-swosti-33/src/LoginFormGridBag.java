import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFormGridBag {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Login Form using GridBagLayout");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // padding

        // Create components
        JLabel lblUser = new JLabel("Username:");
        JLabel lblPass = new JLabel("Password:");
        JTextField txtUser = new JTextField(15);
        JPasswordField txtPass = new JPasswordField(15);
        JButton btnLogin = new JButton("Login");
        JLabel lblMessage = new JLabel("");

        // Position components
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(lblUser, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        frame.add(txtUser, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(lblPass, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        frame.add(txtPass, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        frame.add(btnLogin, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        frame.add(lblMessage, gbc);

        // Action for button
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

        // Frame settings
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
