package com.atgx.mybatis.mapper;

import com.atgx.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SqlMapper {

    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("username") String username);
    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    int insertUser(User user);

    List<User> getUserTableName(@Param("tableName")String tableName);
}
