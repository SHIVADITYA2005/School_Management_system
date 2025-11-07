package Execution;

import java.util.*;
import attributes.teachers;
import java.sql.*;
import connection.Connect;
import java.sql.Date;

public class Teachers{
    private Connection conn;

    public Teachers(){
        try{
            conn = Connect.getConnection();
        } catch(Exception a){
            a.printStackTrace();
        }
    }

    public void addteacher(teachers teacher){
        String sql = "INSERT INTO teachers (firstname,lastname,email,phone,subject,jndt,salary,gender,status)"
                + "VALUES(?,?,?,?,?,?,?,?,?)";
                
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, teacher.getfirstname());
            ps.setString(2, teacher.getlastname());
            ps.setString(3, teacher.getemail());
            ps.setString(4, teacher.getphone());
            ps.setString(5, teacher.getsubject());
            ps.setDate(6, Date.valueOf(teacher.getjndt()));  
            ps.setFloat(7, teacher.getsalary());
            ps.setString(8, teacher.getgender().name());     
            ps.setString(9, teacher.getstatus().name());
            ps.executeUpdate();
        }catch(SQLException a){
            a.printStackTrace();
        }
    }
    public teachers getteacherId(int teacherid){
        String sql = "SELECT * FROM teachers WHERE teacherid = ?";
         teachers teacher = null;
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,teacherid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                teacher  = extractTeachersFromResultSet(rs);
            }
        }
        catch (SQLException a){
                a.printStackTrace();
        }
        return teacher;

    }
    public List<teachers> geteveryone(){
        List<teachers> list = new ArrayList<>();
        String sql = "SELECT * FROM teachers";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(extractTeachersFromResultSet(rs));

            }}catch(SQLException a){
                a.printStackTrace();
        }
        return list;
    }
    public void updateteacher(teachers teacher){
        String sql = "UPDATE teachers SET firstname = ?, lastname = ?,email = ?, phone = ?, subject = ?, jndt = ?, salary = ?, gender = ?, status = ? WHERE teacherid = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, teacher.getfirstname());
            ps.setString(2, teacher.getlastname());
            ps.setString(3, teacher.getemail());
            ps.setString(4, teacher.getphone());
            ps.setString(5, teacher.getsubject());
            ps.setDate(6, Date.valueOf(teacher.getjndt()));  
            ps.setFloat(7, teacher.getsalary());
            ps.setString(8, teacher.getgender().name());     
            ps.setString(9, teacher.getstatus().name());
            ps.setInt(10, teacher.getteacherid());
            ps.executeUpdate();
            System.out.println("Teacher with ID " + teacher.getteacherid() + " has been updated.");
        } catch(SQLException a){
            a.printStackTrace();}
    }
    public void deleteteacher(int teacherid){
        String sql = "DELETE FROM teachers WHERE teacherid = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,teacherid);
            ps.executeUpdate();
            System.out.println("Teacher with ID " + teacherid + " has been deleted.");
        }catch (SQLException a){
            a.printStackTrace();
            }   
        }

        private teachers extractTeachersFromResultSet(ResultSet rs) throws SQLException{
            teachers teacher = new teachers();
            teacher.setteacherid(rs.getInt("teacherid"));
            teacher.setfirstname(rs.getString("firstname"));
            teacher.setlastname(rs.getString("lastname"));
            teacher.setemail(rs.getString("email"));
            teacher.setphone(rs.getString("phone"));
            teacher.setsubject(rs.getString("subject"));
            teacher.setjndt(rs.getDate("jndt").toLocalDate());
            teacher.setsalary(rs.getFloat("salary"));
            teacher.setgender(teachers.Gender.valueOf(rs.getString("gender")));
            teacher.setstatus(teachers.Status.valueOf(rs.getString("status")));
            return teacher;


        }
}