package com.sky.entity;

//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Department {
    private Long id;

    /**
     * 所属公司ID (外键关联company表)
     */
    private Integer companyId;

    /**
     * 父部门ID (树形结构父节点，0表示根部门)
     */
    private Integer parentId;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门编码 (同一公司下唯一)
     */
    private String code;

    /**
     * 部门负责人ID (关联员工表)
     */
    private Integer managerId;

    /**
     * 排序号 (默认0)
     */
    private Integer orderNum = 0;

    /**
     * 状态 (0:禁用，1:启用)
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

    // ------------------ 增强功能配置 ------------------

    /**
     * 状态枚举 (增强代码可读性)
     */
    public enum Status {
        DISABLED(0, "禁用"),
        ENABLED(1, "启用");

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
            throw new IllegalArgumentException("无效状态码");
        }
    }

    /**
     * 获取状态描述 (业务层便捷方法)
     */
//    public String getStatusDesc() {
//        return this.status.getDesc();
//    }

    /**
     * 判断是否为根部门
     */
    public boolean isRootDepartment() {
        return parentId == null || parentId == 0;
    }
}
