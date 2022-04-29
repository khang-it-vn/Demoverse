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
import java.net.URLDecoder;

@WebServlet(urlPatterns = {"/create_new_meeting"})
public class CreateNewMeeting_Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pas = req.getParameter("password");
        int id_Type = Integer.parseInt(req.getParameter("type_room"));

        String username = null;
        Cookie[] cookies = req.getCookies();
        for (Cookie c:cookies) {
            if(c.getName().equals("username"))
            {
                username = c.getValue().replace("+"," ");

            }
        }
        Room new_room = new Room();
        new_room.setState(false);
        new_room.setId_Type(id_Type);
        new_room.setPassword_Room(pas);
        new_room.setTotal(1);

        AppServices appServices = new AppServices();
        appServices.room.add(new_room);
        int key_room = appServices.room.count();

        resp.sendRedirect("http://127.0.0.1:3000/index.html?meeting_id="+key_room +"&user_id="+username);

//        hoàn tất tạo và join phòng còn thíu set cookie để lấy được username
        // ngày mai làm đăng nhập, tạo tài khoản, join vào phòng với password
    }
}
