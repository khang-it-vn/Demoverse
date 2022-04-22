package com.Demoverse.Services;

import com.Demoverse.Entities.TypeRoom;
import com.Demoverse.Services.Interface.ITypeRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeRoomService  implements ITypeRoom {

    private Connection con;
    private List<TypeRoom> list;

    public TypeRoomService(Connection conn) {
        this.con = conn;
    }

    public List<TypeRoom> getList() {
        return list;
    }

    public void setList(List<TypeRoom> list) {
        this.list = list;
    }

    @Override
    public List<TypeRoom> getAll() {
       try
       {
           list = new ArrayList<>();
           String query = "select * from type_room";
           PreparedStatement preparedStatement = this.con.prepareStatement(query);
           ResultSet resultSet = preparedStatement.executeQuery();
           TypeRoom typeRoom = new TypeRoom();
           while (resultSet.next())
           {
               typeRoom.setId(resultSet.getInt("ID"));
               typeRoom.setRoom_Type_Name(resultSet.getString("ROOM_TYPE_NAME"));
               list.add(typeRoom);
           }
           return list;
       }catch (Exception e)
       {
           System.out.println(e.getMessage());
           return null;
       }
    }

    @Override
        public void add(TypeRoom entity) {
            String query = "insert into type_room (ROOM_TYPE_NAME) values (?)";

            try {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1,entity.getRoom_Type_Name());
                int rows = preparedStatement.executeUpdate();
                if(rows>0)
                {
                    System.out.println("add rows success");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public void delete(TypeRoom entity) {
            String query = "delete from type_room where ROOM_TYPE_NAME = ?";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1,entity.getRoom_Type_Name());
                int rows = preparedStatement.executeUpdate();
                if(rows>0)
                {
                    System.out.println("delete rows success");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }




    //@Override
    public void update(TypeRoom entity) {
        /*String query = "update type_room set ROOM_TYPE_NAME where ROOM_TYPE_NAME = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,entity.getRoom_Type_Name());
            int rows = preparedStatement.executeUpdate();
            if(rows>0)
            {
                System.out.println("delete rows success");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/

    }
}
