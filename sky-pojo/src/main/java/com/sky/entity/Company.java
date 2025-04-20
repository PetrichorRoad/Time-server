package com.sky.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class Company implements Serializable {
    private Long id;

    /**
     * 公司名称（非空）
     */
    private String name;

    /**
     * 公司编码（唯一标识）
     */
    private String code;

    /**
     * 公司LOGO地址（可选）
     */
    private String logo;

    /**
     * 公司描述（长文本）
     */
    private String description;

    /**
     * 状态（0:禁用，1:启用）
     */
//    private Status status = Status.ENABLED;

    /**
     * 创建时间（自动填充）
     */
    private LocalDateTime createTime;

    /**
     * 最后更新时间（自动填充）
     */
    private LocalDateTime updateTime;

    // ------------------ 增强功能配置 ------------------

    /**
     * 公司状态枚举（增强代码可读性）
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

        /**
         * 根据状态码获取枚举对象
         */
        public static Status of(int code) {
            for (Status status : Status.values()) {
                if (status.code == code) {
                    return status;
                }
            }
            throw new IllegalArgumentException("无效状态码");
        }
    }

    /**
     * 获取状态枚举描述（用于业务处理）
     */
//    public String getStatusDesc() {
//        return this.status.getDesc();
//    }
}
