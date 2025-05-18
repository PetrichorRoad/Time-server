package com.sky.service;

import com.sky.entity.Position;
import com.sky.entity.ProjectInfo;
import com.sky.vo.ProjectInfoVo;

import java.util.List;

public interface ProjectService {
    List<ProjectInfoVo> getProjectInfoVoById(String accountId);
}
