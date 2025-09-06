/*
 * Write a program to Create a Form Below using Swing and perform Add, Subtract, Multiply and Divide as user click button with selected option.
 */

import javax.swing.*;
import java.awt.event.*;

public class CalculatorForm {
    public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Simple Calculator");

        // Labels
        JLabel lbl1 = new JLabel("Enter first number:");
        lbl1.setBounds(20, 20, 150, 20);

        JLabel lbl2 = new JLabel("Enter second number:");
        lbl2.setBounds(20, 60, 150, 20);

        JLabel lblResult = new JLabel("Result:");
        lblResult.setBounds(20, 180, 200, 20);

        // Text fields
        JTextField txtOne = new JTextField();
        txtOne.setBounds(180, 20, 100, 20);

        JTextField txtTwo = new JTextField();
        txtTwo.setBounds(180, 60, 100, 20);

        JTextField txtResult = new JTextField();
        txtResult.setBounds(180, 180, 100, 20);
        txtResult.setEditable(false); // Output only

        // Buttons
        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(20, 110, 80, 30);

        JButton btnSub = new JButton("Subtract");
        btnSub.setBounds(110, 110, 100, 30);

        JButton btnMul = new JButton("Multiply");
        btnMul.setBounds(220, 110, 100, 30);

        JButton btnDiv = new JButton("Divide");
        btnDiv.setBounds(330, 110, 100, 30);

        // Action listeners for buttons
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(txtOne.getText());
                    int b = Integer.parseInt(txtTwo.getText());
                    txtResult.setText(String.valueOf(a + b));
                } catch (Exception ex) {
                    txtResult.setText("Invalid Input");
                }
            }
        });

        btnSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(txtOne.getText());
                    int b = Integer.parseInt(txtTwo.getText());
                    txtResult.setText(String.valueOf(a - b));
                } catch (Exception ex) {
                    txtResult.setText("Invalid Input");
                }
            }
        });

        btnMul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(txtOne.getText());
                    int b = Integer.parseInt(txtTwo.getText());
                    txtResult.setText(String.valueOf(a * b));
                } catch (Exception ex) {
                    txtResult.setText("Invalid Input");
                }
            }
        });

        btnDiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(txtOne.getText());
                    int b = Integer.parseInt(txtTwo.getText());
                    if (b != 0)
                        txtResult.setText(String.valueOf((double) a / b));
                    else
                        txtResult.setText("Cannot divide by 0");
                } catch (Exception ex) {
                    txtResult.setText("Invalid Input");
                }
            }
        });

        // Add components
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(txtOne);
        frame.add(txtTwo);
        frame.add(lblResult);
        frame.add(txtResult);
        frame.add(btnAdd);
        frame.add(btnSub);
        frame.add(btnMul);
        frame.add(btnDiv);

        // Frame settings
        frame.setSize(470, 270);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
