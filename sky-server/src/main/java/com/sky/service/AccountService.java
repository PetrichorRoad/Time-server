package com.sky.service;

import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.RegisterDTO;
import com.sky.entity.Account;

import java.util.List;

public interface AccountService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Account login(EmployeeLoginDTO employeeLoginDTO);

    String register(RegisterDTO registerDTO);

    Account getByEmail(String email);

    List<Account> getAccountList();
}
