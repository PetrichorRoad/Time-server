package com.sky.service.impl;

import com.sky.entity.ProjectInfo;
import com.sky.entity.ProjectMember;
import com.sky.mapper.ProjectInfoMapper;
import com.sky.mapper.ProjectMemberMapper;
import com.sky.service.ProjectService;
import com.sky.vo.ProjectInfoVo;
import com.sky.vo.ProjectMemberVo;
import com.sky.vo.TeamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectInfoMapper projectInfoMapper;
    @Autowired
    private ProjectMemberMapper projectMemberMapper;
    @Override
    public List<ProjectInfoVo> getProjectInfoVoById(String accountId) {
        List<ProjectInfoVo> projectInfoList = projectInfoMapper.selectProjectsByMemberId(accountId);
        for (ProjectInfoVo item : projectInfoList){
            List<ProjectMemberVo> projectMemberVos = projectMemberMapper.getProjectMembers(item.getProjectId());
            item.setProjectMemberVoList(projectMemberVos);
        }

        return projectInfoList;
    }
}
