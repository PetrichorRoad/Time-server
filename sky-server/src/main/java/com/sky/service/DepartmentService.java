package com.sky.service;

import com.sky.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> departmentList(Long companyId);
}
