package iostar.java.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionMySQL {
    public static String url = "jdbc:mysql://localhost:3306/ltweb01";
    public static String user = "root";
    public static String password = "1234";
    public static String driver = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        try {
            new DBConnectionMySQL();
            System.out.println(getConnection());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
