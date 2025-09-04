import java.awt.*;
import java.awt.event.*;

public class MouseAdapterApp {
    Label lblOutput;
    TextField txtOne, txtTwo;

    MouseAdapterApp() {
        Frame f = new Frame("Sum and Difference using MouseAdapter");

        lblOutput = new Label("Result will be shown here");
        lblOutput.setBounds(20, 50, 200, 20);

        txtOne = new TextField();
        txtOne.setBounds(20, 80, 100, 20);

        txtTwo = new TextField();
        txtTwo.setBounds(20, 110, 100, 20);

        // Using MouseAdapter
        f.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    int a = Integer.parseInt(txtOne.getText());
                    int b = Integer.parseInt(txtTwo.getText());
                    lblOutput.setText("Sum = " + (a + b));
                } catch (Exception ex) {
                    lblOutput.setText("Invalid Input!");
                }
            }

            public void mouseReleased(MouseEvent e) {
                try {
                    int a = Integer.parseInt(txtOne.getText());
                    int b = Integer.parseInt(txtTwo.getText());
                    lblOutput.setText("Difference = " + (a - b));
                } catch (Exception ex) {
                    lblOutput.setText("Invalid Input!");
                }
            }
        });

        f.add(lblOutput);
        f.add(txtOne);
        f.add(txtTwo);

        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new MouseAdapterApp();
    }
}
