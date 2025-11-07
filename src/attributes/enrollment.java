package attributes;
public class enrollment {
    private int student_id;
    private int subjectid;

    public enrollment(){};

    public enrollment(int student_id, int subjectid) {
        this.student_id = student_id;
        this.subjectid = subjectid;
    }

    public int getstudent_id(){return student_id;}
    public void setstudent_id(int student_id){this.student_id = student_id;}
    public int getsubjectid(){return subjectid;}
    public void setsubjectid(int subjectid){this.subjectid = subjectid;}
}
