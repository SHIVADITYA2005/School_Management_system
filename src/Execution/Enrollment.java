package Execution;

import java.util.*;
import attributes.enrollment;
import java.sql.*;
import connection.Connect;

public class Enrollment {
    private Connection conn;

    public Enrollment(){
        try{
            conn = Connect.getConnection();
        } catch(Exception a){
            a.printStackTrace();
        }
    }

    public void addenroll(enrollment enrollee){
         String sql = "INSERT INTO enrollment (student_id, subjectid) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, enrollee.getstudent_id());
            ps.setInt(2, enrollee.getsubjectid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public enrollment getenrollId(int enrolee){
        enrollment enroll = null;
    String sql = "SELECT * FROM enrollment WHERE student_id = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, enrolee);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            enroll = new enrollment();
            enroll.setstudent_id(rs.getInt("student_id"));
            enroll.setsubjectid(rs.getInt("subjectid"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return enroll;
       }


    public List<enrollment> geteveryone(){
         List<enrollment> list = new ArrayList<>();
        String sql = "SELECT * FROM enrollment";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                enrollment e = new enrollment();
                e.setstudent_id(rs.getInt("student_id"));
                e.setsubjectid(rs.getInt("subjectid"));
                list.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }



    public void updateenrolle(enrollment enrollee){
        String sql = "UPDATE enrollment SET subjectid = ? WHERE student_id = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, enrollee.getsubjectid());
        ps.setInt(2, enrollee.getstudent_id());
        int rowsUpdated = ps.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Enrollment updated successfully.");
        } else {
            System.out.println("No enrollment found for the given student_id.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }


    public void deletestud(int student_id, int subjectid){
         String sql = "DELETE FROM enrollment WHERE student_id = ? AND subjectid = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, student_id);
            ps.setInt(2, subjectid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }   
