package com.Demoverse.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeRoom {
    private int id;
    private String room_Type_Name;
    public TypeRoom()
    {
        super();
    }
    public TypeRoom(int id, String room_Type_Name)
    {
        this.id = id;
        this.room_Type_Name = room_Type_Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_Type_Name() {
        return room_Type_Name;
    }

    public void setRoom_Type_Name(String room_Type_Name) {
        this.room_Type_Name = room_Type_Name;
    }



}
