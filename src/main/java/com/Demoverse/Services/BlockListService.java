package com.Demoverse.Services;

import com.Demoverse.Entities.BlockList;
import com.Demoverse.Entities.Room;
import com.Demoverse.Services.Interface.IBlockList;

import java.sql.Connection;
import java.util.List;

public class BlockListService implements IBlockList {

    private Connection con;
    private List<BlockList> list;

    public  BlockListService(Connection con)
    {
        this.con = con;
    }
    @Override
    public List<BlockList> getAll() {
        return null;
    }

    @Override
    public void add(BlockList entity) {

    }

    @Override
    public void delete(BlockList entity) {

    }

    @Override
    public void update(BlockList entity) {

    }
}
