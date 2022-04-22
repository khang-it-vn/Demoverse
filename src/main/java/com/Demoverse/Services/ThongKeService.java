package com.Demoverse.Services;

import com.Demoverse.Entities.ThongKe;
import com.Demoverse.Services.Interface.IThongKe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeService implements IThongKe {
    private Connection con;
    private List<ThongKe> list;

    public ThongKeService(Connection con)
    {
        this.con = con;
    }

    @Override
    public List<ThongKe> getAll() {
        try {
            list = new ArrayList<>();
            String query = "select * from thongke";
            PreparedStatement preparedStatement = this.con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            ThongKe thongKe = new ThongKe();
            while (resultSet.next()) {
                thongKe.setMonth(resultSet.getInt("m"));
                thongKe.setYear(resultSet.getInt("y"));
                thongKe.setCount_connect(resultSet.getInt("COUNT_CONNECT"));
                list.add(thongKe);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void add(ThongKe entity) {
        String query = "insert into thongke ( count_connect, m, y) values (?,?,?)";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, entity.getCount_connect());
            preparedStatement.setInt(2, entity.getMonth());
            preparedStatement.setInt(3, entity.getYear());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("add rows success");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(ThongKe entity) {

    }

    @Override
    public void update(ThongKe entity) {
        String query = "update thong set count_connect = ? where m = ? and y = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, entity.getCount_connect());
            preparedStatement.setInt(2, entity.getMonth());
            preparedStatement.setInt(3, entity.getYear());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("update rows success");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<ThongKe> getList() {
        return list;
    }

    public void setList(List<ThongKe> list) {
        this.list = list;
    }
}
