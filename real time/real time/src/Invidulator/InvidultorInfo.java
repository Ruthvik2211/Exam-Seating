package Invidulator;
import java.util.*;
import javax.swing.*;

import Admin.AdminType;

import java.awt.*;
import java.awt.event.*;
public class InvidultorInfo extends WindowAdapter implements ActionListener{
    JFrame f1;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton confirm;
    InvidulatorType st=new InvidulatorType(null,null);
    public InvidultorInfo(){
        f1=new JFrame("Enter your Info");
        l1=new JLabel("Name");
        l2=new JLabel("RollNo");
        //l3=new JLabel("Section");
        l4=new JLabel("Username");
        l5=new JLabel("Password");
        l6=new JLabel("Re-Enter Password");
        l7=new JLabel();
        t1=new JTextField();
        t2=new JTextField();
        //t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        confirm=new JButton("CONFIRM");
    }
    public void run(String un,String p){
        f1.add(l1);
        f1.add(l2);
        //f1.add(l3);
        f1.add(l4);
        f1.add(l5);
        f1.add(l6);
        f1.add(l7);
        f1.add(t1);
        f1.add(t2);
        //f1.add(t3);
        f1.add(t4);
        f1.add(t5);
        f1.add(t6);
        f1.add(confirm);
        l1.setBounds(50, 50, 200, 50);
        l2.setBounds(50,150,200,50);
        //l3.setBounds(50,250,200,50);
        l4.setBounds(50,350,200,50);
        l5.setBounds(50,450,200,50);
        l6.setBounds(50,550,200,50);
        l7.setBounds(150,750,200,50);
        t1.setBounds(300,50,200,50);
        t2.setBounds(300,150,200,50);
        //t3.setBounds(300,250,200,50);
        t4.setBounds(300,350,200,50);
        t5.setBounds(300,450,200,50);
        t6.setBounds(300,550,200,50);
        confirm.setBounds(150,650,200,50);
        f1.setSize(1000,1000);
        f1.setLayout(null);
        f1.setVisible(true);
        confirm.addActionListener(this);
        t4.setText(un);
        t5.setText(p);
        t6.setText(p);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(confirm)){
            if(t5.getText().equals(t6.getText())){
                new AdminType().addTempInv(t1.getText(), t2.getText(), t4.getText(), t5.getText());
            }
            else
                l7.setText("Both Passwords do not match");
        }
    }
    public void windowClosing(WindowEvent e){
        f1.dispose();
    }
}
