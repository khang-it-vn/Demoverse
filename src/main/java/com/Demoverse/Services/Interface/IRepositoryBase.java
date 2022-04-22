package com.Demoverse.Services.Interface;

import java.util.List;

public interface IRepositoryBase<T>{

    // get all list of object
    List<T> getAll();

    // add object
    void add(T entity);

    //delete object
    void delete(T entity);

    //update object
    void update(T entity);



}
