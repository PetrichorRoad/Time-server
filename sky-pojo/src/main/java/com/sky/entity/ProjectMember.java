package com.sky.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProjectMember {

    // 联合主键类
//    @Data
//    public static class ProjectMemberId implements Serializable {
//        private String projectId;
//        private String memberId;
//    }

    // 角色枚举定义
    public enum Role {
        项目经理, 开发人员, 测试人员, 运维人员, 其他
    }

    // ================ 字段定义 ================ //

    private String projectId;

    private String memberId;

    private Role role = Role.其他;

    private Boolean isPrimary = false;

    private Date joinTime;

    private Date leaveTime;
}