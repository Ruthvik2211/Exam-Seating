package Admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class GetPassword extends WindowAdapter implements ActionListener{
    JFrame f1;
    JLabel l,l1,l2;
    JPasswordField p;
    JTextField t;
    JButton b;
    public GetPassword(){
        f1=new JFrame("Inputs");
        l1=new JLabel("UserName");
        l2=new JLabel("Password");
        t=new JTextField();
        p=new JPasswordField();
        l=new JLabel();
        b=new JButton();
    }
    public void run(){
        f1.add(l);
        f1.add(l1);
        f1.add(l2);
        f1.add(t);
        f1.add(p);
        f1.add(b);
        l1.setBounds(300,50,200,50);
        l1.setBounds(200,150,200,50);
        l2.setBounds(200,250,200,50);
        t.setBounds(500,150,200,50);
        p.setBounds(500,250,200,50);
        b.setBounds(400,350,200,50);
        f1.setSize(1000,1000);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.addWindowListener(this);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(b)){
            String s=new ResetPassword().resetPass(t.getText(),new String(p.getPassword()));
            if(s!=null)
                l.setText(s);
        }
    }
    public void windowClosing(WindowEvent e){

    }
}
