package com.Demoverse.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThongKe {
    private int month;
    private int year;
    private int count_connect;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCount_connect() {
        return count_connect;
    }

    public void setCount_connect(int count_connect) {
        this.count_connect = count_connect;
    }

    public ThongKe(int month, int year, int count_connect) {
        this.month = month;
        this.year = year;
        this.count_connect = count_connect;
    }
    public ThongKe()
    {
        super();
    }

    public void cast(ResultSet resultSet) throws SQLException {
        while (resultSet.next())
        {
            this.month = resultSet.getInt("M");
            this.year = resultSet.getInt("Y");
            this.count_connect = resultSet.getInt("COUNT_CONNECT");
        }
    }
}
