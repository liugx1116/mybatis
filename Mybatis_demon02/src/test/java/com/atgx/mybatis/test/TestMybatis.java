package com.atgx.mybatis.test;

import com.atgx.mybatis.mapper.UserMapper;
import com.atgx.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {


    @Test
    public void testCRUD(){

        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> allUser = userMapper.getAllUser();
            allUser.forEach(user-> System.out.println(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
