package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect{

    private static final String URL = "jdbc:mysql://localhost:3306/my_school_server"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "Shivaditya@29"; 

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected");
        } catch (ClassNotFoundException a) {
            System.out.println(" JDBC Driver not found. Make sure MySQL connector JAR is added.");
            a.printStackTrace();
        } catch (SQLException a) {
            System.out.println("Database connection failed");
            a.printStackTrace();
        }
        return conn;
    }
}
