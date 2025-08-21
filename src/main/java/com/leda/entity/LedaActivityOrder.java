package com.leda.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 活动用户对象 leda_activity_user
 * 
 * @author frank
 * @date 2024-11-16
 */
@ApiModel("活动报名订单表")
public class LedaActivityOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(value = "订单编号", example = "67845678fghj6789hjklg")
    private String tradeNo;

    @ApiModelProperty(value = "活动id", example = "张三")
    private Long activityId;

    @ApiModelProperty(value = "活动分组id", example = "1男 2女")
    private Long groupId;

    @ApiModelProperty(value = "订单金额", example = "1是 0否")
    private BigDecimal amount;

    private Integer applyNum;

    /** 创建人 */
    private Integer userId;

    private Integer status;

    /** 创建时间 */
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime ctime;

    /** $column.columnComment */
    @ApiModelProperty(hidden = true)
    private LocalDateTime utime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public LocalDateTime getUtime() {
        return utime;
    }

    public void setUtime(LocalDateTime utime) {
        this.utime = utime;
    }
}
