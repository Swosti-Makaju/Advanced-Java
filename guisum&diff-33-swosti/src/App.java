/*
 * Write a GUI program using components to find sum and difference of two numbers.
 * Use two text fields for giving input and a label for output. 
 * The program should display sum if user presses mouse and difference if user release mouse.
 */

import java.awt.*;
import java.awt.event.*;
public class App implements KeyListener {
    Label lbloutput;
    TextField txtOne;
   TextField txtTwo;
   App()
   {
    Frame f=new Frame();
    lbloutput=new Label();
    lbloutput.setBounds(20, 50, 100, 20);
    txtOne=new TextField();
    txtOne.setBounds(20,80,100, 20);
    txtTwo=new TextField();
    txtTwo.setBounds(20,110,100, 20);
    txtOne.addKeyListener(this);
    txtTwo.addKeyListener(this);
    f.add(lbloutput);
    f.add(txtOne);
    f.add(txtTwo);

    f.setSize(300,300);
    f.setLayout(null);
    f.setVisible(true);
   }
   public void keyPressed(KeyEvent e){
    int a=Integer.parseInt(txtOne.getText());
    int b=Integer.parseInt(txtTwo.getText());
    int c=a+b;
    lbloutput.setText(String.valueOf(c));
   }
   public void keyReleased(KeyEvent e){
    int a=Integer.parseInt(txtOne.getText());
    int b=Integer.parseInt(txtTwo.getText());
    int c=a-b;
    lbloutput.setText(String.valueOf(c));
   }
   public void keyTyped(KeyEvent e){ }
    public static void main(String[] args) throws Exception {
      new App();
    }
}