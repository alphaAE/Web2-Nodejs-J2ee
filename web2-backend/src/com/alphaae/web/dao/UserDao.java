package com.alphaae.web.dao;

import com.alphaae.web.base.BaseDao;
import com.alphaae.web.entity.Msg;
import com.alphaae.web.entity.User;

import java.util.List;

public class UserDao extends BaseDao<User> {

    public Msg addUser(User user) {
        String sql = "INSERT INTO users (username,password,email) VALUES (?,?,?)";
        return initMsg(add(sql, user.getUsername(), user.getPassword(), user.getEmail()) >= 0);
    }

    public Msg delUser(User user) {
        String sql = "DELETE FROM users WHERE username=?";
        return initMsg(delete(sql, user.getUsername()) >= 0);
    }

    public Msg updateUser(User user) {
        String sql = "UPDATE users SET email=? WHERE username=?";
        return initMsg(delete(sql, user.getEmail(), user.getUsername()) >= 0);
    }

    public User findByUserName(String userName) {
        String sql = "SELECT * FROM users WHERE username=?";
        return queryForBean(sql, userName);
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return queryForList(sql, null);
    }

    private Msg initMsg(boolean is) {
        if (is) {
            return new Msg(200, "成功");
        } else {
            return new Msg(500, "失败");
        }
    }
}
