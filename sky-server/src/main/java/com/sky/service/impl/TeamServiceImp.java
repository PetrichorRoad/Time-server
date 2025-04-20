package com.sky.service.impl;

import com.sky.entity.Team;
import com.sky.mapper.TeamMapper;
import com.sky.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamServiceImp implements TeamService {
    @Autowired
    private TeamMapper teamMapper;
    @Override
    public List<Team> getTeamList(Long departmentId) {
        return teamMapper.getTeamList(departmentId);
    }
}
