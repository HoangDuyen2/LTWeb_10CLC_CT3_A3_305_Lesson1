package iostar.java.services;

import iostar.java.models.Users;

public interface IUserServices {
    public boolean checkExistingUsername(String username);
    public boolean checkExistingPhone(String phone);
    public boolean createUser(Users user);
    public boolean updatePassword(String username, String newPassword);
    public Users login(String username,String password);
}
