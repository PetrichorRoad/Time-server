package com.sky.service.impl;

import com.sky.entity.Department;
import com.sky.mapper.AccountMapper;
import com.sky.mapper.DepartmentMapper;
import com.sky.service.AccountService;
import com.sky.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> departmentList(Long companyId) {
        return departmentMapper.getDepartmentList(companyId);
    }
}
