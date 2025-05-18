package com.sky.mapper;

import com.sky.entity.ProjectMember;
import com.sky.vo.ProjectMemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectMemberMapper {
    @Select("SELECT  pm.*,a.account_id,a.nickname,a.avatar FROM  project_member pm JOIN `account` a ON pm.member_id = a.account_id WHERE  pm.project_id = 'KFXM2019001';")
    List<ProjectMemberVo> getProjectMembers(String projectId);
}
