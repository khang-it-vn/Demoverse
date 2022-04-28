package com.Demoverse.Controllers;

import com.Demoverse.Entities.Users;
import com.Demoverse.Services.AppServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = new Users();
        user.setEmail(req.getParameter("email"));
        user.setPass(req.getParameter("password"));
        AppServices appServices = new AppServices();
        Users kq= appServices.users.findUser(user);
        if(kq!= null)
        {
            
            System.out.println(kq.getEmail()+ "\n" + kq.getUsername());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("action.jsp");
            Cookie c_email = new Cookie("email",kq.getEmail());
            String username_encode = URLEncoder.encode(kq.getUsername(),"UTF-8");
            Cookie c_username = new Cookie("username",username_encode);
           
            resp.addCookie(c_email);
            resp.addCookie(c_username);
            requestDispatcher.include(req,resp);
        }
        else
        {
            resp.setContentType("text/html");
            PrintWriter writer= resp.getWriter();
            writer.println("<label style=\"color: red; text-align: center;\">password or account is not yes</label>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.include(req,resp);
        }


    }
}
