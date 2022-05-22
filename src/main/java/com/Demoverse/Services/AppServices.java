package com.Demoverse.Services;

import com.Demoverse.Database.ConnectDB;
import com.Demoverse.Entities.DetailRoom;
import com.Demoverse.Entities.Users;
import com.Demoverse.Services.Interface.*;

import java.sql.Connection;

public class AppServices {
    public IBlockList blockList;
    public IDeatailRoom deatailRoom;
    public IRoom room;
    public IThongKe thongKe;
    public ITypeRoom typeRoom;
    public IUsers users;
    public Connection connection;
    public IMainTopic mainTopic;
    public AppServices()
    {
        this.connection = ConnectDB.getConnect();
        this.blockList = new BlockListService(this.connection);
        this.deatailRoom = new DetailRoomService(this.connection);
        this.thongKe = new ThongKeService(this.connection);
        this.room = new RoomService(this.connection);
        this.users = new UsersService(this.connection);
        this.typeRoom = new TypeRoomService(this.connection);
        this.mainTopic = new MainTopicServices(this.connection);
    }
    public void addUser(Users user)
    {
        Boolean bool = users.find(user.getEmail());
        if(!bool)
            users.add(user);
        else
            System.out.println("Da ton tai email");
    }
    public void deleteUser(Users user)
    {
        users.delete(user);
    }
    public void Close() {
        try {
            this.connection.close();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public boolean checkLogin(Users user) {
        boolean bool = false;
        bool = users.checkPass(user);
        return bool;
    }

    public  boolean checkUser(String str)
    {
        //ton tai tra ve false, khong ton tai tra ve true
        boolean bool = users.find(str);
        return bool;
    }

    public Users findUserReplacePass(String email) {
        return users.findUserReplacePass(email);
    }

    public void updateUser(Users user) {
        users.update(user);
    }

    public DetailRoom findDetailRoom(DetailRoom entity) {
        return deatailRoom.findDetailRoom(entity);
    }

    public void addDetailRoom(DetailRoom detailRoom) {
        this.deatailRoom.add(detailRoom);
    }
}
