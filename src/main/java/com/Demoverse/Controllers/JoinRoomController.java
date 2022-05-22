package com.Demoverse.Controllers;

import com.Demoverse.Entities.DetailRoom;
import com.Demoverse.Entities.Room;
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
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = {"/join"})
public class JoinRoomController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_room = Integer.valueOf(req.getParameter("meetingID"));

        AppServices appServices = new AppServices();

        Room room = appServices.room.findByKeyRoom(id_room);
        Cookie[] cookies = req.getCookies();

        Users user = appServices.users.getUserBy(req.getParameter("email"));
//        user.setUsername((String) req.getSession().getAttribute("username"));
//        user.setEmail((String) req.getSession().getAttribute("email"));
//        for (Cookie c:cookies)
//        {
//            if(c.getName().equals("username"))
//            {
                user.setUsername(user.getUsername().replace("+"," "));
        System.out.println(user.getUsername());
        System.out.println(URLEncoder.encode(user.getUsername(), StandardCharsets.UTF_8.toString()));
//            }
//            if(c.getName().equals("email"))
//            {
//                user.setEmail(c.getValue());
//            }
//        }
        if(room != null)
        {
            DetailRoom detailRoom = new DetailRoom(user.getEmail(),id_room);
            DetailRoom detailRoom_out = appServices.findDetailRoom(detailRoom);
            if(detailRoom_out == null)
            {
                appServices.addDetailRoom(detailRoom);
            }
            else
            {
                resp.setContentType("text/html");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("action.jsp");
                requestDispatcher.include(req,resp);
                PrintWriter writer = resp.getWriter();
                writer.println("<script> alert(\"You are currently opening this room\");</script>");
                return;
            }
            if(room.getState())
            {
                resp.sendRedirect("http://127.0.0.1:3000/index.html?meeting_id="+id_room +"&user_id="+user.getEmail()+"&user_name="+URLEncoder.encode(user.getUsername(), StandardCharsets.UTF_8.toString()));
            }
            else
            {
                String password_room = req.getParameter("password_room");
                if(password_room.compareTo(room.getPassword_Room())==0)
                {
                    resp.sendRedirect("http://127.0.0.1:3000/index.html?meeting_id="+id_room +"&user_id="+user.getEmail()+"&user_name="+URLEncoder.encode(user.getUsername(), StandardCharsets.UTF_8.toString()));
                }
                else
                {
                    resp.setContentType("text/html");
                    PrintWriter writer = resp.getWriter();
                    writer.println("<script> alert(\"password room wrong\");</script>");
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("action.jsp");
                    requestDispatcher.include(req,resp);
                }
            }
        }
        else
        {
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println("<script> alert(\"id room is not exists\");</script>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("action.jsp");
            requestDispatcher.include(req,resp);
        }
    }
}
