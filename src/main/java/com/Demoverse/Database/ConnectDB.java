package com.Demoverse.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB{
    public ConnectDB() {
        super();
    }
    public static Connection getConnect() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=demoverse;integratedSecurity=false;encrypt=false;";
        String name = "sa";
        String password = "abc@123";
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection =  DriverManager.getConnection(url, name, password);
            if(connection != null)
            {
                System.out.println("Connected!");
            }
        } catch (Exception e) {
            System.out.println("Connect Failed with Error: " + e.toString());
            return null;
        }
        return connection;
    }
}