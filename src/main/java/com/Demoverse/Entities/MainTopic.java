package com.Demoverse.Entities;

public class MainTopic {
    private int id_Topic;
    private String name_Topic;

    public int getId_Topic() {
        return id_Topic;
    }

    public void setId_Topic(int id_Topic) {
        this.id_Topic = id_Topic;
    }

    public String getName_Topic() {
        return name_Topic;
    }

    public void setName_Topic(String name_Topic) {
        this.name_Topic = name_Topic;
    }

    public MainTopic(int id_Topic, String name_Topic) {
        this.id_Topic = id_Topic;
        this.name_Topic = name_Topic;
    }

    public MainTopic()
    {
        super();
    }
}
