package com.alphaae.web.dao;

import com.alphaae.web.base.BaseDao;
import com.alphaae.web.entity.User;

import java.util.List;

public class UserDao extends BaseDao<User> {

    public List<User> getAllUsers() {
        String sql = "select * from users";
        return queryForList(sql, null);
    }

}
