package com.atgx.mybatis.test;

import com.atgx.mybatis.mapper.CashMapper;
import com.atgx.mybatis.pojo.Emp;
import com.atgx.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CashMapperTest {

    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CashMapper mapper = sqlSession.getMapper(CashMapper.class);
        Emp empByID = mapper.getEmpByID("1");
        System.out.println(empByID);
//        mapper.insertEmp(null);
        System.out.println("======");
        CashMapper mapper1 = sqlSession.getMapper(CashMapper.class);
        Emp empByID1 = mapper1.getEmpByID("1");
        System.out.println(empByID1);
    }
    @Test
    public void testGetEmpById1(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession(true);
            CashMapper mapper = sqlSession.getMapper(CashMapper.class);
            Emp empByID = mapper.getEmpByID("1");
            System.out.println(empByID);
//            mapper.insertEmp(null);
            sqlSession.close();
            System.out.println("======");

            SqlSession sqlSession1 = build.openSession(true);
            CashMapper mapper1 = sqlSession1.getMapper(CashMapper.class);
            Emp empByID1 = mapper1.getEmpByID("1");
            System.out.println(empByID1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
