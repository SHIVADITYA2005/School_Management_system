package attributes;
import java.time.LocalDate;


public class Attendance {
    private int student_id;
    private int subjectid;
    private LocalDate date;
    private int sessionid;
    private Status status;

    public enum Status{
        Present,
        Absent
    }

    public Attendance(){};

    public Attendance(int student_id, int subjectid, LocalDate date, int sessionid, Status status) {
        this.student_id = student_id;
        this.subjectid = subjectid;
        this.date = date;
        this.sessionid = sessionid;
        this.status = status;
    }

    public int getstudent_id(){return student_id;}
    public void setstudent_id(int student_id){this.student_id = student_id;}    

    public int getsubjectid(){return subjectid;}
    public void setsubjectid(int subjectid){this.subjectid = subjectid;}

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public int getsessionid(){return sessionid;}
    public void setsessionid(int sessionid){this.sessionid = sessionid;}

    public Status getstatus(){return status;}
    public void setstatus(Status status){this.status = status;}
}
