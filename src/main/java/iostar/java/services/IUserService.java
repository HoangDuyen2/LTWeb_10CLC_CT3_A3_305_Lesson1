package iostar.java.services;

import iostar.java.models.UserModel;

public interface IUserService {
    UserModel findByUserName(String userName);
    UserModel login(String userName, String password);
    UserModel register(UserModel userModel);
    void insertUser(UserModel userModel);
    void updateUser(UserModel userModel);
    boolean checkRegister(String userName, String password, String phone, String fullname, String image, String method);
    boolean checkExistUserName(String userName);
    boolean checkExistPhone(String phone);
}
