package iostar.java.controllers;

import iostar.java.models.Users;
import iostar.java.services.IUserServices;
import iostar.java.services.impl.UserServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    IUserServices userServices = new UserServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        lấy đối tượng HttpSession của người dùng hiện tại. Tham số false chỉ định rằng nếu phiên chưa tồn tại thì không tạo phiên mới.
//        HttpSession session = req.getSession(false);
//        if(session != null && session.getAttribute("account") != null) {
//            resp.sendRedirect(req.getContextPath()+"/admin");
//            return;
//        }
//
//        Cookie[] cookies = req.getCookies();
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("username")) {
//                session = req.getSession(true);
//                session.setAttribute("account", cookie.getValue());
//                resp.sendRedirect(req.getContextPath()+"/admin");
//                return;
//            }
//        }
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        String address = req.getParameter("address");
        String image = req.getParameter("images");
        String phone = req.getParameter("phone");
        String repassword = req.getParameter("repassword");

        String alertMsg = "";
        if(username.isEmpty()||fullname.isEmpty()||password.isEmpty()||address.isEmpty()||image.isEmpty()||phone.isEmpty()||repassword.isEmpty()) {
            alertMsg = "Please fill all the required fields";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }
        if(userServices.checkExistingUsername(username)) {
            alertMsg = "Username already exists";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }
        if (userServices.checkExistingPhone(phone)) {
            alertMsg = "Phone number already exists";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }
        if(!password.equals(repassword)) {
            alertMsg = "Passwords do not match";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }

        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        Users user = new Users(phone,date,3,image,password,username,address,fullname);

        if(userServices.createUser(user)) {
            resp.sendRedirect(req.getContextPath()+"/login");
        }
        else {
            alertMsg = "Something went wrong";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }
}
