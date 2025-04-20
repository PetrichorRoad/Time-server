package com.sky.service;

import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Account;

public interface AccountService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Account login(EmployeeLoginDTO employeeLoginDTO);

}
