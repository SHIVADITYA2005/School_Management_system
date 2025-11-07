package Execution;

import java.util.*;
import attributes.Attendance;
import java.sql.*;
import connection.Connect;
import java.sql.Date;


public class attendance{
    private Connection conn;

    public attendance(){
        try{
            conn = Connect.getConnection();
        } catch(Exception a){
            a.printStackTrace();
        }
    }

    
    public List<Attendance> listall(){
        String sql = "SELECT * FROM Attendance";
        List<Attendance> list = new ArrayList<>();
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
        while(rs.next()){
            list.add(extractAttendsFromResultSet(rs));
        }}catch(SQLException a){
            a.printStackTrace();
        }
        return list;
        }
    
        public void deleteatt(int student_id){
        String sql = "DELETE FROM Attendance WHERE student_id = ? ";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,student_id);
            ps.executeUpdate();
            System.out.println("Deleted");
        }catch(SQLException a){
            a.printStackTrace();
        }

    }   
    public void addAttendance(Attendance att){
        String sql = "INSERT INTO Attendance (subjectid,student_id,date,sessionid,status)"
                    + "VALUES(?,?,?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,att.getsubjectid());
            ps.setInt(2,att.getstudent_id());
            ps.setDate(3,Date.valueOf(att.getDate()));
            ps.setInt(4,att.getsessionid());
            ps.setString(5,att.getstatus().name());
            ps.executeUpdate();
        }catch(SQLException a){
            a.printStackTrace();
        }
    }

    private Attendance extractAttendsFromResultSet(ResultSet rs) throws SQLException{
        Attendance attend = new Attendance();
        attend.setsubjectid(rs.getInt("subjectid"));
        attend.setstudent_id(rs.getInt("student_id"));
        attend.setDate(rs.getDate("date").toLocalDate());
        attend.setsessionid(rs.getInt("sessionid"));
        attend.setstatus(Attendance.Status.valueOf(rs.getString("status")));
        return attend;
        }

    
}