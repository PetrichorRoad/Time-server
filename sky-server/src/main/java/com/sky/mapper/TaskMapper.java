package com.sky.mapper;

import com.sky.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskMapper {
//    @Select("<script>" +
//            "SELECT * FROM task start_time >= '${startTime}'  AND end_time <= '${endTime}' " +
//            "<if test='address != null'> AND address = #{address} </if> " +
//            "</script>")

    //    @Select("SELECT * FROM task WHERE start_time >= '${startTime}'  AND end_time <= '${endTime}'")
//    @Select("<script> <![CDATA[  select * from task where start_time >= ${startTime}  and end_time <= ${endTime} <if test='departmentId !=null'> and department_id = ${departmentId} </if>  ]]> </script>")
    List<Task> list(String startTime,String endTime,String departmentId);


    @Select("SELECT * FROM task WHERE id = #{id}")
    Task getTask(String id);
}
