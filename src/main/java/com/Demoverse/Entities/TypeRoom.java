package com.Demoverse.Entities;

public class TypeRoom {
    private int id;
    private String room_Type_Name;
    private int id_Topic;
    public TypeRoom()
    {
        super();
    }
    public TypeRoom(int id, String room_Type_Name, int id_topic)
    {
        this.id = id;
        this.room_Type_Name = room_Type_Name;
        this.id_Topic = id_topic;
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

    public int getId_Topic() {
        return id_Topic;
    }

    public void setId_Topic(int id_Topic) {
        this.id_Topic = id_Topic;
    }
}
