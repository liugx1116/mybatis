package com.atgx.mybatis.mapper;

import com.atgx.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CashMapper {
    /**
     * 根据eid查询单个数据
     * @param eid
     * @return
     */
    Emp getEmpByID(@Param("eid") String eid);

    void insertEmp(Emp emp);
}
