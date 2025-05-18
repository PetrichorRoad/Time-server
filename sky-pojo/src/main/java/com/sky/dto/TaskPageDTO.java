package com.sky.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class TaskPageDTO implements Serializable {
    @ApiModelProperty("页号")
    private int pageNum;

    @ApiModelProperty("页码")
    private int pageSize;

    @ApiModelProperty("起始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

    @ApiModelProperty("部门id")
    private Long departmentId;

    @ApiModelProperty("负责人Id")
    private Long ownerId;

    @ApiModelProperty("搜索关键字")
    private String keyword;
}
