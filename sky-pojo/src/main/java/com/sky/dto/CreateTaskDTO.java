package com.sky.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class CreateTaskDTO implements Serializable {
//    INSERT INTO `company_management_system`.`task` (`title`, `content`, `create_user`) VALUES ('测试', '测试', '123');
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("内容")
    private String content;
    @ApiModelProperty("密码")
    private String createUser;
    @ApiModelProperty("父级任务ID")
    private String parentId;
    @ApiModelProperty("等级")
    private String level;
    @ApiModelProperty("附件")
    private String attachment;
    @ApiModelProperty("父级任务ID")
    private String remarkList;
    @ApiModelProperty("任务类型")
    private String type;
    @ApiModelProperty("任务环节")
    private String status;
    @ApiModelProperty("负责人ID")
    private String ownerId;
    @ApiModelProperty("分给配给的部门")
    private String departmentId;
    @ApiModelProperty("分给配给的小组")
    private String teamId;
    @ApiModelProperty("当前环节进度")
    private String progress;
    @ApiModelProperty("开始时间")
    private String startTime;
    @ApiModelProperty("结束时间")
    private String endTime;
    @ApiModelProperty("任务id")
    private String id;
}
