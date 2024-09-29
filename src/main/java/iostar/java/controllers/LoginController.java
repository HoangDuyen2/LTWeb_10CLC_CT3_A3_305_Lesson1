package iostar.java.controllers;

import iostar.java.models.Users;
import iostar.java.services.IUserServices;
import iostar.java.services.impl.UserServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    IUserServices userServices = new UserServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String alertMsg = "";
        if (username == null || password == null) {
            alertMsg = "Please enter all the fields correct";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }

        Users user = userServices.login(username, password);

        if(user != null){
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);

            if(req.getParameter("remember").equals("on")){
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(24*60*60);
                resp.addCookie(cookie);
            }
            resp.sendRedirect(req.getContextPath()+"/waiting");
        }
        else {
            alertMsg = "Username or password is incorrect";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
