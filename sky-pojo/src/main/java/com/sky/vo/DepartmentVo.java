package com.sky.vo;

import com.sky.entity.Team;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentVo implements Serializable {
    @ApiModelProperty("部门名")
    private String label;

    @ApiModelProperty("公司code")
    private Long code;

    @ApiModelProperty("公司logo")
    private String depId;

    @ApiModelProperty("团队列表")
    private List<TeamVo> children;
}
