package iostar.java.controllers;

import iostar.java.models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("account") != null) {
            UserModel user = (UserModel) session.getAttribute("account");
            req.setAttribute("account", user.getFullName());
            if(user.getRole_id() == 1){
                resp.sendRedirect(req.getContextPath()+"/admin/home");
            }
            else if(user.getRole_id() == 2){
                resp.sendRedirect(req.getContextPath()+"/manager/home");
            }
            else if(user.getRole_id() == 3){
                resp.sendRedirect(req.getContextPath()+"/user/home");
            }
        }
        else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
