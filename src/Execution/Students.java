package Execution;

import java.util.*;
import attributes.students;
import java.sql.*;
import connection.Connect;
import java.sql.Date;

public class Students{
    private Connection conn;

    public Students(){
        try{
            conn = Connect.getConnection();
        } catch(Exception a){
            a.printStackTrace();
        }
    }

    public void addstudent(students student){
        String sql = "INSERT INTO students (student_id,first_name,last_name,date_of_birth,email,phone,address,admission_date,status)"
                      + "VALUES(?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, student.getstudent_id());
            ps.setString(2, student.getfirst_name());
            ps.setString(3, student.getlast_name());
            ps.setDate(4, Date.valueOf(student.getdate_of_birth()));
            ps.setString(5, student.getemail());
            ps.setString(6, student.getphone());
            ps.setString(7, student.getaddress());
            ps.setDate(8, Date.valueOf(student.getadmission_Date()));
            ps.setString(9, student.getstatus().name());
            ps.executeUpdate();
        }
        catch(SQLException a){
            a.printStackTrace();
        }
    }




    public students getstudentId(int student_id){
        String sql ="SELECT * FROM students WHERE student_id = ?";
        students student = null;
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, student_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){//rs.next() checks if the next row exists and moves the cursor to it
                student = extractStudentsFromResultSet(rs);
            }}
        catch(SQLException a){
            a.printStackTrace();
        }
        return student;
    }



    public List<students> geteveryone(){
        List<students> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                students student = extractStudentsFromResultSet(rs);
                list.add(student);
            }   
        }catch(SQLException a){
            a.printStackTrace();
        }
        return list;
    }
    public void updatestudent(students student){
        String sql = "UPDATE students SET first_name = ?, last_name = ?, date_of_birth = ?, email = ?, phone = ?, address = ?, admission_date = ?, status = ? WHERE student_id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, student.getfirst_name());
            ps.setString(2, student.getlast_name());
            ps.setDate(3, Date.valueOf(student.getdate_of_birth()));
            ps.setString(4, student.getemail());
            ps.setString(5, student.getphone());
            ps.setString(6, student.getaddress());
            ps.setDate(7, Date.valueOf(student.getadmission_Date()));
            ps.setString(8, student.getstatus().name());
            ps.setInt(9, student.getstudent_id());
            ps.executeUpdate();
        }catch(SQLException a){
            a.printStackTrace();
        }
    }
    public void deletestudent(int student_id){
        String sql = "DELETE FROM students WHERE student_id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, student_id);
            ps.executeUpdate();
        }catch(SQLException a){
            a.printStackTrace();
        }
    }   
    private students extractStudentsFromResultSet(ResultSet rs) throws SQLException{
        int student_id = rs.getInt("student_id");
        String first_name = rs.getString("first_name");
        String last_name = rs.getString("last_name");
        Date dob = rs.getDate("date_of_birth");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String address = rs.getString("address");
        Date admission_date = rs.getDate("admission_date");
        String statusStr = rs.getString("status");
        students.Status status = students.Status.valueOf(statusStr);

        return new students(student_id, first_name, last_name, dob.toLocalDate(), email, phone, address, admission_date.toLocalDate(), status);
    }
}