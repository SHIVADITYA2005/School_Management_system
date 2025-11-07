package attributes;
import java.time.LocalDate;
public class teachers {
    private int teacherid;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String subject;
    private LocalDate jndt;
    private float salary;
    
    private Gender gender;
    public enum Gender {
        Male,
        Female,
        Other
    }

    private Status status;
    public enum Status {
        Active,
        Inactive
    }

    public teachers() {}

    public teachers(int teacherid, String firstname, String lastname, String email, String phone,
                    String subject, LocalDate jndt, float salary, Gender gender, Status status) {
        this.teacherid = teacherid; 
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
        this.jndt = jndt;
        this.salary = salary;
        this.gender = gender;
        this.status = status;
        }      

        public teachers(String firstname, String lastname, String email, String phone,
                    String subject, LocalDate jndt, float salary, Gender gender, Status status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
        this.jndt = jndt;
        this.salary = salary;
        this.gender = gender;
        this.status = status;
        }    

    public int getteacherid() { return teacherid; }
    public void setteacherid(int teacherid) { this.teacherid = teacherid; }
    public String getfirstname() { return firstname; }
    public void setfirstname(String firstname) { this.firstname = firstname; }
    public String getlastname() { return lastname; }
    public void setlastname(String lastname) { this.lastname = lastname; }
    public String getemail() { return email; }
    public void setemail(String email) { this.email = email; }
    public String getphone() { return phone; }
    public void setphone(String phone) { this.phone = phone; }
    public String getsubject() { return subject; }
    public void setsubject(String subject) { this.subject = subject; }
    public LocalDate getjndt() { return jndt; }
    public void setjndt(LocalDate jndt) { this.jndt = jndt; }
    public float getsalary() { return salary; }
    public void setsalary(float salary) { this.salary = salary; }
    public Gender getgender() { return gender; }
    public void setgender(Gender gender) { this .gender = gender; }
    public Status getstatus() { return status; }    
    public void setstatus(Status status) { this.status = status; }
}
