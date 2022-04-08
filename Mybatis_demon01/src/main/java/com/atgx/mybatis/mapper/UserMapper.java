package com.atgx.mybatis.mapper;

import com.atgx.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 添加用户
     * @return
     */
    int insertUser();

    /**
     * 查询单个用户
     */
    User getUserById();

    /**
     * 查询全部用户
     */
    List<User> getAllUser();
    /**
     * 删除
     */
    int deleteUserById();
}
