package com.atgx.mybatis.test;

import com.atgx.mybatis.mapper.MyUserMapper;
import com.atgx.mybatis.pojo.User;
import com.atgx.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyUser {

    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        if(null == sqlSession){
            return;
        }
        MyUserMapper mapper = sqlSession.getMapper(MyUserMapper.class);
        // (null,#{username},#{password},#{age},#{sex},#{email})
        int i = mapper.insertUser(new User(null, "大飞", "123", 18, "男", "1232@qq.com"));
        System.out.println("插入行数"+i);
    }
    @Test
    public void checkLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        if(null == sqlSession){
            return;
        }

        MyUserMapper mapper = sqlSession.getMapper(MyUserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id","15");
        map.put("username","张三");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public void  getUserMapList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        if(null == sqlSession){
            return;
        }

        MyUserMapper mapper = sqlSession.getMapper(MyUserMapper.class);
        List<Map<String, Object>> mapUser = mapper.getMapAllUserList();
        System.out.println(mapUser);
    }
    @Test
    public void  getUserMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        if(null == sqlSession){
            return;
        }

        MyUserMapper mapper = sqlSession.getMapper(MyUserMapper.class);
        Map<String, Object> mapUser = mapper.getMapAllUser();
        System.out.println(mapUser);
    }

    @Test
    public void  getUserMapById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        if(null == sqlSession){
            return;
        }

        MyUserMapper mapper = sqlSession.getMapper(MyUserMapper.class);
        Map<String, Object> mapUser = mapper.getMapUser("15");
        System.out.println(mapUser);
    }
    @Test
    public void  getCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        if(null == sqlSession){
            return;
        }

        MyUserMapper mapper = sqlSession.getMapper(MyUserMapper.class);
        int count = mapper.getCount();
        System.out.println(count);
    }
    @Test
    public void  getUser1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        if(null == sqlSession){
            return;
        }
        MyUserMapper mapper = sqlSession.getMapper(MyUserMapper.class);
        User user = mapper.checkUser1("15","张三");
        System.out.println(user);
    }
    @Test
    public void  getUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        if(null == sqlSession){
            return;
        }
        MyUserMapper mapper = sqlSession.getMapper(MyUserMapper.class);
        User user = mapper.checkUser("15","张三");
        System.out.println(user);
    }

    @Test
    public void  getUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        if(null == sqlSession){
            return;
        }
        MyUserMapper mapper = sqlSession.getMapper(MyUserMapper.class);
        User user = mapper.getUserById("1");
        System.out.println(user);
    }
}
