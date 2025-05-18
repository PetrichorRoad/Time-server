package com.sky.controller.admin;

import com.sky.context.BaseContext;
import com.sky.entity.Position;
import com.sky.entity.ProjectInfo;
import com.sky.result.Result;
import com.sky.service.PositionService;
import com.sky.service.ProjectService;
import com.sky.vo.ProjectInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/list")
    public Result<List<ProjectInfoVo>> getPositionList() {
        List<ProjectInfoVo> ProjectInfoVos = projectService.getProjectInfoVoById(BaseContext.getCurrentId());
        return Result.success(ProjectInfoVos);
    }
}
