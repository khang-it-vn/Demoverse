package com.Demoverse.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlockList {
    private String email;
    private String email_blocked;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_blocked() {
        return email_blocked;
    }

    public void setEmail_blocked(String email_blocked) {
        this.email_blocked = email_blocked;
    }

    public BlockList(String email, String email_blocked) {
        this.email = email;
        this.email_blocked = email_blocked;
    }
    public BlockList()
    {
        super();
    }

    public void cast(ResultSet resultSet) throws SQLException {
        while (resultSet.next())
        {
            this.email = resultSet.getString("EMAIL");
            this.email_blocked = resultSet.getString("EMAIL_BLOCKED");
        }
    }
}
