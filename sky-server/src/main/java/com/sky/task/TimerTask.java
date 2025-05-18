package com.sky.task;

import com.sky.entity.Task;
import com.sky.mapper.TaskMapper;
import com.sky.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class TimerTask {
    @Autowired
    private TaskMapper taskMapper;
//    @Scheduled(cron = "0/5 * * * * *")
//    public void executeTask(){
//        List<Task> taskList = taskMapper.exceededList("1hSYn21quJCLYYTVa9QGLoS8hA","1213");
//        if(taskList != null && taskList.size()> 0){
//            for (Task task : taskList){
//                log.info("任务超时 {}",task.getTitle());
//            }
//        }
//    }
}
