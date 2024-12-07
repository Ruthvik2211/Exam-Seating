package Room;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class EnterRooms extends WindowAdapter implements ActionListener{
    private JFrame f1;
    private JLabel l1,l2,l3;
    private JTextField t1,t2,t3;
    private JButton b;
    public EnterRooms(){
        f1=new JFrame("Rooms enter");
        l1=new JLabel("Class Name");
        l2=new JLabel("Start Num");
        l3=new JLabel("Ending Num");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        b=new JButton("Next");
    }
    public void run(){
        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(t1);
        f1.add(t2);
        f1.add(t3);
        f1.add(b);
        l1.setBounds(100,100,200,50);
        l2.setBounds(100, 200, 200, 50);
        l3.setBounds(100,300,200,50);
        t1.setBounds(350,100,200,50);
        t2.setBounds(350,200,200,50);
        t3.setBounds(350,300,200,50);
        b.setBounds(225,400,200,50);
        f1.setSize(1000,1000);
        f1.setLayout(null);
        f1.setVisible(true);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(b))
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                int smal=Integer.parseInt(t2.getText());
                int big=Integer.parseInt(t3.getText());
                for(int i=smal;i<=big;i++){
                    Statement st=con.createStatement();
                    String query="insert into class values("+i+",\'"+t1.getText()+"\')";
                    System.out.println(query);
                    st.executeUpdate(query);
                }
            }catch(Exception e){System.out.println(e);};    
    }
}
