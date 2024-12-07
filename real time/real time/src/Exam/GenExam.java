package Exam;
import java.util.*;
import java.util.Date;
import java.sql.*;
import javax.swing.*;

import Admin.AdminType;

import java.awt.*;
import java.awt.event.*;
public class GenExam extends WindowAdapter implements ActionListener{
    private JFrame f1;
    private JLabel l1,l2,l3,l4,l5,l6;
    private JTextField t1,t2,t3,t4,t5,t6;
    private JButton b;
    private static int cnt;
    public GenExam(){
        f1=new JFrame("Exam Info");
        //l1=new JLabel("");
        l2=new JLabel("Roll no");
        l3=new JLabel("Exam Name");
        l4=new JLabel("Subject Name");
        //l5=new JLabel("Invidulator Id");
        //l6=new JLabel("Exam Date");
        //t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        //t5=new JTextField();
        //t6=new JTextField();
        b=new JButton("Next");
        cnt=new AdminType().adminCount();
    }
    public void run(){
        //f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        //f1.add(l5);
        //f1.add(l6);
        //f1.add(t1);
        f1.add(t2);
        f1.add(t3);
        f1.add(t4);
        //f1.add(t5);
        //f1.add(t6);
        f1.add(b);
        //l1.setBounds(50,50,200,50);
        l2.setBounds(50,150,200,50);
        l3.setBounds(50,250,200,50);
        l4.setBounds(50,350,200,50);
        //l5.setBounds(50,450,200,50);
        //l6.setBounds(50,550,200,50);
        //t1.setBounds(300,50,200,50);
        t2.setBounds(300,150,200,50);
        t3.setBounds(300,250,200,50);
        t4.setBounds(300,350,200,50);
        //t5.setBounds(300,450,200,50);
        //t6.setBounds(300,550,200,50);
        b.setBounds(200,650,200,50);
        f1.setSize(1000,1000);
        f1.setLayout(null);
        f1.setVisible(true);
        b.addActionListener(this);
        f1.addWindowListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(b)){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                Statement st=con.createStatement();
                boolean b=false,c=false;
                String query="select * from schedule where enroldate>=(select SYSDATE from DUAL) and examname=\'"+t3.getText()+"\' and subjectid=(select subjectid from subjects where subjectname=\'"+t4.getText()+"\')";
                System.out.println(query);
                ResultSet rs=st.executeQuery(query);
                if(rs.next()){
                    st=con.createStatement();
                    query="insert into exam values("+cnt+","+rs.getInt(1)+",\'"+t2.getText()+"\')";
                    System.out.println(query);
                    st.executeUpdate(query);
                    f1.dispose();
                    
                    cnt++;
                    return;
                }
                
            }catch(Exception e){System.out.println(e);}
        }
    }
    public void windowClosing(WindowEvent we){
        f1.dispose();
    }
}
