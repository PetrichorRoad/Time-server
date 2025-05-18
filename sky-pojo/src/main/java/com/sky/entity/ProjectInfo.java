package com.sky.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class ProjectInfo {

    // 枚举定义
    public enum ProjectStatus { 进行中, 已结项, 暂停中 }
    public enum PriorityLevel { 高, 中, 低 }

    // 主键
    private String projectId;

    // 基础字段
    private String projectName;

    private ProjectStatus projectStatus = ProjectStatus.进行中;

    private String projectType;

    private String projectPhase;

    // 客户与部门
    private String clientName;


    private PriorityLevel priorityLevel = PriorityLevel.中;


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
}