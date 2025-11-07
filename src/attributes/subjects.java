package attributes;
public class subjects {
    private int subjectid;
    private String subjectname;
    private int teacherid;

    public subjects() {}

    public subjects(int subjectid, String subjectname, int teacherid) {
        this.subjectid = subjectid;
        this.subjectname = subjectname;
        this.teacherid = teacherid;
    }
     public subjects( String subjectname, int teacherid) {
        this.subjectname = subjectname;
        this.teacherid = teacherid;
    }

    public int getsubjectid() { return subjectid; }
    public void setsubjectid(int subjectid) { this.subjectid = subjectid; }
    public String getsubjectname() { return subjectname; }
    public void setsubjectname(String subjectname) { this.subjectname = subjectname; }
    public int getteacherid() { return teacherid; }
    public void setteacherid(int teacherid) { this.teacherid = teacherid; }
    
}
