package com.Demoverse.test;

import com.Demoverse.Entities.TypeRoom;
import com.Demoverse.Services.AppServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = {"/test"})
public class test_Data extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppServices services = new AppServices();
        TypeRoom entity = new TypeRoom();
        entity.setRoom_Type_Name("djsadsa");
        services.typeRoom.add(entity);
        System.out.println("THanh cong cahy");
    }
}
