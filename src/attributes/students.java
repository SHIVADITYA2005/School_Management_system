package attributes;
import java.time.LocalDate;

public class students {

    private int student_id;
    private String first_name;
    private String last_name;
    private LocalDate date_of_birth;
    private String email;
    private String phone;
    private String address;
    private LocalDate admission_Date;
    private Status status;

    // Enum for status
    public enum Status {
        Active,
        Inactive
    }

    // Default constructor
    public students() {}

    // Constructor without student_id (for inserting new students)
    public students(String first_name, String last_name, LocalDate date_of_birth, String email,
                    String phone, String address, LocalDate admission_Date, Status status) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.admission_Date = admission_Date;
        this.status = status;
    }

    // Constructor with student_id (for reading from DB)
    public students(int student_id, String first_name, String last_name, LocalDate date_of_birth, String email,
                    String phone, String address, LocalDate admission_Date, Status status) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.admission_Date = admission_Date;
        this.status = status;
    }

    // Getters and Setters
    public int getstudent_id() { return student_id; }
    public void setstudent_id(int student_id) { this.student_id = student_id; }

    public String getfirst_name() { return first_name; }
    public void setfirst_name(String first_name) { this.first_name = first_name; }

    public String getlast_name() { return last_name; }
    public void setlast_name(String last_name) { this.last_name = last_name; }

    public LocalDate getdate_of_birth() { return date_of_birth; }
    public void setdate_of_birth(LocalDate date_of_birth) { this.date_of_birth = date_of_birth; }

    public String getemail() { return email; }
    public void setemail(String email) { this.email = email; }

    public String getphone() { return phone; }
    public void setphone(String phone) { this.phone = phone; }

    public String getaddress() { return address; }
    public void setaddress(String address) { this.address = address; }

    public LocalDate getadmission_Date() { return admission_Date; }
    public void setadmission_Date(LocalDate admission_Date) { this.admission_Date = admission_Date; }

    public Status getstatus() { return status; }
    public void setstatus(Status status) { this.status = status; }


    @Override
    public String toString() {
        return "students{" +
                "student_id=" + student_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", admission_Date=" + admission_Date +
                ", status=" + status +
                '}';
    }
}

