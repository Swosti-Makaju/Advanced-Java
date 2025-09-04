import javax.swing.*;
import java.awt.event.*;

public class App {
    public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Add Two Numbers");

        // Create labels
        JLabel lbl1 = new JLabel("Enter first number:");
        lbl1.setBounds(20, 20, 150, 20);

        JLabel lbl2 = new JLabel("Enter second number:");
        lbl2.setBounds(20, 60, 150, 20);

        JLabel lblResult = new JLabel("Result:");
        lblResult.setBounds(20, 140, 200, 20);

        // Create text fields
        JTextField txtOne = new JTextField();
        txtOne.setBounds(180, 20, 100, 20);

        JTextField txtTwo = new JTextField();
        txtTwo.setBounds(180, 60, 100, 20);

        JTextField txtResult = new JTextField();
        txtResult.setBounds(180, 140, 100, 20);
        txtResult.setEditable(false); // output only

        // Create button
        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(100, 100, 100, 30);

        // Add action listener to button
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(txtOne.getText());
                    int b = Integer.parseInt(txtTwo.getText());
                    int sum = a + b;
                    txtResult.setText(String.valueOf(sum));
                } catch (Exception ex) {
                    txtResult.setText("Invalid Input");
                }
            }
        });

        // Add components to frame
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(txtOne);
        frame.add(txtTwo);
        frame.add(btnAdd);
        frame.add(lblResult);
        frame.add(txtResult);

        // Frame settings
        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
