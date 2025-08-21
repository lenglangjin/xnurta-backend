package com.leda.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDateTime;

/**
 * 反馈实体类
 * 
 * @author claude
 */
@Getter
@Setter
@ApiModel("反馈")
@TableName("leda_feedback")
public class LedaFeedback extends BaseEntity {

    @ApiModelProperty(value = "反馈ID",hidden = true)
    private Long id;

    @ApiModelProperty(value = "反馈类型ID")
    private Integer feedBackTypeId;

    @ApiModelProperty(value = "反馈内容")
    private String content;

    @ApiModelProperty(value = "图片URL")
    private String imageUrl;

    @ApiModelProperty(value = "联系方式")
    private String contact;

} 