import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame f=new JFrame(); //creating instance of JFrame
        JButton b=new JButton("click");  //creating instance of JButton
        b.setBounds(130, 100, 100, 40);  //x axis,yaxis,width,height

        f.add(b); //adding button iun JFrame
        f.setSize(400,500);  //400 width 500 height
        f.setLayout(null);   //using no layers managers
        f.setVisible(true); //making the frame visible 
    }
}