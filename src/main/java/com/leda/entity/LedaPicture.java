package com.leda.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 图片管理对象 leda_picture
 * 
 * @author frank
 * @date 2024-10-29
 */
public class LedaPicture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;
    
    private String name;

    /** 图片所在路径 */
    private String path;

    /** 0 活动上传图片 1头像  2 系统图片*/
    private Long type;

    /** 创建人 */
    private Long userId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }

    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
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
