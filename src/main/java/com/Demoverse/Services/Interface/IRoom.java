package com.Demoverse.Services.Interface;

import com.Demoverse.Entities.Room;

public interface IRoom extends IRepositoryBase<Room> {
    int count();

    Room findByKeyRoom(int id_room);
}
