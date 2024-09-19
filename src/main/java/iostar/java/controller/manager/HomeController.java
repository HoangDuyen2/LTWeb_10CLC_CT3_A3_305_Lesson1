package iostar.java.controller.manager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/manager/home","/manager/logout"})
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var currentURL = req.getRequestURI();
        if(currentURL.contains("/logout")){
            getLogout(req, resp);
        }
        req.getRequestDispatcher("/views/manager/home.jsp").forward(req, resp);
    }
    protected void getLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
    }
}
