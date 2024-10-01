package iostar.java.services.impl;

import iostar.java.daos.IUserDAO;
import iostar.java.daos.impl.UserDAOImpl;
import iostar.java.models.UserModel;
import iostar.java.services.IUserServices;

public class UserServices implements IUserServices {
    IUserDAO userDAO = new UserDAOImpl();
    @Override
    public boolean checkExistingUsername(String username) {
        return userDAO.checkExistingUsername(username);
    }

    @Override
    public boolean checkExistingPhone(String phone) {
        return userDAO.checkExistingPhone(phone);
    }

    @Override
    public boolean createUser(UserModel user) {
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
    public UserModel login(String username, String password) {
        return userDAO.login(username, password);
    }
}
