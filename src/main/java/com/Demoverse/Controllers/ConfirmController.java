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
import java.net.URLDecoder;

@WebServlet(urlPatterns = {"/confirm"})
public class ConfirmController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users us = new Users();
        us.setEmail(req.getParameter("email"));
        us.setUsername(req.getParameter("username"));
        us.setUsername(URLDecoder.decode(us.getUsername(),"UTF-8"));
        us.setPass(req.getParameter("password"));

        AppServices appServices = new AppServices();
        appServices.addUser(us);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<label style=\"color: blue; \"> your account is confirm successful</label>");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        requestDispatcher.include(req,resp);
    }
}
