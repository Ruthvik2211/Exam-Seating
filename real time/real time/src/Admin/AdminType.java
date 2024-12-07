package Admin;
import java.util.*;
import java.sql.*;
public class AdminType {
    private String name;
    private String pass;
    private String username;
    private int Admin_Login_Count;
    private static int cnt;
    public AdminType(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
            Statement st=con.createStatement();
            String query="select * from admins";
            ResultSet rs=st.executeQuery(query);
            rs.next();
            this.username=rs.getString(1);
            this.pass=rs.getString(2);
            cnt=rs.getInt(3);
            System.out.println(username+" "+cnt+""+pass);
            }catch(Exception e){System.out.println(e);}
        if(cnt==0){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                Statement st=con.createStatement();
                String query="create table temp_student_login(rollno varchar(10) primary key,name varchar(20) not null,section varchar(5) not null,login varchar(25) unique,password varchar(25))";
                st.executeUpdate(query);
                }catch(Exception e){System.out.println(2);}
        }
        if(cnt==0){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                Statement st=con.createStatement();
                String query="create table temp_invidulator_login(id varchar(10) primary key,name varchar(20) not null,login varchar(25) unique,password varchar(25))";
                st.executeUpdate(query);
                }catch(Exception e){System.out.println(3);}
        }
        if(cnt==0){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                Statement st=con.createStatement();
                String query="create table student_login(rollno varchar(10) primary key,name varchar(20) not null,section varchar(5) not null,login varchar(25) unique,password varchar(25))";
                st.executeUpdate(query);
                }catch(Exception e){System.out.println(4);}
        }
        if(cnt==0){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                Statement st=con.createStatement();
                String query="create table invidulator_login(id varchar(10) primary key,name varchar(20) not null,login varchar(25) unique,password varchar(25))";
                st.executeUpdate(query);
                }catch(Exception e){System.out.println(5);}
        }
        if(cnt==0){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                Statement st=con.createStatement();
                String query="create table subjects(subjectid number(10) primary key,subjectname varchar(20) not null)";
                st.executeUpdate(query);
                }catch(Exception e){System.out.println(e);}
            }
            if(cnt==0){
                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                    Statement st=con.createStatement();
                    String query="create table schedule(scheduleid number(10) primary key,subjectid number(10) not null,examname varchar(40) not null,examdate date,enroldate date,foreign key(subjectid) references subjects(subjectid))";
                    st.executeUpdate(query);
                    }catch(Exception e){System.out.println(6);}
            }    
        if(cnt==0){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                Statement st=con.createStatement();
                String query="create table exam(examid number(10) primary key,scheduleid number(10) not null,studentid varchar(10) not null,foreign key(scheduleid) references schedule(scheduleid),foreign key(studentid) references student_login(rollno))";
                st.executeUpdate(query);
                }catch(Exception e){System.out.println(e);}
        }
        if(cnt==0){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                Statement st=con.createStatement();
                String query=" create table seat(seatno number(10) not null,studentid varchar(10),examid number(10))";
                st.executeUpdate(query);
                }catch(Exception e){System.out.println(e);}
        }
        if(cnt==0){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
                Statement st=con.createStatement();
                String query="create table seat(seatno number(10) not null,studentid varchar(10) not null,examid number(10) not null,invidulatorid varchar(10) not null,foreign key(seatno) references class(seatno),foreign key(studentid) references student_login(rollno),foreign key(examid) references exam(examid),foreign key(invidulatorid) references invidulator_login(id))";
                st.executeUpdate(query);
                }catch(Exception e){System.out.println(e);}
        }
        cnt++;
        lcIncrement();   
    }
    public String getUsername(){
        return this.username;
    }
    public boolean verify_username(String username){
        if(this.username.equals(username))
            return true;
        else
            return false;
    }
    public boolean verify_password(String password){
        if(this.pass.equals(password))
            return true;
        else
            return false;
    }
    public void lcIncrement(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "cvr123");
            Statement st=con.createStatement();
            String query="update admins"+" set count=count+1 where username=\'"+this.username+"\'";
            System.out.println(query);
            st.executeUpdate(query);
        }catch(Exception e){System.out.println(e);}
    }
    public void addTempStu(String name,String roll,String section,String username,String pass){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
            Statement st=con.createStatement();
            String query="insert into temp_student_login values(\'"+roll+"\',\'"+name+"\',\'"+section+"\',\'"+username+"\',\'"+pass+"\')";
            st.executeUpdate(query);

        }catch(Exception e){System.out.println(8);}
        certify_student();
    }
    public void addTempInv(String name,String roll,String username,String pass){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
            Statement st=con.createStatement();
            String query="insert into temp_invidulator_login values(\'"+roll+"\',\'"+name+"\',\'"+username+"\',\'"+pass+"\')";
            st.executeUpdate(query);          
        }catch(Exception e){System.out.println(9);}
        certify_invidulator();
    }
    private void certify_student(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
            Statement st=con.createStatement();
            String query="select * from temp_student_login";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                st=con.createStatement();
                query="select * from student_login";
                ResultSet rt=st.executeQuery(query);
                boolean b=true;
                while(rt.next()){
                    if((rs.getString(1).equals(rt.getString(1)))||(rs.getString(4).equals(rt.getString(4)))){
                        b=false;
                        break;
                    }
                }
                if(b==true){
                    st=con.createStatement();
                    query="insert into student_login values(\'"+rs.getString(1)+"\',\'"+rs.getString(2)+"\',\'"+rs.getString(3)+"\',\'"+rs.getString(4)+"\',\'"+rs.getString(5)+"\')";
                    st.executeUpdate(query);
                }
            }
        }catch(Exception e){System.out.println(10);}
    }
    private void certify_invidulator(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cvr123");
            Statement st=con.createStatement();
            String query="select * from temp_invidulator_login";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                st=con.createStatement();
                query="select * from invidulator_login";
                ResultSet rt=st.executeQuery(query);
                boolean b=true;
                while(rt.next()){
                    if((rs.getString(1).equals(rt.getString(1)))||(rs.getString(3).equals(rt.getString(3)))){
                        b=false;
                        break;
                    }
                }
                if(b==true){
                    st=con.createStatement();
                    query="insert into invidulator_login values(\'"+rs.getString(1)+"\',\'"+rs.getString(2)+"\',\'"+rs.getString(3)+"\',\'"+rs.getString(4)+"\')";
                    st.executeUpdate(query);
                }
            }
        }catch(Exception e){System.out.println(11);}
    }
    public void resetPass(String pass){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "cvr123");
            Statement st=con.createStatement();
            String query="update admins"+" set password=\'"+pass+"\' where username=\'"+this.username+"\'";
            System.out.println(query);
            st.executeUpdate(query);
        }catch(Exception e){System.out.println(e);}
    }
    public int adminCount(){
        return cnt;
    }
}
