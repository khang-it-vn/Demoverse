package com.Demoverse.Controllers;

import com.Demoverse.Entities.MainTopic;
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

import java.io.IOException;
import java.util.ArrayList;
@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppServices appServices = new AppServices();

        ArrayList<MainTopic> mainTopics = (ArrayList<MainTopic>) appServices.mainTopic.getAll();

        ArrayList<TypeRoom> typeRooms = (ArrayList<TypeRoom>) appServices.typeRoom.getAll();

        ArrayList<Room> rooms = (ArrayList<Room>) appServices.room.getAll();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        String typeRooms_json = ow.writeValueAsString(typeRooms);

        String rooms_json = ow.writeValueAsString(rooms);

        req.setAttribute("typeRooms",typeRooms_json);
        req.setAttribute("mainTopics",mainTopics);
        req.setAttribute("rooms",rooms_json);
        req.setAttribute("typeRooms_combobox",typeRooms);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("action.jsp");
        requestDispatcher.forward(req,resp);
    }
}
