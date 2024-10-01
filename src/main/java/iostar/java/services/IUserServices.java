package iostar.java.services;

import iostar.java.models.UserModel;

public interface IUserServices {
    public boolean checkExistingUsername(String username);
    public boolean checkExistingPhone(String phone);
    public boolean createUser(UserModel user);
    public boolean updatePassword(String username, String newPassword);
    public UserModel login(String username, String password);
}
