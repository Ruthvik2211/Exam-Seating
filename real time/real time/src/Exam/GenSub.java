package Exam;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class GenSub extends WindowAdapter implements ActionListener{
    JFrame f1;
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b;
    public GenSub(){
        f1=new JFrame("Generate Subjects");
        l1=new JLabel("Subject No");
        l2=new JLabel("Subject Name");
        t1=new JTextField();
        t2=new JTextField();
        b=new JButton("Next");
    }
    public void run(){
        f1.add(l1);
        f1.add(l2);
        f1.add(t1);
        f1.add(t2);
        f1.add(b);
        l1.setBounds(100,50,200,50);
        l2.setBounds(100, 150, 200, 50);
        t1.setBounds(300,50,200,50);
        t2.setBounds(300,150,200,50);
        b.setBounds(200,250,200,50);
        f1.setSize(1000,1000);
        f1.setLayout(null);
        f1.setVisible(true);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(b)){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                Statement st=con.createStatement();
                String query="insert into subjects values("+t1.getText()+",\'"+t2.getText()+"\')";
                st.executeUpdate(query);
            }catch(Exception e){System.out.println(e);}
        }
    }
}
