package com.sky.controller.admin;

import com.sky.entity.Company;
import com.sky.entity.Department;
import com.sky.entity.Position;
import com.sky.entity.Team;
import com.sky.mapper.CompanyMapper;
import com.sky.mapper.DepartmentMapper;
import com.sky.mapper.TeamMapper;
import com.sky.result.Result;
import com.sky.vo.DepartmentVo;
import com.sky.vo.OrganizationVo;
import com.sky.vo.TeamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/organization")
@Slf4j
public class OrganizationController {
//    @Autowired
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private TeamMapper teamMapper;

    @GetMapping("/tree")
    public Result<OrganizationVo> getPositionList(Long companyId) {
        Company company = companyMapper.getById(companyId);
        List<Department> departmentList = departmentMapper.getDepartmentList(company.getId());

        List<DepartmentVo> departmentVoList = new ArrayList<>();
        departmentList.forEach((item) ->{
            List<Team> teamList = teamMapper.getTeamList(item.getId());
            List<TeamVo> teamVoList = new ArrayList<>();
            for (Team team : teamList){
                TeamVo teamVo =TeamVo.builder()
                        .label(team.getName())
                        .value(team.getId())
                        .build();
                teamVoList.add(teamVo);
            };
            DepartmentVo departmentVo = DepartmentVo.builder()
                    .label(item.getName())
                    .value(item.getId())
                    .children(teamVoList)
                    .build();
            departmentVoList.add(departmentVo);
        });

        OrganizationVo organizationVo = OrganizationVo.builder()
                .label(company.getName())
                .value(company.getId())
                .logo(company.getLogo())
                .description(company.getDescription())
                .children(departmentVoList)
                .build();
        return Result.success(organizationVo);
    }


}
