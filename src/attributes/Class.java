package attributes;
public class Class{
    private int classnum;
    private String section ;
    private String floor;
    private Type type;

   
    
    
    public enum Type {
        aclab,
        acclass,
        nacclass,
        auditorium,
        recreational
    }

    public Class() {}

    public Class(int classnum, String section, String floor, Type type) {
        this.classnum = classnum;
        this.section = section;
        this.floor = floor;
        this.type = type;
    }

    public Class(String section, String floor, Type type) {
        this.section = section;
        this.floor = floor;
        this.type = type;
    }

    public int getclassnum() { return classnum; }
    public void setclassnum(int classnum) { this.classnum = classnum; }     
    public String getsection() { return section; }
    public void setsection(String section) { this.section = section; }
    public String getfloor() { return floor; }
    public void setfloor(String floor) { this.floor = floor; }
    public Type gettype() { return type; }
    public void settype(Type type) { this.type = type; }
    


}
