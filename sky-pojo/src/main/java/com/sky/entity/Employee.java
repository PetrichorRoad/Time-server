package com.sky.entity;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Employee {
    private Long id;
    public Long getId() {
        return id;
    }



    /**
     * 所属公司ID (外键关联company表)
     */
    private Integer companyId;

    /**
     * 所属部门ID (外键关联department表)
     */
    private Integer departmentId;

    /**
     * 所属小组ID (外键关联team表)
     */
    private Integer teamId;

    /**
     * 职位ID (外键关联position表)
     */
    private Integer positionId;

    /**
     * 员工编号 (同一公司下唯一)
     */
    private String employeeNo;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 性别 (0:未知,1:男,2:女)
     */
    private Gender gender = Gender.UNKNOWN;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 入职日期
     */
    private LocalDate joinDate;

    /**
     * 离职日期
     */
    private LocalDate leaveDate;

    /**
     * 状态 (0:离职,1:在职,2:休假)
     */
    private Status status = Status.ACTIVE;

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

    // ------------------ 枚举定义增强可读性 ------------------

    /**
     * 性别枚举
     */
    public enum Gender {
        UNKNOWN(0, "未知"),
        MALE(1, "男"),
        FEMALE(2, "女");

        private final int code;
        private final String desc;

        Gender(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public static Gender of(int code) {
            for (Gender gender : Gender.values()) {
                if (gender.code == code) return gender;
            }
            return UNKNOWN;
        }
    }

    /**
     * 员工状态枚举
     */
    public enum Status {
        INACTIVE(0, "离职"),
        ACTIVE(1, "在职"),
        LEAVE(2, "休假");

        private final int code;
        private final String desc;

        Status(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public static Status of(int code) {
            for (Status status : Status.values()) {
                if (status.code == code) return status;
            }
            return INACTIVE;
        }
    }

    // ------------------ 业务逻辑增强方法 ------------------

    /**
     * 判断员工是否在职
     */
    public boolean isActive() {
        return this.status == Status.ACTIVE;
    }

    /**
     * 手机号脱敏显示
     */
    public String getMaskedMobile() {
        if (this.mobile == null || this.mobile.length() != 11) return "";
        return this.mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    // ------------------ 关联对象（非数据库字段） ------------------

//    @TableField(exist = false)
    private Company company;        // 所属公司对象

//    @TableField(exist = false)
    private Department department;  // 所属部门对象

//    @TableField(exist = false)
    private Team team;              // 所属小组对象

//    @TableField(exist = false)
    private Position position;      // 职位对象
}
