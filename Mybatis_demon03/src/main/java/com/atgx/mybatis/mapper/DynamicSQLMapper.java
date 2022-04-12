package com.atgx.mybatis.mapper;

import com.atgx.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {

    /**
     * 多条件查询
     */
    List<Emp> getEmpByCondition(Emp emp);

    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 批量删除
     * @return
     */
    Integer deleteMore(@Param("eids") Integer[] eids);

    /**
     * 批量添加
     */
    Integer insertMore(@Param("emps") List<Emp> emps);
}
