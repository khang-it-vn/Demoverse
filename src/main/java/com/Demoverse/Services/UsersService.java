package com.Demoverse.Services;

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
        String query = "insert into USERS (EMAIL, USERNAME, PASSS, INTRODUCE) values (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,entity.getEmail());
            preparedStatement.setString(2,entity.getUsername());
            preparedStatement.setString(3,entity.getPass());
            preparedStatement.setString(4,entity.getIntroduce());
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
    public void delete(Users entity) {
        String query = "delete from users where email = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,entity.getEmail());
            int rows = preparedStatement.executeUpdate();
            if(rows>0)
            {
                System.out.println("delete rows success");
            }
            else
                System.out.println("Delete rows not success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Users entity) {
        String query = "update user set PASSS = ?, USERNAME = ?, INTRODUCE = ? where EMAIL = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,entity.getPass());
            preparedStatement.setString(2,entity.getUsername());
            preparedStatement.setString(3,entity.getIntroduce());
            int rows = preparedStatement.executeUpdate();
            if(rows>0)
            {
                System.out.println("Update rows success");
            }
            else
                System.out.println("Update rows not success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

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
    @Override
    public Boolean find (String str){
        Boolean bool = false;
        String query = "select * from users where EMAIL = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, str);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                bool = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bool;
    }

    @Override
    public boolean checkPass(Users users) {
        boolean bool = false;
        String query = "select * from users where EMAIL = ? and passs = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, users.getEmail());
            preparedStatement.setString(2, users.getPass());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                bool = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bool;
    }

    @Override
    public Users findUser(Users user) {
        Users user_finded ;
        String query = "select * from users where EMAIL = ? and passs = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPass());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                user_finded = new Users(resultSet.getString("EMAIl"), resultSet.getString("USERNAME"), resultSet.getString("Passs"),resultSet.getString("INTRODUCE"));
                return user_finded;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Users findUserReplacePass(String email) {
        Users user_finded ;
        String query = "select * from users where EMAIL = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                user_finded = new Users(resultSet.getString("EMAIl"), resultSet.getString("USERNAME"), resultSet.getString("Passs"),resultSet.getString("INTRODUCE"));
                return user_finded;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Users getUserBy(String email) {
        Users user;
        String query = "select * from users where email = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                user = new Users(resultSet.getString("EMAIl"), resultSet.getString("USERNAME"), resultSet.getString("Passs"),resultSet.getString("INTRODUCE"));
                return user;
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateInfo(Users user) {
        String query = "update users set  USERNAME = ?, INTRODUCE = ? where EMAIL = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getIntroduce());
            preparedStatement.setString(3,user.getEmail());
            int rows = preparedStatement.executeUpdate();
            if(rows>0)
            {
                System.out.println("Update rows success");
            }
            else
                System.out.println("Update rows not success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void setList(List<Users> list) {
        this.list = list;
    }
}
