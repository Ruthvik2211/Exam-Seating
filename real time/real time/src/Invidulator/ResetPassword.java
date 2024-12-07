package Invidulator;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ResetPassword extends WindowAdapter implements ActionListener {
    JFrame f1;
    JPasswordField p1,p2;
    JLabel l,l1,l2;
    JButton b;
    private String username;
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
        System.out.println("1");
        try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","cvr123");
                    Statement st=con.createStatement();
                    String query="select * from invidulator_login";
                    System.out.println(query);
                    ResultSet rs=st.executeQuery(query);
                    if(rs==null)
                        System.out.println("Login Unsuccessfull");
                    else{
                        while(rs.next()){
                            if(password.equals(rs.getString(4))&&username.equals(rs.getString(3))){
                                this.username=username;
                                run();
                                break;
                            }
                        }
                    }
                }   
                catch(Exception x){System.out.println(11);}
        return "Passwords Not Matching";
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(b)){
            System.out.println(new String(p1.getPassword())+" "+new String(p2.getPassword()));
            if(new String(p1.getPassword()).equals(new String(p2.getPassword()))){
                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","cvr123");
                    Statement st=con.createStatement();
                    String query="select * from invidulator_login";
                    System.out.println(query);
                    ResultSet rs=st.executeQuery(query);
                    if(rs==null)
                        System.out.println("Login Unsuccessfull");
                    else{
                        while(rs.next()){
                            if(this.username.equals(rs.getString(3))){
                                st=con.createStatement();
                                query="update invidulator_login set password=\'"+(new String(p1.getPassword()))+"\' where login=\'"+this.username+"\'";
                                System.out.println(query);
                                st.executeUpdate(query);
                                break;
                            }
                        }
                    }
                }   
                catch(Exception x){System.out.println(x);}
                f1.dispose();
            }
        }
    }
}
