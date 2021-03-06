package com.alphaae.web.base;

import com.alphaae.web.utils.MySQLUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.List;

public class BaseDao<T> implements Dao<T> {
    private Class<T> clazz;
    private Connection conn;

    public BaseDao() {
        try {
            //获取泛型的Class对象 T.class
            clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int add(String sql, Object... args) {
        return update(sql, args);
    }

    @Override
    public int update(String sql, Object... args) {
        try {
            conn = MySQLUtil.getConnection();
            assert conn != null;
            int line = new QueryRunner().update(conn, sql, args);
            MySQLUtil.close(conn);
            return line;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int delete(String sql, Object... args) {
        return update(sql, args);
    }

    @Override
    public T queryForBean(String sql, Object... args) {
        try {
            conn = MySQLUtil.getConnection();
            assert conn != null;
            List<T> list = new QueryRunner().query(conn, sql, new BeanListHandler<T>(clazz), args);
            MySQLUtil.close(conn);
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询出错");
        }
    }

    @Override
    public List<T> queryForList(String sql, Object... args) {
        try {
            conn = MySQLUtil.getConnection();
            assert conn != null;
            List<T> list = new QueryRunner().query(conn, sql, new BeanListHandler<T>(clazz), args);
            MySQLUtil.close(conn);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询出错");
        }
    }
}
