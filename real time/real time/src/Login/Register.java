package Login;
import Student.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Admin.AdminType;
import Invidulator.InvidultorInfo;
import Student.StudentInfo;
public class Register extends WindowAdapter implements ActionListener{
    JFrame f1;
    JLabel username,password;
    JTextField u,p;
    JRadioButton stu,inv;
    JButton b;
    Register(){
        f1=new JFrame("Registration");
        username=new JLabel("username");
        password=new JLabel("password");
        u=new JTextField();
        p=new JTextField();
        stu=new JRadioButton("Student");
        inv=new JRadioButton("Invidulator");
        b=new JButton("Continue");
        //AdminType at=new AdminType();
    }
    public void run(){
        f1.add(username);
        f1.add(password);
        f1.add(u);
        f1.add(p);
        f1.add(stu);
        f1.add(inv);
        f1.add(b);
        username.setBounds(50,50,200,50);
        password.setBounds(50,150,200,50);
        u.setBounds(300,50,200,50);
        p.setBounds(300,150,200,50);
        stu.setBounds(50,250,200,50);
        inv.setBounds(300,250,200,50);
        b.setBounds(150,350,250,50);
        f1.setSize(1000,1000);
        f1.setLayout(null);
        f1.setVisible(true);
        stu.addActionListener(this);
        inv.addActionListener(this);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(b)){
            if(stu.isSelected()){
                new StudentInfo().run(u.getText(),p.getText());
            }
            if(inv.isSelected()){
                new InvidultorInfo().run(u.getText(),p.getText());
            }
        }
    }
    public void windowClosing(WindowEvent e){
        f1.dispose();
        System.exit(0);
    }
}
