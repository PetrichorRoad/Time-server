package com.sky.vo;

import com.sky.entity.Team;
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
public class TeamVo implements Serializable {
    @ApiModelProperty("部门名")
    private String label;

    @ApiModelProperty("公司code")
    private Long code;
}
