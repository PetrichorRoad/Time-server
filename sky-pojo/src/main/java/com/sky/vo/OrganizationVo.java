package com.sky.vo;
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
public class OrganizationVo implements Serializable {
    @ApiModelProperty("公司名")
    private String label;

    @ApiModelProperty("公司code")
    private Long value;

    @ApiModelProperty("公司logo")
    private String logo;

    @ApiModelProperty("签名")
    private String description;

    @ApiModelProperty("部门列表")
    private List<DepartmentVo> children;


}
