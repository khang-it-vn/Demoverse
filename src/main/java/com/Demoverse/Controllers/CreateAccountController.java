package com.Demoverse.Controllers;

import com.Demoverse.Entities.Users;
import com.Demoverse.Logic.MailUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/createAccount"})
public class CreateAccountController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = new Users();
        users.setEmail(req.getParameter("email"));
        users.setPass(req.getParameter("password"));
        users.setUsername(req.getParameter("username"));
        String password = req.getParameter("password");
        System.out.println(password);
        password = req.getParameter("re_password");
        System.out.println(password);
        if(req.getParameter("password").compareTo(req.getParameter("re_password")) != 0)
        {
            resp.setContentType("text/html");
            PrintWriter writer= resp.getWriter();
            writer.println("Mat khau nhap lai khong trung khop");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("createAccount.jsp");
            requestDispatcher.include(req,resp);
            return;
        }
        else {
            try {
                MailUtil.sendMail(users);
            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println("Link create account sended your mail, please click link in your mail to confirm the account creation");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.include(req,resp);
        }

    }
}
