package com.atgx.mybatis.mapper;

import com.atgx.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 查询
     */
    List<User> getAllUser();
}
