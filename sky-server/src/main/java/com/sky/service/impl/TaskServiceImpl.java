package com.sky.service.impl;

import com.alibaba.fastjson.JSON;
import com.sky.dto.CreateTaskDTO;
import com.sky.dto.TaskPageDTO;
import com.sky.entity.Task;
import com.sky.mapper.AccountMapper;
import com.sky.mapper.TaskMapper;
import com.sky.service.TaskService;
import com.sky.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private WebSocketServer webSocketServer;

    public void sendNoticeToCreatUser(CreateTaskDTO createTaskDTO,int type){
        Map map = new HashMap();
        //(3)完成任务,(2)转换责任人
        String pattern = "任务 ：{0} 已完成";
        String content = MessageFormat.format(pattern,createTaskDTO.getTitle());
        map.put("type",type);
        map.put("ownerId",createTaskDTO.getCreateUser());
        map.put("content",content);
        String json = JSON.toJSONString(map);
        webSocketServer.sendToClient(createTaskDTO.getCreateUser(),json);
    }
    public void sendNoticeToOwnerUser(CreateTaskDTO createTaskDTO,int type){
        Map map = new HashMap();
        //(3)完成任务,(2)转换责任人
        String pattern = "任务 ：{0} 已分给你";
        String content = MessageFormat.format(pattern,createTaskDTO.getTitle());
        map.put("type",type);
        map.put("ownerId",createTaskDTO.getOwnerId());
        map.put("content",content);
        String json = JSON.toJSONString(map);
        webSocketServer.sendToClient(createTaskDTO.getOwnerId(),json);
    }
    @Override
    public List<Task> list(TaskPageDTO taskPageDTO) {
        return taskMapper.list(taskPageDTO);
    }

    @Override
    public Task getTask(String id) {
        return taskMapper.getTask(id);
    }

    @Override
    public Boolean createTask(CreateTaskDTO createTaskDTO) {
        return taskMapper.createTask(createTaskDTO);
    }

    @Override
    public Boolean updateTask(CreateTaskDTO createTaskDTO) {
        String status = createTaskDTO.getStatus();

        if(status == "3"){
            sendNoticeToCreatUser(createTaskDTO,3);
        }else{
            sendNoticeToOwnerUser(createTaskDTO,2);
        }
        return taskMapper.updateTask(createTaskDTO);
    }
}
