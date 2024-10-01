package iostar.java.daos;

import iostar.java.models.UserModel;

public interface IUserDAO {
    public boolean checkExistingUsername(String username);
    public boolean checkExistingPhone(String phone);
    public void createUser(UserModel user);
    public void updatePassword(String username, String newPassword);
    public UserModel login(String username, String password);
}
