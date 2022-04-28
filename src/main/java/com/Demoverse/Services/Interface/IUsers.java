package com.Demoverse.Services.Interface;

import com.Demoverse.Entities.Users;

public interface IUsers extends IRepositoryBase<Users> {
    Boolean find(String str);
    boolean checkPass(Users users);
    Users findUser(Users user);
}
