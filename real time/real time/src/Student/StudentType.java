package Student;
import Admin.AdminType;

public class StudentType {
    private String name,rollno,pass,section,login;
    private String username;
    private String subjects[];
    private int subjects_no;
    private String examination_hall_no;
    StudentType(String name,String rollno,String section){
        this.name=name;
        this.rollno=rollno;
        this.section=section;
    }
    public boolean createLogin(String username,String pass,String re_enter_pass){
        if(pass.equals(re_enter_pass)){
            this.login=username;
            this.pass=pass;
            return true;
        }
        return false;
    }
    public boolean enroll(String [] subjects){
        if(subjects.length!=0){
            this.subjects=subjects;
            this.subjects_no=subjects.length;
            return true;
        }
        return false;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setRoll(String roll){
        this.rollno=roll;
    }
    public String getRoll(){
        return this.rollno;
    }
    public void setSection(String section){
        this.section=section;
    }
    public String getSection(){
        return this.section;
    }
    public void setusername(String username){
        this.username=username;
    }
    public String getusername(){
        return this.username;
    }
    public void setpassword(String pass){
        this.pass=pass;
    }
    public String getpassword(String AdminPass){
        if(new AdminType().verify_password(AdminPass)==true){
            return this.pass;
        }
        else
            return "Password secured";
    }
}
