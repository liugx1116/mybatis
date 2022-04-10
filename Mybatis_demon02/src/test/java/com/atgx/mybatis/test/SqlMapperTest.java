package com.atgx.mybatis.test;

import com.atgx.mybatis.mapper.SqlMapper;
import com.atgx.mybatis.pojo.User;
import com.atgx.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SqlMapperTest {

    @Test
    public void testTableNamer(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> myuserList = mapper.getUserTableName("myuser");
        myuserList.forEach(user -> System.out.println(user));
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        User user = new User(null, "王五3", "123", 23, "男", "123@163.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
    //deleteMore
    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        int i = mapper.deleteMore("1,2");
        System.out.println("删除行数"+i);
    }

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> userByLike = mapper.getUserByLike("张");
        System.out.println(userByLike);
    }
}
