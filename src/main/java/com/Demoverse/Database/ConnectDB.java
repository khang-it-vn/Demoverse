package com.Demoverse.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public ConnectDB(){
        super();
    }
    public static Connection getConnect(){
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=demoverse;user=sa;password=abc@123;useUnicode=true;characterEncoding=UTF-8");
            System.out.println("Kết nối thành công!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Kết nối thất bại!"+e.getMessage());
        }
        return connection;
    }

}
