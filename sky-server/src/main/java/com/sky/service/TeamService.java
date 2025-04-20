package com.sky.service;

import com.sky.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> getTeamList(Long departmentId);
}
