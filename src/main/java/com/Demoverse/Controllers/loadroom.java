package com.Demoverse.Controllers;

import com.Demoverse.Entities.Room;
import com.Demoverse.Entities.TypeRoom;
import com.Demoverse.Services.AppServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import javax.swing.tree.RowMapper;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/load_room"})
public class loadroom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        AppServices
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1,1,0,"abc"));
        rooms.add(new Room(2,1,0,"123"));
        rooms.add(new Room(3,3,0,"abc"));
        rooms.add(new Room(4,4,0,"123"));
        System.out.println(rooms.size());

        ArrayList<TypeRoom> typeRooms = new ArrayList<>();
        typeRooms.add(new TypeRoom(1,"toan 1"));
        typeRooms.add(new TypeRoom(2,"toan 2"));
        typeRooms.add(new TypeRoom(3,"toan 3"));
        typeRooms.add(new TypeRoom(4,"toan 4"));


        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(rooms);
        req.setAttribute("rooms",json);
        req.setAttribute("typeRooms",typeRooms);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("action.jsp");
        requestDispatcher.forward(req,resp);
    }
}
