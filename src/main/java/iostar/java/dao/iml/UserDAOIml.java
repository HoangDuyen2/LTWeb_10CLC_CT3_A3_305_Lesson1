package iostar.java.dao.iml;

import iostar.java.configs.DBConnectionSQLServer;
import iostar.java.dao.IUserDAO;
import iostar.java.models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOIml implements IUserDAO {
    @Override
    public UserModel findByUsername(String username) {
        String sql = "select * from users where username = ?";
        try{
            new DBConnectionSQLServer();
            Connection conn = DBConnectionSQLServer.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
//            STT tham số đi từ 1
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setPhone(rs.getString("phone"));
                user.setId(rs.getInt("id"));
                user.setImages(rs.getString("images"));
                user.setRoleid(rs.getInt("roleid"));
                user.setCreatedate(rs.getDate("createdate"));
                return user;
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertUser(UserModel user) {
        String sql = "INSERT INTO Users(username, password, fullname, images, roleid, createdate, phone) VALUES (?,?,?,?,?,?,?)";
        try {
            Connection conn = new DBConnectionSQLServer().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getImages());
            ps.setInt(5,user.getRoleid());
            ps.setDate(6, user.getCreatedate());
            ps.setString(7,user.getPhone());
            ps.executeUpdate();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public boolean checkExistUserName(String userName) {
        boolean check = false;
        String query = "select * from [Users] where username = ?";
        try {
            Connection conn = new DBConnectionSQLServer().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs;
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        boolean check = false;
        String query = "select * from [Users] where phone = ?";
        try {
            Connection conn = new DBConnectionSQLServer().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs;
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }
}
