package com.Demoverse.Database;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/ok"})
public class ConnectDB extends HttpServlet {
    public ConnectDB() {
        super();
    }

    public static Connection getConnect() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=demoverse;integratedSecurity=true;encrypt=false;";
        String name = "sa";
        String password = "abc@123";
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection =  DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            System.out.println("jdsfhjkdsfsd" + e.toString());

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = getConnect();
        System.out.println("jsdgfhds");
    }
}
