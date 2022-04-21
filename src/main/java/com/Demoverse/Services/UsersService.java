package com.Demoverse.Services;

import com.Demoverse.Database.ConnectDB;
import com.Demoverse.Entities.Users;
import com.Demoverse.Services.Interface.IUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersService  implements IUsers {

    private Connection con;

    private List<Users> list;
    public UsersService(Connection con) {
        this.con = con;
    }
    @Override
    public List<Users> getAll() {

        return null;
    }

    @Override
    public void add(Users entity) {

    }

    @Override
    public void delete(Users entity) {

    }

    @Override
    public void update(Users entity) {

    }

    public List<Users> getList() {
        try
        {
            list = new ArrayList<>();
            String query = "select * from users";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            Users users = new Users();
            while (resultSet.next())
            {
                users.setEmail(resultSet.getString("EMAIL"));
                users.setUsername(resultSet.getString("USERNAME"));
                users.setPass(resultSet.getString("PASS"));
                users.setIntroduce(resultSet.getString("INTRODUCE"));
                list.add(users);
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void setList(List<Users> list) {
        this.list = list;
    }
}
