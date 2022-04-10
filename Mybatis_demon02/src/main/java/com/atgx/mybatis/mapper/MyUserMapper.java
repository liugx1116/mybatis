package com.atgx.mybatis.mapper;

import com.atgx.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MyUserMapper {

    /**
     * 查询单个
     */
    User getUserById(String id);

    User checkUser(String id , String username);

    User checkUser1(@Param("id") String id , @Param("username") String username);

    /**
     * 查询用户信息的总记录数
     */
    Integer getCount();

    Map<String,Object> getMapUser(String id);

    @MapKey("id")
    Map<String,Object> getMapAllUser();

    List<Map<String,Object>> getMapAllUserList();
    /**
     * 验证登录（参数为map）
     */
    User checkLoginByMap(Map<String, Object> map);
    /**
     * 添加用户信息
     */
    int insertUser(User user);
}
