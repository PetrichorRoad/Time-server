package com.sky.vo;

import com.sky.entity.Task;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskTreeOv extends Task {
    @ApiModelProperty("部门名")
    private List<Task> children;
}
