package Room;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class ArrangeSeats extends WindowAdapter implements ActionListener{
    JFrame f1;
    JLabel l1;
    JTextField t1;
    JButton b;
    private String str;
    public ArrangeSeats(){
        f1=new JFrame("Arrange Seats");
        l1=new JLabel("Date");
        t1=new JTextField();
        b=new JButton("Next");
    }
    public String run(){
        f1.add(l1);
        f1.add(t1);
        f1.add(b);
        l1.setBounds(250,475,200,50);
        t1.setBounds(550,475,200,50);
        b.setBounds(350,600,200,50);
        f1.setLayout(null);
        f1.setSize(1000,1000);
        f1.setVisible(true);
        f1.addWindowListener(this);
        b.addActionListener(this);
        return str;
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(b)){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                Statement st=con.createStatement();
                String query="select count(seatno) from class";
                ResultSet r1=st.executeQuery(query);
                r1.next();
                int count=r1.getInt(1);
                st=con.createStatement();
                query="select count(examid) from exam where scheduleid in (select scheduleid from schedule where examdate=to_date(\'"+t1.getText()+"\','dd-mm-yyyy'))";
                ResultSet r2=st.executeQuery(query);
                r2.next();
                int exCount=r2.getInt(1);
                if(count<exCount||exCount==0){
                    str="The people and seats are not matching";
                }
                else{
                    arrange();
                }
            }catch(Exception e){System.out.println(e);}
        }
    }
    public void arrange(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
            Statement st=con.createStatement();
            String query="select * from schedule where examdate=to_date(\'"+t1.getText()+"\','dd-mm-yyyy')";
            ResultSet rs=st.executeQuery(query);
            st=con.createStatement();
            query="select * from invidulator_login";
            ResultSet ro=st.executeQuery(query);
            st=con.createStatement();
            ro.next();
            int cnt=0;
            ResultSet ps=null;
            while(rs.next()){
                query="select * from exam where scheduleid="+rs.getInt(1);
                ResultSet rt=st.executeQuery(query);
                while(rt.next()){
                    st=con.createStatement();
                    if(cnt==0){
                        query="select * from class";
                        ps=st.executeQuery(query);
                        ps.next();
                        cnt++;
                    }
                    else if(!ps.next()){
                        query="select * from class";
                        ps=st.executeQuery(query);
                        ps.next();
                        ps.next();
                    }
                    st=con.createStatement();
                    query="insert into seat values("+ps.getInt(1)+",\'"+rt.getString(3)+"\',"+rt.getInt(1)+",\'"+ro.getString(1)+"\')";
                    st.executeUpdate(query);
                    ps.next();
                    ps.next();
                }
            }    
        }catch(Exception e){System.out.println(e);}
    }
}
