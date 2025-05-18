package com.sky.vo;

//import com.sky.entity.ProjectMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberVo {
    private String projectId;

    private String memberId;

//    private ProjectMember.Role role = ProjectMember.Role.其他;

    private Boolean isPrimary = false;

    private Date joinTime;

    private Date leaveTime;

    private String avatar;

    private String nickname;
}
