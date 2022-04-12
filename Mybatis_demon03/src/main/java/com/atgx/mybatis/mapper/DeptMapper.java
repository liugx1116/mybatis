package com.atgx.mybatis.mapper;

import com.atgx.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 通过分步查询查询员工以及员工所对应的部门信息
     * 分步查询第二步：通过did查询员工所对应的部门
     */

    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    Dept getDeptAndEmp(@Param("did") Integer did);
    /**
     * 通过分步查询查询部门以及部门中所有的员工信息
     * 分步查询第一步：查询部门信息
     * @param did
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
