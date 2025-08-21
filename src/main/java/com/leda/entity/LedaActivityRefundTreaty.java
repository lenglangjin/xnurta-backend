package com.leda.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 活动和退款政策关联对象 leda_activity_refund_treaty
 * 
 * @author frank
 * @date 2024-10-29
 */
public class LedaActivityRefundTreaty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 活动id */
    private Long activityId;

    /** 退款条约id */
    private Long refundId;

    /** 删除标识，0：未删除，1：已删除 */
    private Long isDeleted;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ctime;

    /** $column.columnComment */
    private Date utime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setActivityId(Long activityId) 
    {
        this.activityId = activityId;
    }

    public Long getActivityId() 
    {
        return activityId;
    }

    public void setRefundId(Long refundId) 
    {
        this.refundId = refundId;
    }

    public Long getRefundId() 
    {
        return refundId;
    }

    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }

    public void setCtime(Date ctime) 
    {
        this.ctime = ctime;
    }

    public Date getCtime() 
    {
        return ctime;
    }

    public void setUtime(Date utime) 
    {
        this.utime = utime;
    }

    public Date getUtime() 
    {
        return utime;
    }

}
