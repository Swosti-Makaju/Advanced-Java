import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.MouseEvent;
public class App {
    public static void main(String[] args) throws Exception {
     
        JFrame f=new JFrame();
        JPopupMenu popupMenu=new JPopupMenu("Edit");
        JMenuItem cut=new JMenuItem("cut");
        JMenuItem copy=new JMenuItem("Copy");
        JMenuItem paste=new JMenuItem("Paste");
        popupMenu.add(cut);
         popupMenu.add(copy);
          popupMenu.add(paste);


          f.addMouseListener(new MouseInputAdapter(){
            public void mouseClicked(MouseEvent e){
                popupMenu.show(f, e.getX(), e.getY());
            }
          });
          f.add(popupMenu);
          f.setSize(300,300);
          f.setLayout(null);
          f.setVisible(true);
    }
}
