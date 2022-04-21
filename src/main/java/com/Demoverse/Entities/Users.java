package com.Demoverse.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {
    private String email;
    private String username;
    private String pass;
    private String introduce;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Users(String email, String username, String pass, String introduce) {
        this.email = email;
        this.username = username;
        this.pass = pass;
        this.introduce = introduce;
    }

    public Users()
    {
        super();
    }


}
