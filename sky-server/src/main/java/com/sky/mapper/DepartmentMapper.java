package com.sky.mapper;

import com.sky.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Select("select * from department where company_id = ${companyId}")
    List<Department> getDepartmentList(Long companyId);
}
