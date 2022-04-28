package com.Demoverse.Services;

import com.Demoverse.Entities.MainTopic;
import com.Demoverse.Entities.Room;
import com.Demoverse.Services.Interface.IMainTopic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MainTopicServices implements IMainTopic {
    private Connection con;
    private List<MainTopic> list;
    public MainTopicServices(Connection connection) {
        this.con = connection;
    }

    @Override
    public List<MainTopic> getAll() {
        try {
            list = new ArrayList<>();
            String query = "select * from main_topic";
            PreparedStatement preparedStatement = this.con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MainTopic mainTopic = new MainTopic();
                mainTopic.setId_Topic(resultSet.getInt("ID_TOPIC"));
                mainTopic.setName_Topic(resultSet.getString("NAME_TOPIC"));
                list.add(mainTopic);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void add(MainTopic entity) {

    }

    @Override
    public void delete(MainTopic entity) {

    }

    @Override
    public void update(MainTopic entity) {

    }
}
