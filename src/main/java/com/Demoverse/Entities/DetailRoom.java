package com.Demoverse.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailRoom {
    private String email;
    private int key_Room;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getKey_Room() {
        return key_Room;
    }

    public void setKey_Room(int key_Room) {
        this.key_Room = key_Room;
    }

    public DetailRoom(String email, int key_Room) {
        this.email = email;
        this.key_Room = key_Room;
    }
    public DetailRoom()
    {
        super();
    }

    public void cast(ResultSet resultSet) throws SQLException {
        while (resultSet.next())
        {
            this.key_Room = resultSet.getInt("KEY_ROOM");
            this.email = resultSet.getString("EMAIL");
        }
    }
}
