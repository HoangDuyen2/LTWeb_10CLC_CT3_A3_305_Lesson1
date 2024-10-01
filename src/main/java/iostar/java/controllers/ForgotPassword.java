package iostar.java.controllers;

import iostar.java.models.UserModel;
import iostar.java.services.IUserServices;
import iostar.java.services.impl.UserServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/forgot-password")
public class ForgotPassword extends HttpServlet {
    IUserServices userServices = new UserServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/forgot.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("password-repeat");

        String alertMsg = "";
        if(username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            alertMsg = "Username and password cannot be empty";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
        }
        if(!password.equals(confirmPassword)) {
            alertMsg = "Passwords do not match";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
        }
        if (!userServices.checkExistingUsername(username)) {
            alertMsg = "Username does not exist";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
        }

        UserModel users = new UserModel();
        users.setUsername(username);
        users.setPassword(password);

        if(userServices.updatePassword(username,password)){
            alertMsg = "Password updated successfully";
            req.setAttribute("alertMsg", alertMsg);
            resp.sendRedirect(req.getContextPath()+"/login");
        }
        else{
            alertMsg = "Username or password is incorrect";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
        }
    }
}
