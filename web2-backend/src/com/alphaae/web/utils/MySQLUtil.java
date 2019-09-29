package com.alphaae.web.utils;

import java.sql.*;

public class MySQLUtil {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://alphaae.com:3306/testdb";

    private static final String USER = "stu";
    private static final String PASS = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        } catch (Exception e) {
            // 处理 JDBC 错误 & Class.forName 错误
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Connection conn) {
        if (conn != null) {//oop
            try {
                conn.close();//pool.add(conn)
            } catch (SQLException e) {
                throw new RuntimeException("关闭异常");
            }
        }
    }

}
