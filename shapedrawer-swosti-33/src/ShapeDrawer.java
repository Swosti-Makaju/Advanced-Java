/*
 * 	Design a form with three buttons with captions “Circle,” “Square,” and “Triangle.”
•	When the user clicks the “Circle” button, draw a red circle in the center of the frame.
•	When the user clicks the “Square” button, draw a blue square in the center of the frame.
•	When the user clicks the “Triangle” button, draw a green triangle in the center of the frame. 

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapeDrawer extends JFrame implements ActionListener {
    private String shape = "";  // Keeps track of which shape to draw
    private final DrawingPanel drawingPanel;

    public ShapeDrawer() {
        super("Shape Drawer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --------- Buttons Panel ---------
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton circleButton = new JButton("Circle");
        JButton squareButton = new JButton("Square");
        JButton triangleButton = new JButton("Triangle");

        circleButton.addActionListener(this);
        squareButton.addActionListener(this);
        triangleButton.addActionListener(this);

        buttonPanel.add(circleButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(triangleButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // --------- Drawing Panel ---------
        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        // Frame settings
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Event handling
    @Override
    public void actionPerformed(ActionEvent e) {
        shape = e.getActionCommand(); // Get button text (Circle, Square, Triangle)
        drawingPanel.repaint();
    }

    // --------- Inner Class for Drawing ---------
    class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();
            int size = Math.min(w, h) / 2; // Size of shape
            int x = (w - size) / 2;
            int y = (h - size) / 2;

            switch (shape) {
                case "Circle":
                    g.setColor(Color.RED);
                    g.fillOval(x, y, size, size);
                    break;
                case "Square":
                    g.setColor(Color.BLUE);
                    g.fillRect(x, y, size, size);
                    break;
                case "Triangle":
                    g.setColor(Color.GREEN);
                    int[] xPoints = {w / 2, x, x + size};
                    int[] yPoints = {y, y + size, y + size};
                    g.fillPolygon(xPoints, yPoints, 3);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShapeDrawer::new);
    }
}
    