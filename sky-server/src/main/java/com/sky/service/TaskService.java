package com.sky.service;

import com.sky.dto.CreateTaskDTO;
import com.sky.dto.TaskPageDTO;
import com.sky.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> list(TaskPageDTO taskPageDTO);
    Task getTask(String id);

    Boolean createTask(CreateTaskDTO createTaskDTO);

    Boolean updateTask(CreateTaskDTO createTaskDTO);
}
