package com.leda.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动组对象 leda_activity_group
 * 
 * @author frank
 * @date 2024-10-29
 */
@ApiModel("活动分组")
public class LedaActivityGroup extends BaseEntity
{
    private static final Long serialVersionUID = 1L;

    /** 主键 */
    @ApiModelProperty(hidden = true)
    private Integer id;

    /** 活动id */
    @ApiModelProperty(hidden = true)
    private Integer activityId;

    /** 活动组名称 */
    @ApiModelProperty(value = "活动组名称", example = "默认分组")
    private String groupName;

    /** 活动人数 */
    @ApiModelProperty(value = "活动人数", example = "20")
    private Integer acNum;

    /** 最低活动人数 */
    @ApiModelProperty(value = "最低活动人数", example = "10")
    private Integer acNumLeast;

    /** 女士活动价格 */
    @ApiModelProperty(value = "男士活动价格", example = "88.88")
    private BigDecimal acPriceMale;

    /** 男士活动价格 */
    @ApiModelProperty(value = "女士活动价格", example = "88.88")
    private BigDecimal acPriceFemale;


    /** 删除标识，0：未删除，1：已删除 */
    @ApiModelProperty(hidden = true)
    private Integer isDeleted;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(hidden = true)
    private Date ctime;

    /** $column.columnComment */
    @ApiModelProperty(hidden = true)
    private Date utime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getAcNum() {
        return acNum;
    }

    public void setAcNum(Integer acNum) {
        this.acNum = acNum;
    }

    public Integer getAcNumLeast() {
        return acNumLeast;
    }

    public void setAcNumLeast(Integer acNumLeast) {
        this.acNumLeast = acNumLeast;
    }

    public BigDecimal getAcPriceMale() {
        return acPriceMale;
    }

    public void setAcPriceMale(BigDecimal acPriceMale) {
        this.acPriceMale = acPriceMale;
    }

    public BigDecimal getAcPriceFemale() {
        return acPriceFemale;
    }

    public void setAcPriceFemale(BigDecimal acPriceFemale) {
        this.acPriceFemale = acPriceFemale;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }
}
