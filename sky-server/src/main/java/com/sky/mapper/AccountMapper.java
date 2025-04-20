package com.sky.mapper;

import com.sky.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from account where username = #{username}")
    Account getByUsername(String username);

}
