package iostar.java.controller;

import iostar.java.models.UserModel;
import iostar.java.services.IUserService;
import iostar.java.services.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/reset_password")
public class ResetPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String alertMsg = "";
        if(username.equals("") || password.equals("") || confirmPassword.equals("")) {
            alertMsg = "Không được để rỗng các trường";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
            return;
        }
        if(!password.equals(confirmPassword)) {
            alertMsg = "Mật khẩu và mật khẩu xác nhận không trùng khớp";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
            return;
        }
        IUserService iUserService = new UserServiceImpl();
        boolean isSuccess = iUserService.checkRegister(username,password,"","","","Forgot");
        if(isSuccess) {
            req.setAttribute("alert", alertMsg);
            System.out.println(req.getContextPath());
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            alertMsg = "System error!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
        }
    }
}
