package com.leda.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @desc
 * @auth Frank
 * @date 2024/12/10 9:23
 */
@Data
public class QueryMyApplyDTO {
    @ApiModelProperty(value = "活动状态： 2进行中  3已结束", example = "3")
    private Integer status;
}
