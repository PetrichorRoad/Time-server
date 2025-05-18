package com.sky.service.impl;

import com.sky.constant.MessageConstant;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.RegisterDTO;
import com.sky.entity.Account;
import com.sky.exception.AccountNotFoundException;
import com.sky.exception.PasswordErrorException;
import com.sky.mapper.AccountMapper;
import com.sky.properties.ShortIdGenerator;
import com.sky.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private ShortIdGenerator idGenerator;
    /**
     * 员工登录
     *
     * @param employeeLoginDTO
     * @return
     */
    public Account login(EmployeeLoginDTO employeeLoginDTO) {
        String email = employeeLoginDTO.getEmail();
        String password = employeeLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Account account = accountMapper.getByEmail(email);
//        Employee employee = employeeMapper.getByUsername(username);
//
        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (account == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        // TODO 后期需要进行md5加密，然后再进行比对
        if (!password.equals(account.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

//        if (!account.isEnabled()) {
//            //账号被锁定
//            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
//        }

        //3、返回实体对象
        return account;
    }

    public String register(RegisterDTO registerDTO){
        try {
            String id = idGenerator.generate();
            log.info("员工ID {}",id);
            accountMapper.insertAccount(registerDTO,id);
            return "注册成功";
        }catch (Exception e){
            return "注册失败";
        }
    }

    @Override
    public Account getByEmail(String email) {
        return accountMapper.getByEmail(email);
    }

    @Override
    public List<Account> getAccountList() {
        return accountMapper.getAccountList();
    }

}
