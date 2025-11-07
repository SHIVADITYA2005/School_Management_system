package Execution;

import java.util.*;
import attributes.subjects;
import java.sql.*;
import connection.Connect;

public class Subjects{
    private Connection conn;

    public Subjects(){
        try{
            conn = Connect.getConnection();
        } catch(Exception a){
            a.printStackTrace();
        }
    }

    public void addsubject(subjects subject){
        String sql = "INSERT INTO subjects (subjectid,subjectname,teacherid)"
                    +"VALUES(?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,subject.getsubjectid());
            ps.setString(2,subject.getsubjectname());
            ps.setInt(3,subject.getteacherid());
            ps.executeUpdate();
        }catch(SQLException a){
            a.printStackTrace();
        }
        }
    
    public subjects getsubjectId(int subjectid){
        String sql = "SELECT * FROM subjects WHERE subjectid = ?";
        subjects sub = null;
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,subjectid);
            ResultSet rs = ps.executeQuery();
          if(rs.next()){
                sub = extractSubjectsFromResultSet(rs);
          }}catch(SQLException a){
            a.printStackTrace();
          }
          return sub;
    }
    
    
    public List<subjects> geteveryone(){
        List<subjects> list = new ArrayList<>();
        String sql = "SELECT * FROM subjects";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
        while(rs.next()){
            list.add(extractSubjectsFromResultSet(rs));
        }}catch(SQLException a){
        a.printStackTrace();
        }
        return list;
    }
    
    
    public void updatesubject(subjects subject){
        String sql = "UPDATE subjects SET subjectname=?, teacherid=? WHERE subjectid=?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,subject.getsubjectid());
            ps.setString(2,subject.getsubjectname());
            ps.setInt(3,subject.getteacherid());
            ps.executeUpdate();
            System.out.println("Query Executed");
            }catch(SQLException a){
                a.printStackTrace();
            }
    }
    
    
    public void deletesubject(int subjectid){
        String sql = "DELETE FROM subjects WHERE subjectid = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,subjectid);
            ps.executeUpdate();
        }catch(SQLException a){
            a.printStackTrace();
        }
    }   

    private subjects extractSubjectsFromResultSet(ResultSet rs) throws SQLException{
        subjects sub = new subjects();
        sub.setsubjectid(rs.getInt("subjectid"));
        sub.setsubjectname(rs.getString("subjectname"));
        sub.setteacherid(rs.getInt("teacherid"));
        return sub;
    }
}