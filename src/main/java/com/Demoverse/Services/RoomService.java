package com.Demoverse.Services;

import com.Demoverse.Entities.Room;
import com.Demoverse.Services.Interface.IRoom;

import java.sql.Connection;
import java.util.List;

public class RoomService implements IRoom {
    private Connection con;
    private List<Room> list;

    public RoomService(Connection con)
    {
        this.con = con;
    }
    @Override
    public List<Room> getAll() {
        return null;
    }

    @Override
    public void add(Room entity) {

    }

    @Override
    public void delete(Room entity) {

    }

    @Override
    public void update(Room entity) {

    }
}
