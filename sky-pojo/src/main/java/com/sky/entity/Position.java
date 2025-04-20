package com.sky.entity;

//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Position implements Serializable {

    /**
     * 职位ID (自增主键)
     */
//    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属公司ID (外键关联company表)
     */
//    @TableField("company_id")
    private Integer companyId;

    /**
     * 职位名称
     */
//    @TableField("name")
    private String name;

    /**
     * 职位编码 (同一公司下唯一)
     */
//    @TableField("code")
    private String code;

    /**
     * 职级 (默认0)
     */
//    @TableField("level")
    private Integer level = 0;

    /**
     * 职位描述
     */
//    @TableField("description")
    private String description;

    /**
     * 状态 (0:禁用, 1:启用)
     */
//    @TableField("status")
    private Integer status = 1;

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

}
