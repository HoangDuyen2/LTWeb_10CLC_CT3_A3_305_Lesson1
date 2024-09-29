package iostar.java.services.impl;

import iostar.java.daos.IUserDAO;
import iostar.java.daos.impl.UserDAO;
import iostar.java.models.Users;
import iostar.java.services.IUserServices;

public class UserServices implements IUserServices {
    IUserDAO userDAO = new UserDAO();
    @Override
    public boolean checkExistingUsername(String username) {
        return userDAO.checkExistingUsername(username);
    }

    @Override
    public boolean checkExistingPhone(String phone) {
        return userDAO.checkExistingPhone(phone);
    }

    @Override
    public boolean createUser(Users user) {
        if(!userDAO.checkExistingUsername(user.getUsername())&&!userDAO.checkExistingPhone(user.getPhone())){
            userDAO.createUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        if (!userDAO.checkExistingUsername(username)) {
            return false;
        }
        userDAO.updatePassword(username, newPassword);
        return true;
    }

    @Override
    public Users login(String username, String password) {
        return userDAO.login(username, password);
    }
}
