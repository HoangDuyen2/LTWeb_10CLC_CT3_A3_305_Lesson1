package iostar.java.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnectionMySQL {
    private static String USERNAME = "root";
    private static String PASSWORD = "1234";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/users";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
//Test chương trình. Kích phải chuột chọn run as->java application
    public static void main(String[] args) {
        try {
            new DBConnectionMySQL();
            System.out.println(DBConnectionMySQL.getConnection());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
