package com.sky.entity;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Task {
    private Integer id;

    private Integer level = 0;

    private String title;

    private String content;
    //    附件
    private String attachment;

    //备注列表
    private String remarkList;
    //任务类型'任务类型(1:日常 2:项目 3:紧急)'
    private String type = "1";
//    '任务状态(1:待开始 2:进行中 3:已延期 4:已完成 5:已取消)'
    private String status = "1";

//    private Employee owner;
    private String ownerId;

    private Date startTime;

    private Date endTime;

    private String companyId;

    private Integer departmentId;


    private Integer teamId;

    private Integer progress = 0;

    private Date createTime;
    private Date updateTime;
}
