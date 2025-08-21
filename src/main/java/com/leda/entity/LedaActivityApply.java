package com.leda.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动用户对象 leda_activity_user
 * 
 * @author frank
 * @date 2024-11-16
 */
@Data
@TableName("leda_activity_apply")
@ApiModel("活动报名实体类")
public class LedaActivityApply
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @TableId
    private Long id;

    /** 活动id */
    private Long activityId;

    /** 订单id */
    private Long activityOrderId;

    /** 报名用户表id */
    private Long applyUserId;

    /** 金额 */
    private BigDecimal amount;

    /** 状态 0：待支付，1：已经支付 */
    private Integer status;

    /** $column.columnComment */
    @ApiModelProperty(hidden = true)
    private Date ctime;

    /** $column.columnComment */
    @ApiModelProperty(hidden = true)
    private Date utime;

}
