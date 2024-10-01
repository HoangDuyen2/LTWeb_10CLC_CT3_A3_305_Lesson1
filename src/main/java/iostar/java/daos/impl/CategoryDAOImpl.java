package iostar.java.daos.impl;

import iostar.java.configs.DBConnectionMySQL;
import iostar.java.daos.ICategoryDAO;
import iostar.java.models.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl extends DBConnectionMySQL implements ICategoryDAO {
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;
    @Override
    public List<CategoryModel> findAll() {
        String sql = "select * from categories";
        List<CategoryModel> list = new ArrayList<CategoryModel>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while(rs.next()){
                CategoryModel cm = new CategoryModel();
                cm.setCategoryid(rs.getInt("categoryid"));
                cm.setCategoryname(rs.getString("categoryname"));
                cm.setImages(rs.getString("images"));
                cm.setStatus(rs.getInt("status"));
                list.add(cm);
            }
            rs.close();
            ps.close();
            conn.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CategoryModel findById(int id) {
        String sql = "select * from categories where categoryid = ?";
        CategoryModel cm = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                cm = new CategoryModel();
                cm.setCategoryid(rs.getInt("categoryid"));
                cm.setCategoryname(rs.getString("categoryname"));
                cm.setImages(rs.getString("images"));
                cm.setStatus(rs.getInt("status"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cm;
    }

    @Override
    public CategoryModel findByCategoryName(String categoryName) {
        String sql = "select * from categories where categoryname = ?";
        CategoryModel cm = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, categoryName);
            rs = ps.executeQuery();
            while(rs.next()){
                cm = new CategoryModel();
                cm.setCategoryid(rs.getInt("categoryid"));
                cm.setCategoryname(rs.getString("categoryname"));
                cm.setImages(rs.getString("images"));
                cm.setStatus(rs.getInt("status"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cm;
    }

    @Override
    public List<CategoryModel> findByCategoryNameContaining(String keyword) {
        String sql = "select * from categories where categoryname like ?";
        List<CategoryModel> list = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                CategoryModel cm = new CategoryModel();
                cm.setCategoryid(rs.getInt("categoryid"));
                cm.setCategoryname(rs.getString("categoryname"));
                cm.setImages(rs.getString("images"));
                cm.setStatus(rs.getInt("status"));
                list.add(cm);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(CategoryModel category) {
        String sql = "insert into categories (categoryname, images, status) values (?,?,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CategoryModel category) {
        String sql = "update categories set categoryname = ?, images = ?, status = ? where categoryid = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());
            ps.setInt(4, category.getCategoryid());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int categoryid) {
        String sql = "delete from categories where categoryid = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, categoryid);

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(int categoryid, int status) {
        String sql = "update categories set status = ? where categoryid = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, status);
            ps.setInt(2, categoryid);

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
