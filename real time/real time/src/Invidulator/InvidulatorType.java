package Invidulator;

public class InvidulatorType {
    private String name,rollno,pass,login;
    private String username;
    private String subjects[];
    private int subjects_no;
    InvidulatorType(String name,String rollno){
        this.name=name;
        this.rollno=rollno;
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
            subjects_no=subjects.length;
            return true;
        }
        return false;
    }
}