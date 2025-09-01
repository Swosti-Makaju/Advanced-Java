import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
      JFrame f= new JFrame();
      String data[][]={{"101","Swosti","100000"},
                       {"102","Rita","110000"},
                       {"103","Sita","90000"}};
      String column[]={"ID","NAME","SALARY"};
      JTable jt= new JTable(data,column);
      jt.setBounds(30, 40, 200, 300);
      JScrollPane sp= new JScrollPane(jt);
      f.add(sp);
      f.setSize(300,400);
      f.setVisible(true);
    }
}