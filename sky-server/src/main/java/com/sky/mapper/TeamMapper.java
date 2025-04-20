package com.sky.mapper;
import com.sky.entity.Department;
import com.sky.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeamMapper {
    @Select("select * from team where department_id = ${departmentId}")
    List<Team> getTeamList(Long departmentId);


}
