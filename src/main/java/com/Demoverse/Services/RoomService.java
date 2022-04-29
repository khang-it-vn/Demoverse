package com.Demoverse.Services;

import com.Demoverse.Entities.Room;
import com.Demoverse.Services.Interface.IRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomService implements IRoom {
    private Connection con;
    private List<Room> list;

    public RoomService(Connection con) {
        this.con = con;
    }

    @Override
    public List<Room> getAll() {
        try {
            list = new ArrayList<>();
            String query = "select * from room";
            PreparedStatement preparedStatement = this.con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room();
                room.setKey_Room(resultSet.getInt("key_room"));
                room.setId_Type(resultSet.getInt("id_type"));
                room.setPassword_Room(resultSet.getString("password_room"));
                room.setTotal(resultSet.getInt("total"));
                room.setState(resultSet.getBoolean("States"));
                list.add(room);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void add(Room entity) {
        String query = "insert into room ( id_type, total, password_room, states ) values (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, entity.getId_Type());
            preparedStatement.setInt(2, entity.getTotal());
            preparedStatement.setString(3, entity.getPassword_Room());
            preparedStatement.setBoolean(4,entity.getState());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("add rows success");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Room entity) {
        String query = "delete from room where  Key_Room = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, entity.getKey_Room());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("delete rows success");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Room entity) {
        String query = "update room set id_type = ?, total = ?, password_room = ? where key_room = ?";
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
    }

    @Override
    public int count() {
        String query = "select count(*) from room";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next() ) {
                System.out.println("find key successful!");
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public Room findByKeyRoom(int id_room) {
        String query = "select * from room where key_room = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,id_room);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Room(rs.getInt("KEY_ROOM"),rs.getInt("ID_TYPE"),rs.getInt("TOTAL"),rs.getString("PASSWORD_ROOM"),rs.getBoolean("STATES"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
