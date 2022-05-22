package com.Demoverse.Services;

import com.Demoverse.Entities.DetailRoom;
import com.Demoverse.Services.Interface.IDeatailRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try {
            list = new ArrayList<>();
            String query = "select * from detail_room";
            PreparedStatement preparedStatement = this.con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            DetailRoom detailRoom = new DetailRoom();
            while (resultSet.next()) {
                detailRoom.setKey_Room(resultSet.getInt("key_room"));
                detailRoom.setEmail(resultSet.getString("email"));
                list.add(detailRoom);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void add(DetailRoom entity) {
        String query = "insert into detail_room ( email, key_room) values (?,?)";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(2, entity.getKey_Room());
            preparedStatement.setString(1, entity.getEmail());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("add rows success");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(DetailRoom entity) {
        String query = "delete from detail_room where  Key_Room = ? and email = ? ";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, entity.getKey_Room());
            preparedStatement.setString(2, entity.getEmail());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("delete rows success");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(DetailRoom entity) {
      /*  String query = "update detail_room set key_room = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, entity.getId_Type());
            preparedStatement.setInt(2, entity.getTotal());
            preparedStatement.setString(3, entity.getPassword_Room());
            preparedStatement.setInt(4, entity.getKey_Room());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("update rows success");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
    }

    @Override
    public DetailRoom findDetailRoom(DetailRoom entity) {
        String query = "select * from detail_room where  Key_Room = ? and email = ? ";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, entity.getKey_Room());
            preparedStatement.setString(2, entity.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new DetailRoom(resultSet.getString("EMAIL"),resultSet.getInt("KEY_ROOM"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
