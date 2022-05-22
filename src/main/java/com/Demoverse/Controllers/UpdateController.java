package com.Demoverse.Controllers;

import com.Demoverse.Entities.Users;
import com.Demoverse.Services.AppServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(urlPatterns = {"/update-info"})
public class UpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hoten = req.getParameter("hoten");
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        String introduce = req.getParameter("introduce");
        session.setAttribute("username",hoten);
        Users user = new Users();
        user.setEmail(email);
        user.setUsername(hoten);
        user.setIntroduce(introduce);

        AppServices services = new AppServices();
        services.users.updateInfo(user);

        req.setAttribute("user",user);
        req.getRequestDispatcher("profile.jsp").include(req,resp);

    }
}
