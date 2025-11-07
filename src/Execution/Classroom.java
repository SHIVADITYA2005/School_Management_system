package Execution;

import java.util.*;
import attributes.Class;
import java.sql.*;
import connection.Connect;

public class Classroom{
    private Connection conn;

    public Classroom(){
        try{
            conn = Connect.getConnection();
        } catch(Exception a){
            a.printStackTrace();
        }
    }

    public void addclass(Class classr){
        String sql = "INSERT INTO Class (section,floor,type,classnum)"
                    + "VALUES(?,?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,classr.getsection());
            ps.setString(2,classr.getfloor());
            ps.setString(3,classr.gettype().name());
            ps.setInt(4,classr.getclassnum());
            ps.executeUpdate();
        }catch(SQLException a){
            a.printStackTrace();
        }
    }
    public Class getclassId(int classnum){
        String sql = "SELECT * FROM Class WHERE classnum = ?";
        Class classr = null;
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,classnum);
            ResultSet rs = ps.executeQuery();
          if(rs.next()){
                classr = extractClassFromResultSet(rs);
          }}catch(SQLException a){
            a.printStackTrace();
          }
          return classr;
    }
    public List<Class> geteveryone(){
        List<Class> list = new ArrayList<>();
        String sql = "SELECT * FROM Class";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
        while(rs.next()){
            list.add(extractClassFromResultSet(rs));
        }}catch(SQLException a){
        a.printStackTrace();}
        return list;
    }
    public void deleteclass(int classnum){
        String sql = "DELETE * FROM Class WHERE classnum = ? ";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,classnum);
            ps.executeUpdate();
            System.out.println("Deleted");
        }catch(SQLException a){
            a.printStackTrace();
        }
    }   
    private Class extractClassFromResultSet(ResultSet rs) throws SQLException{
        Class classr = new Class();
        classr.setclassnum(rs.getInt("classnum"));
        classr.setsection(rs.getString("section"));
        classr.setfloor(rs.getString("floor"));
        classr.settype(Class.Type.valueOf(rs.getString("type")));
        return classr;
    }
}