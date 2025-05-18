package com.sky.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Account {

    private Long id;


    /**
     * 用户名 (唯一)
     */
    private String nickname;

    /**
     * 加密后的密码
     */
    private String password;


    /**
     * 头像URL
     */
    private String avatar;



    /**
     * 个性签名
     */
    private String signature;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

//  /**
//     * 邮箱
//     */
    private String email;

    /**
     * 账号状态 (0:禁用,1:启用)
     */
//    private Status status = Status.ENABLED;

    private String accountId;
    /**
     * 创建时间 (自动填充)
     */
//    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间 (自动填充)
     */
//    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    // ------------------ 枚举定义 ------------------

    /**
     * 账号状态枚举
     */
    public enum Status {
        DISABLED("0", "禁用"),
        ENABLED("1", "启用");

        private final String code;
        private final String desc;

        Status(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public static Status of(int code) {
            for (Status status : Status.values()) {
                if (status.code.equals(code)) return status;
            }
            return DISABLED;
        }
    }

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

    // ------------------ 关联对象 ------------------

//    @TableField(exist = false)
    private Employee employee; // 关联员工对象

//    private String projectId;
}
