package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {
	
	private static Connection con = null;
    static
    {
    	ResourceBundle resourceBundle = ResourceBundle.getBundle("config"); 
        String url = resourceBundle.getString("dburl");
        String user = resourceBundle.getString("username");
        String pass = resourceBundle.getString("password");
        String driver = resourceBundle.getString("driver");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }

}
