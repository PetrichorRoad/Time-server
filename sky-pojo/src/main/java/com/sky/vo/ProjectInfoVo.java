package com.sky.vo;

import com.sky.entity.ProjectInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfoVo {
    public enum ProjectStatus { 进行中, 已结项, 暂停中 }
    public enum PriorityLevel { 高, 中, 低 }

    // 主键
    private String projectId;

    // 基础字段
    private String projectName;

    private ProjectInfo.ProjectStatus projectStatus = ProjectInfo.ProjectStatus.进行中;

    private String projectType;

    private String projectPhase;

    // 客户与部门
    private String clientName;


    private ProjectInfo.PriorityLevel priorityLevel = ProjectInfo.PriorityLevel.中;


    private String deliveryDept;

    // 金额与时间

    private BigDecimal projectBudget;


    private Date planStartDate;


    private Date planEndDate;


    private Date actualStartDate;


    private Date actualEndDate;

    // 工时

    private Integer plannedHours;


    private Integer actualHours;

    // 人员信息

    private String projectManager;


    private String projectSupervisor;


    private String creator;


    private String creatorDept;

    // 时间与描述

    private Date createTime;


    private Date organizationTime;

    private String projectDescription;

    private List<ProjectMemberVo> projectMemberVoList;
}
