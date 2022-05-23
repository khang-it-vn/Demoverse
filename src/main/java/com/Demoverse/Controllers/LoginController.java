package com.Demoverse.Controllers;

import com.Demoverse.Entities.MainTopic;
import com.Demoverse.Entities.Room;
import com.Demoverse.Entities.TypeRoom;
import com.Demoverse.Entities.Users;
import com.Demoverse.Services.AppServices;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import javax.mail.Session;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private Users kq;
     private AppServices appServices = new AppServices();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = new Users();
        user.setEmail(req.getParameter("email"));
        user.setPass(req.getParameter("password"));
         appServices = new AppServices();
         kq= appServices.users.findUser(user);
        if(kq!= null)
        {

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("action.jsp");
            Cookie c_email = new Cookie("email",kq.getEmail());
            String username_encode = URLEncoder.encode(kq.getUsername(),"UTF-8");
            Cookie c_username = new Cookie("username",username_encode);

            HttpSession session = req.getSession();
            session.setAttribute("email",kq.getEmail());
            session.setAttribute("username",kq.getUsername());
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
