package com.alphaae.web.utils;

import java.sql.*;

public class MySQLUtil {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_DRIVER_NEW = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";

    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER_NEW);
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
