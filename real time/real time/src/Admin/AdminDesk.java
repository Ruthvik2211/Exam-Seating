package Admin;
import java.awt.*;
import Exam.GenExam;
import Exam.GenSchedule;
import Exam.GenSub;
import Room.ArrangeSeats;
import Room.EnterRooms;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class AdminDesk extends WindowAdapter implements ActionListener {
    private JFrame f1;
    private JLabel l1;
    private JButton rePass,BlockStu,BlockInv,AddSchedule,AddSubject;
    public AdminDesk(){
        f1=new JFrame("Admin Desk");
        l1=new JLabel(new AdminType().getUsername());
        rePass=new JButton("Reset Password");
        BlockStu=new JButton("Enter Rooms");
        BlockInv=new JButton("Arrange Seats");
        AddSchedule=new JButton("Add New Schedule");
        AddSubject=new JButton("Add subject");
    }
    public void run(){
        f1.add(l1);
        
        f1.add(rePass);
        f1.add(AddSchedule);
        f1.add(BlockInv);
        f1.add(BlockStu);
        f1.add(AddSubject);
        f1.setSize(1000,1000);
        l1.setBounds(f1.getSize().width-200,20,200,50);
        rePass.setBounds(50,50,150,150);
        BlockStu.setBounds(250,50,150,150);
        BlockInv.setBounds(50,250,150,150);
        AddSchedule.setBounds(250,250,150,150);
        AddSubject.setBounds(450,50,150,150);
        f1.setLayout(null);
        f1.setBackground(new Color(5));
        f1.setVisible(true);
        
        f1.addWindowStateListener(this);
        rePass.addActionListener(this);
        BlockStu.addActionListener(this);
        AddSubject.addActionListener(this);
        BlockInv.addActionListener(this);
        AddSchedule.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(rePass)){
            new GetPassword().run(); 
        }
        if(ae.getSource().equals(AddSchedule)){
            new GenSchedule().run();
        }
        if(ae.getSource().equals(AddSubject)){
            new GenSub().run();
        }
        if(ae.getSource().equals(BlockStu)){
            new EnterRooms().run();
        }
        if(ae.getSource().equals(BlockInv)){
            String s=new ArrangeSeats().run();
        }
    }
    public void windowStateChanged(WindowEvent e){
        System.out.println(f1.getSize().width);
        l1.setBounds(f1.getSize().width-200,20,200,50);
    }
    public void windowClosing(WindowEvent we){
        f1.dispose();
    }
}
