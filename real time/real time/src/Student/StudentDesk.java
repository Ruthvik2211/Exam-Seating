package Student;
import java.awt.*;
import javax.swing.*;

import Exam.GenExam;

import java.awt.event.*;
import java.sql.*;
public class StudentDesk extends WindowAdapter implements ActionListener {
    private JFrame f1;
    private JLabel l1;
    private JButton rePass,BlockStu,BlockInv,AddExam;
    public StudentDesk(String username){
        f1=new JFrame("Admin Desk");
        l1=new JLabel(username);
        rePass=new JButton("Reset Password");
        BlockStu=new JButton("Block Student");
        BlockInv=new JButton("Block Invidulator");
        AddExam=new JButton("Add New Exam");
    }
    public void run(){
        f1.add(l1);
        f1.add(rePass);
        f1.add(AddExam);
        f1.add(BlockInv);
        f1.add(BlockStu);
        f1.setSize(1000,1000);
        l1.setBounds(f1.getSize().width-200,20,200,50);
        rePass.setBounds(50,50,200,200);
        BlockStu.setBounds(350,50,200,200);
        BlockInv.setBounds(50,350,200,200);
        AddExam.setBounds(350,350,200,200);
        f1.setLayout(null);
        f1.setBackground(new Color(5));
        f1.setVisible(true);
        f1.addWindowStateListener(this);
        rePass.addActionListener(this);
        BlockStu.addActionListener(this);
        BlockInv.addActionListener(this);
        AddExam.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(rePass)){
            new GetPassword().run(); 
        }
        if(ae.getSource().equals(AddExam)){
            new GenExam().run();
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
