package com.leda.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 反馈类型实体类
 * 
 * @author claude
 */
@Getter
@Setter
@TableName("leda_feedback_type")
@ApiModel("反馈类型")
public class LedaFeedbackType extends BaseEntity {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "反馈类型ID")
    private Long id;

    @ApiModelProperty(value = "反馈类型描述")
    private String typeDescription;
} 