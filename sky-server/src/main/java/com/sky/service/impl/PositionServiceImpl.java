package com.sky.service.impl;

import com.sky.entity.Position;
import com.sky.mapper.AccountMapper;
import com.sky.mapper.PositionMapper;
import com.sky.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;
    @Override
    public List<Position> getPositionList() {
        List<Position> positionList = positionMapper.getPosition();
        return positionList;
    }
}
