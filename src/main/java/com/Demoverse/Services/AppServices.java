package com.Demoverse.Services;

import com.Demoverse.Database.ConnectDB;
import com.Demoverse.Services.Interface.*;

import java.sql.Connection;
import java.sql.SQLException;

public class AppServices {
    public IBlockList blockList;
    public IDeatailRoom deatailRoom;
    public IRoom room;
    public IThongKe thongKe;
    public ITypeRoom typeRoom;
    public IUsers users;
    public Connection connection;
    public AppServices()
    {
        this.connection = ConnectDB.getConnect();
        this.blockList = new BlockListService(this.connection);
        this.deatailRoom = new DetailRoomService(this.connection);
        this.thongKe = new ThongKeService(this.connection);
        this.room = new RoomService(this.connection);
        this.users = new UsersService(this.connection);
        this.typeRoom = new TypeRoomService(this.connection);
    }

    public void Close() {
        try {
            this.connection.close();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
