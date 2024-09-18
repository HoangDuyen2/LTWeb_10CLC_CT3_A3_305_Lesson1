package iostar.java.dao;

import iostar.java.models.UserModel;

public interface IUserDAO {
//    Khai báo các hàm và thủ tục
//    Kiểm tra thông tin có trong csdl không và trả về user đó
    UserModel findByUsername(String username);
    void insertUser(UserModel user);
    void updateUser(UserModel user);
    boolean checkExistUserName(String userName);
    boolean checkExistPhone(String phone);
}
