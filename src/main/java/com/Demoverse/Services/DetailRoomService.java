package com.Demoverse.Services;

import com.Demoverse.Entities.DetailRoom;
import com.Demoverse.Entities.Room;
import com.Demoverse.Services.Interface.IDeatailRoom;

import java.sql.Connection;
import java.util.List;

public class DetailRoomService implements IDeatailRoom {

    private Connection con;
    private List<DetailRoom> list;

    public  DetailRoomService(Connection con)
    {
        this.con = con;
    }
    @Override
    public List<DetailRoom> getAll() {
        return null;
    }

    @Override
    public void add(DetailRoom entity) {

    }

    @Override
    public void delete(DetailRoom entity) {

    }

    @Override
    public void update(DetailRoom entity) {

    }
}
