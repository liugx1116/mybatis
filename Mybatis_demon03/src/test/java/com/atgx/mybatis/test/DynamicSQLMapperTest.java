package com.atgx.mybatis.test;

import com.atgx.mybatis.mapper.DynamicSQLMapper;
import com.atgx.mybatis.pojo.Emp;
import com.atgx.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {

    @Test
    public void testInsertMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "嘿哈1", 23, "男", "123@qq.com", null);
        Emp emp2 = new Emp(null, "嘿哈2", 23, "男", "123@qq.com", null);
        Emp emp3 = new Emp(null, "嘿哈3", 23, "男", "123@qq.com", null);
        Emp emp4 = new Emp(null, "嘿哈4", 23, "男", "123@qq.com", null);
        Emp emp5 = new Emp(null, "嘿哈5", 23, "男", "123@qq.com", null);
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3, emp4, emp5);
        Integer result = mapper.insertMore(emps);
        System.out.println("插入数据结果"+result);
    }
    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer integer = mapper.deleteMore(new Integer[]{12,13});
        System.out.println("删除行数"+integer);
    }
    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByCondition = mapper.getEmpByChoose(new Emp(null, "", null, "女", "123@qq.com", null));
        empByCondition.forEach(emp -> System.out.println(emp));
    }

    @Test
    public  void testSelectEmp1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByCondition = mapper.getEmpByCondition(new Emp(null, "张三", null, "女", "123@qq.com", null));

        empByCondition.forEach(emp-> System.out.println(emp));
    }
}
