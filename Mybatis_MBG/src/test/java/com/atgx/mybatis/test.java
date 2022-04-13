package com.atgx.mybatis;

import com.atgx.mybatis.mapper.DeptMapper;
import com.atgx.mybatis.mapper.EmpMapper;
import com.atgx.mybatis.pojo.Dept;
import com.atgx.mybatis.pojo.Emp;
import com.atgx.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {

    @Test
    public void testEmp(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//            Dept dept = mapper.selectByPrimaryKey(1);
//            System.out.println(dept);
            EmpExample example = new EmpExample();
            example.createCriteria().andSexEqualTo("女").andAgeBetween(18,20);
            example.or().andAgeIsNotNull();
            List<Emp> list =  mapper.selectByExample(example);
            list.forEach(x-> System.out.println(x));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
