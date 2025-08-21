package com.leda.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 活动类型对象 leda_activity_type
 * 
 * @author frank
 * @date 2024-10-29
 */
public class LedaActivityType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 组名称 */
    private String name;

    /** 父组id */
    private Integer parentId;

    /** 图标 */
    private String imageUrl;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ctime;

    /** $column.columnComment */
    private Date utime;

    /** 是否删除，0:未删除，1:已删除 */
    private Long isDeleted;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setParentId(Integer parentId)
    {
        this.parentId = parentId;
    }

    public Integer getParentId()
    {
        return parentId;
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
