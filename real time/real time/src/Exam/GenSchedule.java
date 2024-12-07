package Exam;
import java.util.*;
import java.util.Date;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class GenSchedule extends WindowAdapter implements ActionListener{
    private JFrame f1;
    private JLabel id,subid,name,examdate,enroldate;
    private JTextField i,si,na,ed,enrd;
    private JButton b;


    public GenSchedule(){
        f1=new JFrame("Exam Info");
        id=new JLabel("Exam Id");
        subid=new JLabel("Subject Id");
        name=new JLabel("Exam Name");
        examdate=new JLabel("Student Id");
        enroldate=new JLabel("Invidulator Id");
        //l6=new JLabel("Exam Date");
        i=new JTextField();
        si=new JTextField();
        na=new JTextField();
        ed=new JTextField();
        enrd=new JTextField();
        //t6=new JTextField();
        b=new JButton("Next");
    }
    public void run(){
        f1.add(id);
        f1.add(subid);
        f1.add(name);
        f1.add(examdate);
        f1.add(enroldate);
        f1.add(i);
        f1.add(si);
        f1.add(na);
        f1.add(ed);
        f1.add(enrd);
        //f1.add(t5);
        Date d=new Date();
        //f1.add(t6);
        f1.add(b);
        id.setBounds(50,50,200,50);
        subid.setBounds(50,150,200,50);
        name.setBounds(50,250,200,50);
        examdate.setBounds(50,350,200,50);
        enroldate.setBounds(50,450,200,50);
        //l6.setBounds(50,550,200,50);
        i.setBounds(300,50,200,50);
        si.setBounds(300,150,200,50);
        na.setBounds(300,250,200,50);
        ed.setBounds(300,350,200,50);
        enrd.setBounds(300,450,200,50);
        //t6.setBounds(300,550,200,50);
        b.setBounds(200,550,200,50);
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
                String query="insert into schedule values("+i.getText()+","+si.getText()+",\'"+na.getText()+"\',"+"to_date(\'"+ed.getText()+"\',\'dd-mm-yyyy\')"+",to_date(\'"+enrd.getText()+"\',\'dd-mm-yyyy\'))";
                System.out.println(query);
                st.executeUpdate(query);
            }catch(Exception e){System.out.println(e);}
        }
    }
}
