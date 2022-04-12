package com.atgx.mybatis.mapper;

import com.atgx.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 查询所有的员工信息
     */
    List<Emp> getAllEmp();

    /**
     * 查询员工以及员工对应部门信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分步查询查询员工以及员工所对应部门信息
     * 分步查询第一步： 查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid")Integer eid);

    /**
     * 通过分步查询查询部门中所有员工信息
     * 分步查询第二步： 根据did查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did")Integer did);


}
