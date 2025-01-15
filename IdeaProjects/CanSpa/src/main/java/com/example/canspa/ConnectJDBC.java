package com.example.canspa;

import java.sql.Connection;

public class ConnectJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/QuanLyLichHen";
    private static final String USER = "root";
    private static final String PASS = "linhnhi234";
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return java.sql.DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
