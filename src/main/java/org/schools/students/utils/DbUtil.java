package org.schools.students.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Date;
import java.util.*;
import java.io.*;

public class DbUtil {
	private static Connection connection = null;
    public void createTable(String query)
    {

    }

    public void insertData(String query)
    {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            //Date date = new Date();
            String str="2018-03-31";
            Date date=Date.valueOf(str);
            statement.setInt(1,12345);
            statement.setString(2, "Evaan");
            statement.setString(3, "Singh");
            statement.setDate(4, date);
            statement.setString(5, "G2");
            statement.setString(6, "Randburg");
            statement.setString(7, "0744828778");

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


    public void selectData(String query)
    {

    }

    public void updateData(String query)
    {

    }
    public  Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {

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
            String query = "INSERT INTO schoolmgmt.students(studentNumber, fname, lname, dob,grade,address,parentsContacts) VALUES (?, ?, ?, ?, ?,?,?)";

            dbu.insertData(query);
}
        }

