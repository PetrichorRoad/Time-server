package com.sky.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class RegisterDTO implements Serializable {
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("用户名")
    private String nickname;
    @ApiModelProperty("密码")
    private String password;

}
