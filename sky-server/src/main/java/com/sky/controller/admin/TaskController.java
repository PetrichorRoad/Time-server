package com.sky.controller.admin;

//import com.sky.dto.CreateTaskDTO;
import com.sky.context.BaseContext;
import com.sky.dto.CreateTaskDTO;
import com.sky.dto.TaskPageDTO;
import com.sky.entity.Task;
import com.sky.mapper.CompanyMapper;
import com.sky.mapper.TaskMapper;
import com.sky.result.Result;
import com.sky.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/list")
    public Result<List<Task>> getTaskList(@RequestBody TaskPageDTO taskPageDTO){
        log.info("参数 {}" , taskPageDTO);
        List<Task> taskList = taskService.list(taskPageDTO);
        return  Result.success(taskList);
    }
    @GetMapping("/detail")
    private Result<Task> getTask(String id){
        Task task = taskService.getTask(id);
        return  Result.success(task);
    }

    @PostMapping("/create")
    private Result<String> createTask(@RequestBody CreateTaskDTO createTaskDTO){
        createTaskDTO.setCreateUser(BaseContext.getCurrentId());
        log.info("createTaskDTO{}",createTaskDTO.getParentId());
        Boolean result = taskService.createTask(createTaskDTO);
        if(result){
            return Result.success("任务创建成功");
        }else{
            return Result.error("任务创建失败");
        }
    }
    @PostMapping("/update")
    private Result<String> updateTask(@RequestBody CreateTaskDTO createTaskDTO){
        log.info("createTaskDTO{}",createTaskDTO);
        Boolean result = taskService.updateTask(createTaskDTO);
        if(result){
            return Result.success("任务更新成功");
        }else{
            return Result.error("任务更新失败");
        }
    }
}
