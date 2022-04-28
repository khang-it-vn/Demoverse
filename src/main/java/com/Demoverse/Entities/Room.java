package com.Demoverse.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Room {
    private int key_Room;
    private int id_Type;
    private int total;
    private String password_Room;
    private boolean state;

    public int getKey_Room() {
        return key_Room;
    }

    public void setKey_Room(int key_Room) {
        this.key_Room = key_Room;
    }

    public int getId_Type() {
        return id_Type;
    }

    public void setId_Type(int id_Type) {
        this.id_Type = id_Type;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPassword_Room() {
        return password_Room;
    }

    public void setPassword_Room(String password_Room) {
        this.password_Room = password_Room;
    }

    public Room(int key_Room, int id_Type, int total, String password_Room, boolean state) {
        this.key_Room = key_Room;
        this.id_Type = id_Type;
        this.total = total;
        this.password_Room = password_Room;
        this.state = state;
    }
    public Room()
    {
        super();
    }

    public void cast(ResultSet resultSet) throws SQLException {
        while (resultSet.next())
        {
            this.key_Room = resultSet.getInt("KEY_ROOM");
            this.id_Type = resultSet.getInt("ID_TYPE");
            this.password_Room = resultSet.getString("PASSWORD_ROOM");
            this.total = resultSet.getInt("TOTAL");
            this.state = resultSet.getBoolean("STATES");
        }
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
