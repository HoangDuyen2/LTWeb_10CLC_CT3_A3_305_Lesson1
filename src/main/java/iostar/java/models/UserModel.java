package iostar.java.models;

import java.sql.Date;

public class UserModel implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
//    Khai báo biến(là các trương trong user
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String phone;
    private String images;
    private int roleid;
    private Date createdate;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

//    Tạo constructors
    public UserModel() {
        super();
    }
    public UserModel(String username, String password, String fullname, String phone, String images, Date createDate, int roleid) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.images = images;
        this.createdate = createDate;
        this.roleid = roleid;
    }
//    Tạo getter và setter
public String getPassword() {
    return password;
}

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//    Override 1 số hàm sẵn

    @Override
    public String toString() {
        return "UserModel [id=" + id + ", username=" + username + ", password=" + password +" phone="+phone+", images="+images+"]";
    }
}
