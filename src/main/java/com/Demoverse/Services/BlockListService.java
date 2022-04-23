package com.Demoverse.Services;

import com.Demoverse.Entities.BlockList;
import com.Demoverse.Services.Interface.IBlockList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try
        {
            list = new ArrayList<>();
            String query = "select * from BLOCK_LIST";
            PreparedStatement preparedStatement = this.con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            BlockList blockList = new BlockList();
            while (resultSet.next())
            {
                blockList.setEmail(resultSet.getString("EMAIL"));
                blockList.setEmail_blocked(resultSet.getString("EMAIL_BLOCKED"));
                list.add(blockList);
            }
            return list;
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void add(BlockList entity) {
        String query = "insert into BLOCK_LIST (EMAIL, EMAIL_BLOCKED) values (?,?)";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,entity.getEmail());
            preparedStatement.setString(2,entity.getEmail_blocked());
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
    public void delete(BlockList entity) {
        String query = "delete from block_list where email = ? AND email_blocked = ? ";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,entity.getEmail());
            preparedStatement.setString(2,entity.getEmail_blocked());
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
    public void update(BlockList entity) {

    }
}
