package com.atgx.mybatis.test;

import com.atgx.mybatis.mapper.DeptMapper;
import com.atgx.mybatis.mapper.EmpMapper;
import com.atgx.mybatis.pojo.Dept;
import com.atgx.mybatis.pojo.Emp;
import com.atgx.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {
    /**
     * 解决字段名和属性名不一致的情况：
     * a>为字段起别名，保持和属性名的一致
     * b>设置全局配置，将_自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * c>通过resultMap设置自定义的映射关系
     * <resultMap id="empResultMap" type="Emp">
     *     <id property="eid" column="eid"></id>
     *     <result property="empName" column="emp_name"></result>
     *     <result property="age" column="age"></result>
     *     <result property="sex" column="sex"></result>
     *     <result property="email" column="email"></result>
     * </resultMap>
     *
     * 处理多对一的映射关系：
     * a>级联属性赋值
     * b>association
     * c>分步查询
     *
     * 处理一对多的映射关系
     * a>collection
     * b>分步查询
     */

    @Test
    public void testgGetDeptAndEmp1(){ // 一对多
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(deptAndEmp.getDeptName());
        System.out.println(deptAndEmp.getEmps());
    }

    @Test
    public void testgGetDeptAndEmp(){ // 一对多
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmp(1);
        System.out.println(deptAndEmp);
    }

    @Test
    public void testGetEmpAndDept1(){ // 多对一
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDeptByStepOne(1);
        System.out.println(empAndDept);
    }

    @Test
    public void testGetEmpAndDept(){ // 多对一
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDept(1);
        System.out.println(empAndDept);
    }

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }
}
