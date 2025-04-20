package com.sky.controller.admin;

import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Position;
import com.sky.result.Result;
import com.sky.service.AccountService;
import com.sky.service.PositionService;
import com.sky.vo.EmployeeLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @GetMapping("/list")
    public Result<List<Position>> getPositionList() {
        List<Position> positionList = positionService.getPositionList();
        return Result.success(positionList);
    }
}
