package com.sky.entity;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Account {
    public Long getId() {
        return id;
    }

    private Long id;

    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * 关联员工ID (外键关联employee表)
     */
    private Long employeeId;

    /**
     * 用户名 (唯一)
     */
    private String username;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    /**
     * 加密后的密码
     */
    private String password;

    /**
     * 加密盐值
     */
    private String salt;

    public String getAvatar() {
        return avatar;
    }

    /**
     * 头像URL
     */
    private String avatar;

    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

//    public Status getStatus() {
//        return status;
//    }

    /**
     * 账号状态 (0:禁用,1:启用)
     */
//    private Status status = Status.ENABLED;

    /**
     * 创建时间 (自动填充)
     */
//    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间 (自动填充)
     */
//    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    // ------------------ 枚举定义 ------------------

    /**
     * 账号状态枚举
     */
//    public enum Status {
//        DISABLED(0, "禁用"),
//        ENABLED(1, "启用");
//
//        private final int code;
//        private final String desc;
//
//        Status(int code, String desc) {
//            this.code = code;
//            this.desc = desc;
//        }
//
//        public int getCode() {
//            return code;
//        }
//
//        public String getDesc() {
//            return desc;
//        }
//
//        public static Status of(int code) {
//            for (Status status : Status.values()) {
//                if (status.code == code) return status;
//            }
//            return DISABLED;
//        }
//    }

    // ------------------ 业务方法 ------------------

    /**
     * 判断账号是否启用
     */
//    public boolean isEnabled() {
//        return this.status == Status.ENABLED;
//    }

    /**
     * 获取脱敏用户名 (前3位 + *** + 后2位)
     */
    public String getMaskedUsername() {
        if (username == null || username.length() < 5) return username;
        return username.substring(0, 3) + "***" + username.substring(username.length() - 2);
    }

    // ------------------ 关联对象 ------------------

//    @TableField(exist = false)
    private Employee employee; // 关联员工对象
}
