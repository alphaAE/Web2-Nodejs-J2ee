package com.alphaae.web.base;

import java.util.List;

public interface Dao<T> {
    int add(String sql, Object... args);

    int update(String sql, Object... args);

    int delete(String sql, Object... args);

    T queryForBean(String sql, Object... args);

    List<T> queryForList(String sql, Object... args);
}
