package com.student.utils;

import java.sql.*;

public class DBManager {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String username = "root";
    private static final String pwd = "root";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet resultSet = null;
    static {
        try {
            Class.forName(driver);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(url, username, pwd);
            return conn;
        }
        return conn;
    }
}