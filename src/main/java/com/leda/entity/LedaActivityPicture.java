package com.leda.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 活动图片管理对象 leda_activity_picture
 * 
 * @author frank
 * @date 2024-10-29
 */
public class LedaActivityPicture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 图片id */
    private String pictureUrl;

    /** 活动id */
    private Long activityId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ctime;

    /** $column.columnComment */
    private Date utime;

    /** 是否删除，0:未删除，1:已删除 */
    private Long isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setActivityId(Long activityId)
    {
        this.activityId = activityId;
    }

    public Long getActivityId() 
    {
        return activityId;
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

    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }

}
