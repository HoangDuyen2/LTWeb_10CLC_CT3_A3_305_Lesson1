package iostar.java.models;

import java.util.Date;

public class UserModel {
    private int user_id;
    private String fullName;
    private String address;

    public UserModel(){}
    public UserModel(String phone, Date createDate, int role_id,
                     String images, String password, String username,
                     String address, String fullName) {
        this.phone = phone;
        this.createDate = createDate;
        this.role_id = role_id;
        this.images = images;
        this.password = password;
        this.username = username;
        this.address = address;
        this.fullName = fullName;
    }

    private String username;
    private String password;
    private String images;
    private int role_id;
    private Date createDate;
    private String phone;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
