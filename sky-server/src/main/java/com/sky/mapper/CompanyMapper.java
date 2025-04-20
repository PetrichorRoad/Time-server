package com.sky.mapper;

import com.sky.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface CompanyMapper {
    @Select("select * from company where id = #{id}")
    Company getById(Long id);
}
