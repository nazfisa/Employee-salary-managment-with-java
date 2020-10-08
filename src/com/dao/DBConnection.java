package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        String url= "jdbc:mysql://localhost:3306/employee_salary?useSSL=false&serverTimezone=UTC";
        String user="asifRcode";
        String password="asifRcode";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url, user, password);
            System.out.println("Database connected...");
        }catch(Exception e) {
            System.out.println(e);
        }

        return con;
    }
}
