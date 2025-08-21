package com.leda.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Entity基类
 * 
 * @author frank
 */
@ApiModel
@Setter
@Getter
public class BaseEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

//    /** 搜索值 */
//    @JsonIgnore
//    @ApiModelProperty(hidden = true)
//    private String searchValue;

    /** 创建者 */
    @ApiModelProperty(hidden = true)
    private String createBy;

    /** 创建时间 */
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    @ApiModelProperty(hidden = true)
    private String updateBy;

    /** 更新时间 */
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

//    /** 备注 */
//    @ApiModelProperty(hidden = true)
//    private String remark;

}
