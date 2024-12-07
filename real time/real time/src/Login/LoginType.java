package Login;
import Admin.AdminType;
import Admin.AdminDesk;
import Invidulator.InvidulatorDesk;
import Student.StudentDesk;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class LoginType extends WindowAdapter implements ActionListener{
    private JFrame f1;
    private JLabel l1,l2,l3;
    private JTextField s,i,r;
    private JRadioButton c,d,a;
    private JButton b,rb;
    private JPasswordField p;
    public LoginType(){
        f1=new JFrame("Login Page");
        l1=new JLabel("Username");
        l2=new JLabel("Password");
        l1.setFont(new Font("Username", 5, 20));
        l2.setFont(new Font("Username", 5, 20));
        c=new JRadioButton("Student");
        d=new JRadioButton("Invidulator");
        a=new JRadioButton("Admin");
        s=new JTextField();
        p=new JPasswordField();
        b=new JButton("Login");
        rb=new JButton("Register If New");
        AdminType at=new AdminType();
        Register re=new Register();
    }
    public void run(){
        f1.add(l1);
        f1.add(l2);
        f1.add(s);
        f1.add(p);
        f1.add(c);
        f1.add(d);
        f1.add(a);
        f1.add(b);
        f1.add(rb);
        l1.setBounds(50,80,200,50);
        l2.setBounds(50,200,200,50);
        s.setBounds(300,80,200,50);
        p.setBounds(300,200,200,50);
        c.setBounds(50, 350, 200, 50);
        d.setBounds(300, 350, 200, 50);
        a.setBounds(550,350,200,50);
        b.setBounds(150, 450, 250, 50);
        rb.setBounds(150,550,250,50);
        f1.setSize(1000, 1000);
        f1.setLayout(null);
        f1.setVisible(true);
        a.addActionListener(this);
        s.addActionListener(this);
        p.addActionListener(this);
        b.addActionListener(this);
        rb.addActionListener(this);
        f1.addWindowListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(b)){
            if(c.isSelected()){
                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","cvr123");
                    Statement st=con.createStatement();
                    String query="select * from student_login";
                    System.out.println(query);
                    ResultSet rs=st.executeQuery(query);
                    if(rs==null)
                        System.out.println("Login Unsuccessfull");
                    else{
                        while(rs.next()){
                            if(rs.getString(5).equals(new String(p.getPassword()))&&rs.getString(4).equals(s.getText())){
                                new StudentDesk(rs.getString(4)).run();
                                break;
                            }
                        }
                    }
                }   
                catch(Exception x){System.out.println(x);}
            }
            if(d.isSelected()){
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
                            if(rs.getString(4).equals(new String(p.getPassword()))&&rs.getString(3).equals(s.getText())){
                                new InvidulatorDesk(rs.getString(3)).run();
                                System.out.println("Login Successful");
                                break;
                            }
                        }
                    }
                }   
                catch(Exception x){System.out.println(x);}
            }
            if(a.isSelected()){
                AdminType at=new AdminType();
                if(at.verify_username(s.getText())&&at.verify_password(new String(p.getPassword())))
                    new AdminDesk().run();
            }
        }
        if(e.getSource().equals(rb)){
            new Register().run();
        }
    }
    public void windowClosing(WindowEvent we){
        f1.dispose();
        System.exit(0);
    }
}

