package iostar.java.daos.impl;

import iostar.java.configs.DBConnectionMySQL;
import iostar.java.daos.IUserDAO;
import iostar.java.models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO extends DBConnectionMySQL implements IUserDAO {
    public Connection connection ;
    public PreparedStatement ps;
    @Override
    public boolean checkExistingUsername(String username) {
        String sql = "select * from users where username = ?";
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistingPhone(String phone) {
        String sql = "select * from users where phone = ?";
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void createUser(Users user) {
        String sql = "INSERT INTO users(fullname, address, username, password, images, rode_id, createdate, phone) VALUES(?,?,?,?,?,?,?,?)";
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getAddress());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getImages());
            ps.setInt(6,user.getRole_id());
            ps.setString(7, String.valueOf(user.getCreateDate()));
            ps.setString(8, user.getPhone());

            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        String sql = "update users set password = ? where username = ?";
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, username);

            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users login(String username, String password) {
        String sql = "select * from users where username = ? and password = ?";
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setFullName(rs.getString("fullname"));
                user.setAddress(rs.getString("address"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setImages(rs.getString("images"));
                user.setRole_id(rs.getInt("rode_id"));
                user.setPhone(rs.getString("phone"));

                return user;
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
