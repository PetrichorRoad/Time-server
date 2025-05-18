package com.sky.mapper;

//import com.sky.dto.CreateTaskDTO;
import com.sky.dto.CreateTaskDTO;
import com.sky.dto.TaskPageDTO;
import com.sky.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {
    List<Task> list(TaskPageDTO taskPageDTO);


    @Select("SELECT * FROM task WHERE id = #{id}")
    Task getTask(String id);

//    @Insert("insert into task (`title`, `content`, `create_user`,`department_id`,`team_id`,`owner_id`,`parent_id`) VALUES (#{dto.title}, #{dto.content},  #{dto.createUser},  #{dto.departmentId},#{dto.teamId},#{dto.ownerId},#{dto.parentId})")
    Boolean createTask(@Param("dto") CreateTaskDTO createTaskDTO);
//    @Update("UPDATE `company_management_system`.`task` SET `parent_id` = '2', `level` = '1', `type` = '2', `status` = '2', `owner_id` = '7', `start_time` = '2024-04-01 10:00:00', `end_time` = '2024-05-30 18:00:00', `company_id` = '1', `department_id` = '2', `team_id` = '2', `progress` = '22' WHERE (`id` = '6');")
    Boolean updateTask(@Param("dto") CreateTaskDTO createTaskDTO);

    @Select("SELECT * FROM task where owner_id = #{id} and end_time < CURRENT_TIMESTAMP")
    List<Task> exceededList(String id,String endTime);
}
