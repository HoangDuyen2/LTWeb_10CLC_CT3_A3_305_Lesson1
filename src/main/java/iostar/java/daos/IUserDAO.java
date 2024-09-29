package iostar.java.daos;

import iostar.java.models.Users;

public interface IUserDAO {
    public boolean checkExistingUsername(String username);
    public boolean checkExistingPhone(String phone);
    public void createUser(Users user);
    public void updatePassword(String username, String newPassword);
    public Users login(String username, String password);
}
