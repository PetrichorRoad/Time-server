package com.sky.mapper;

import com.sky.entity.ProjectInfo;
import com.sky.vo.ProjectInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectInfoMapper {
    @Select("SELECT \n" +
            "pm.*,\n" +
            "p.*\n" +
            "FROM \n" +
            "  `project_member` pm\n" +
            "JOIN `project_info` p ON pm.project_id = p.project_id\n" +
            "WHERE \n" +
            "  pm.member_id = #{memberId}")
    List<ProjectInfoVo> selectProjectsByMemberId(String memberId);

}
