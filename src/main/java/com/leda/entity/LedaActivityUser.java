package com.leda.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 活动用户对象 leda_activity_user
 * 
 * @author frank
 * @date 2024-11-16
 */
@ApiModel("活动报名用户实体类")
public class LedaActivityUser //extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @ApiModelProperty(hidden = true)
    private Long id;

    /** 昵称 */
    @ApiModelProperty(value = "昵称", example = "张三")
    private String name;

    /** 1男 2女 */
    @ApiModelProperty(value = "性别", example = "1男 2女")
    private Integer gender;

    /** 是否是本人 */
    @ApiModelProperty(value = "是否是本人", example = "1是 0否")
    private Integer isOwner;

    /** 创建人 */
    @ApiModelProperty(hidden = true)
    private Integer userId;

    /** 创建时间 */
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ctime;

    /** $column.columnComment */
    @ApiModelProperty(hidden = true)
    private Date utime;

    /** 是否删除，0:未删除，1:已删除 */
    @ApiModelProperty(hidden = true)
    private Long isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Integer isOwner) {
        this.isOwner = isOwner;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
