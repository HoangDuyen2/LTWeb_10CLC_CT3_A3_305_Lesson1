//package iostar.java.configs;
//
//import iostar.java.daos.IUserDAO;
//import iostar.java.daos.iml.UserDAOIml;
//import iostar.java.models.UserModel;
//import iostar.java.services.IUserService;
//import iostar.java.services.impl.UserServiceImpl;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class DBConnectionSQLServer {
//    private static final String serverName = "DESKTOP-THQTAL8";
//    private static final String dbName = "Demo01";
//    private static final String portNumber = "1433";
//    private static final String userID = "sa";
//    private static final String password = "123";
//
//    public static Connection getConnection() throws Exception {
//        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return DriverManager.getConnection(url, userID, password);
//    }
//    // Test chương trình. Kích phải chuột chọn run as->java application
//    public static void main(String[] args) {
//        try {
//            new DBConnectionSQLServer();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
