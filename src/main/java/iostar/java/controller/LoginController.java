package iostar.java.controller;

import iostar.java.dao.iml.UserDAOIml;
import iostar.java.models.UserModel;
import iostar.java.services.IUserService;
import iostar.java.services.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login","/dang-nhap"})

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
//        req.setCharacterEncoding("UTF-8");
//
//        PrintWriter out = resp.getWriter();
//
//        String username = req.getParameter("uname");
//        String password = req.getParameter("psw");
//
//        out.println("<!DOCTYPE html>");
//        out.println("<p>Username: " + username + "</p>");
//        out.println("<p>Password: " + password + "</p>");
//        out.close();
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/Login.jsp");
//        dispatcher.forward(req, resp);
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            resp.sendRedirect(req.getContextPath() + "/waiting");
            return;
        }
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

//      Xử lí bài toán
//        boolean kt = false;
//        if ((username.equals("admin")&&password.equals("admin"))) {
//            kt = true;
//            req.setAttribute("uName", username  );
//        }
//        else {
//            kt = false;
////            Trả tham số về font-end
//        }
//        req.setAttribute("msg", kt );
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/home.jsp");
//        dispatcher.forward(req, resp);
        String alertMsg="";
        if(username.isEmpty() || password.isEmpty()){
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }
        IUserService service = new UserServiceImpl();
        UserModel user = service.login(username, password);
        if(user!=null){
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            resp.sendRedirect(req.getContextPath()+"/waiting");
        }else{
            alertMsg =
                    "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
