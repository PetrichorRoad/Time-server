package com.sky.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "员工登录返回的数据格式")
public class EmployeeLoginVO implements Serializable {

    @ApiModelProperty("主键值")
    private Long id;

    @ApiModelProperty("员工ID")
    private String accountId;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("签名")
    private String signature;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("jwt令牌")
    private String token;

}
