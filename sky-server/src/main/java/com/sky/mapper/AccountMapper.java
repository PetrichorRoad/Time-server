package com.sky.mapper;

import com.sky.dto.RegisterDTO;
import com.sky.entity.Account;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountMapper {

    /**
     * 根据用户名查询员工
     * @param email
     * @return
     */
//    @Select("select * from account where email = #{email}")
//    Account getByUsername(String email);

    @Select("select * from account where email = #{email}")
    Account getByEmail(String email);
    @Insert("insert into account (`password`, `nickname`, `email`, `account_id`) VALUES (#{dto.password}, #{dto.nickname}, #{dto.email}, #{accountId})")
    Boolean insertAccount(@Param("dto")RegisterDTO registerDTO, @Param("accountId")String accountId);
    @Select("select * from account")
    List<Account> getAccountList();

//    @Select("select nickname,avatar from account where account_id = #{accountId}")
//    Account getById(String accountId);
}
