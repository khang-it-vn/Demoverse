package com.Demoverse.Controllers;

import com.Demoverse.Entities.Room;
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

@WebServlet(urlPatterns = {"/join"})
public class JoinRoomController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_room = Integer.valueOf(req.getParameter("meetingID"));
        AppServices appServices = new AppServices();
        Room room = appServices.room.findByKeyRoom(id_room);
        Cookie[] cookies = req.getCookies();
        if(room != null)
        {
            if(room.getState())
            {
                String username = null;
                for (Cookie c:cookies)
                {
                    if(c.getName().equals("username"))
                    {
                        username = c.getValue().replace("+"," ");
                    }
                }
                resp.sendRedirect("http://127.0.0.1:3000/index.html?meeting_id="+id_room +"&user_id="+username);
            }
            else
            {
                String password_room = req.getParameter("password_room");
                if(password_room.compareTo(room.getPassword_Room())==0)
                {
                    String username = null;
                    for (Cookie c:cookies)
                    {
                        if(c.getName().equals("username"))
                        {
//                        username = URLDecoder.decode(c.getValue(),"UTF-8");
                            username = c.getValue().replace("+"," ");
                        }
                    }
                    resp.sendRedirect("http://127.0.0.1:3000/index.html?meeting_id="+id_room +"&user_id="+username);
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
