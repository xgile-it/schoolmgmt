package org.schools.students.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;
import java.io.*;
public class DbUtil {
	private static Connection connection = null;

    public  Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                // System.out.println("File Loaded");

              /*  File file = new File(
                        getClass().getClassLoader().getResource("db.properties").getFile()
                );*/

                // System.out.println("File Loaded"+file.getName());

                // InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
                //    prop.load(inputStream);
                // System.out.println("File Loaded");
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/schoolmgmt";
                String user = "root";
                String password = "root";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                return connection;
            } catch (Exception e) {
                e.printStackTrace();

                return connection;
            }

        }
    }

        public static void main(String[]args){
            DbUtil dbu = new DbUtil();
            Connection connection= dbu.getConnection();
            System.out.println("DB Connection Created");
            String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
try {
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, "bill");
    statement.setString(2, "secretpass");
    statement.setString(3, "Bill Gates");
    statement.setString(4, "bill.gates@microsoft.com");
   int rowsInserted = statement.executeUpdate();
    if (rowsInserted > 0) {
        System.out.println("A new user was inserted successfully!");
    }
}
            catch(SQLException ex)
    {
             ex.printStackTrace();
    }
}
        }

