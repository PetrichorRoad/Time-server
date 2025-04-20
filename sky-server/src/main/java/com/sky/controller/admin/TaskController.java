package com.sky.controller.admin;

import com.sky.entity.Task;
import com.sky.mapper.CompanyMapper;
import com.sky.mapper.TaskMapper;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {
    @Autowired
    private TaskMapper taskMapper;
    @GetMapping("/list")
    public Result<List<Task>> getTaskList(String startTime,String endTime,String address){
        List<Task> taskList = taskMapper.list(startTime,endTime,address);
        return  Result.success(taskList);
    }
    @GetMapping("/detail")
    private Result<Task> getTask(String queryParams){
        Task task = taskMapper.getTask(queryParams);
        return  Result.success(task);
    }
}
