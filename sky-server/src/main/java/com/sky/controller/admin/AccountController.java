package com.sky.controller.admin;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.RegisterDTO;
import com.sky.entity.Account;
import com.sky.properties.JwtProperties;
import com.sky.result.Result;
import com.sky.service.AccountService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private JwtProperties jwtProperties;



    /**
     * 登录
     *
     * @param employeeLoginDTO
     * @return
     */
    @PostMapping("/login")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        Account account = accountService.login(employeeLoginDTO);
        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.ACCOUNT_ID, account.getAccountId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(account.getId())
                .nickname(account.getNickname())
                .avatar(account.getAvatar())
                .accountId(account.getAccountId())
                .signature(account.getSignature())
                .token(token)
                .build();

        return Result.success(employeeLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }

    @PostMapping("/register")
    public  Result<String> register(@RequestBody RegisterDTO registerDTO){
        Account account = accountService.getByEmail(registerDTO.getEmail());
        log.info("employee{}",registerDTO);
        log.info("employee{}",account);
        if(account==null){
            accountService.register(registerDTO);
            return  Result.success("注册成功");
        }
        return Result.error("该邮箱已被注册");
    }
    @GetMapping("/list")
    public Result<List<Account>> getAccountList(){
        List<Account> accounts = accountService.getAccountList();
        return Result.success(accounts);
    }

}
