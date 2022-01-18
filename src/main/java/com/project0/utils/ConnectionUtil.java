package com.project0.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        // jdbc:postgresql://[AWS Endpoint]:/[port#]/[database name]
        String url = "jdbc:postgresql://javafs220103.ciaghenqdjig.us-east-1.rds.amazonaws.com:5432/project0";
        String username = "postgres";
        String password = "password";

        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args){

        try{
            getConnection();
            System.out.println("Connection successful");
        }catch (SQLException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}
