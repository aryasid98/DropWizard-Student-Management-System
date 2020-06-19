package com.flipkart.utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	//initialise
	private static Connection connection = null;
	
	
	//Connection Method
	public static Connection getConnection() {
		
        if (connection != null)
            return connection;
        else {
            try {
//            	Properties prop = new Properties();
//                InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("config.properties");
//                prop.load(inputStream);
                String driver = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/flipkart_db";
                String user = "root";
                String password ="root";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }


}
