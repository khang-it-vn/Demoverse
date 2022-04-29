package com.Demoverse.Controllers;

import com.Demoverse.Entities.Users;
import com.Demoverse.Logic.MailUtil;
import com.Demoverse.Services.AppServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/replacePasswordSendMail"})
public class ReplacePasswordSendmailController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = new Users();
        AppServices appServices = new AppServices();
        users = appServices.findUserReplacePass(req.getParameter("email"));
        if(users == null)
        {
            resp.setContentType("text/html");
            PrintWriter writer= resp.getWriter();
            writer.println("Mail chua tung dang ky voi he thong!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.include(req,resp);
            return;
        }
        else
        {
            try{
                MailUtil.send_link_Replace_Password(users);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println("Link replace password sent your mail, please click link in your mail to confirm the account creation");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.include(req,resp);
        }
    }
}
