package Admin;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class ResetPassword extends WindowAdapter implements ActionListener {
    JFrame f1;
    JPasswordField p1,p2;
    JLabel l,l1,l2;
    JButton b;
    public ResetPassword(){
        f1=new JFrame();
        p1=new JPasswordField();
        p2=new JPasswordField();
        l1=new JLabel();
        l2=new JLabel();
        l=new JLabel();
        b=new JButton("Next");
    }
    public void run(){
        l1.setText("New Password");
        l2.setText("Enter Again");
        f1.add(p1);
        f1.add(p2);
        f1.add(l1);
        f1.add(l2);
        f1.add(l);
        f1.add(b);
        f1.setTitle("RESET PASSWORD");
        f1.setSize(1000,1000);
        l1.setBounds(300,250,200,50);
        l2.setBounds(300,350,200,50);
        l.setBounds(400,150,200,50);
        p1.setBounds(550,250,200,50);
        p2.setBounds(550,350,200,50);
        b.setBounds(400,450,200,50);
        f1.setLayout(null);
        f1.setVisible(true);
        b.addActionListener(this);
    }
    public String resetPass(String username,String password){
        AdminType at=new AdminType();
        if(at.verify_username(username)&&at.verify_password(password)){
           run(); 
           return null;
        }    
        return "Passwords Not Matching";
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(b)){
            System.out.println(new String(p1.getPassword())+" "+new String(p2.getPassword()));
            if(new String(p1.getPassword()).equals(new String(p2.getPassword()))){
                new AdminType().resetPass(new String(p1.getPassword()));
                f1.dispose();
            }
        }
    }
}
