package iostar.java.services.impl;

import iostar.java.dao.IUserDAO;
import iostar.java.dao.iml.UserDAOIml;
import iostar.java.models.UserModel;
import iostar.java.services.IUserService;

public class UserServiceImpl implements IUserService {
    IUserDAO userDAO = new UserDAOIml();
    @Override
    public UserModel findByUserName(String userName) {
        return userDAO.findByUsername(userName);
    }

    @Override
    public UserModel login(String userName, String password) {
        UserModel user = this.findByUserName(userName);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public UserModel register(UserModel userModel) {
        UserModel user = this.findByUserName(userModel.getUsername());
        if (user == null) {
            return userModel;
        }
        return null;
    }

    @Override
    public void insertUser(UserModel userModel) {
        userDAO.insertUser(userModel);
    }

    @Override
    public boolean checkRegister(String userName, String password, String phone, String fullname, String image) {
        if (userDAO.checkExistUserName(userName)) {
            return false;
        }
        java.sql.Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
        userDAO.insertUser(new UserModel(userName,password, fullname, phone,image,date,3));
        return true;
    }

    @Override
    public boolean checkExistUserName(String userName) {
        return userDAO.checkExistUserName(userName);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDAO.checkExistPhone(phone);
    }
}
