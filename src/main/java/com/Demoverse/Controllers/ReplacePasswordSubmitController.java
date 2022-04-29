package com.Demoverse.Controllers;

import com.Demoverse.Entities.Users;
import com.Demoverse.Services.AppServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/replacePasswordSubmit"})
public class ReplacePasswordSubmitController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("password").compareTo(req.getParameter("repassword")) != 0)
        {
            resp.setContentType("text/html");
            PrintWriter writer= resp.getWriter();
            writer.println("Mat khau nhap lai khong trung khop");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("replacePassword.jsp");
            requestDispatcher.include(req,resp);
        }
        else {
            System.out.println("1");
            Users user = new Users();
            AppServices appServices = new AppServices();
            user = appServices.findUserReplacePass((String)req.getParameter("email"));
            user.setPass(req.getParameter("password"));
            appServices.updateUser(user);
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println("<label style=\"color: blue; \"> your password is change successful</label>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.include(req,resp);

        }
    }
}
