package com.leda.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 退款政策对象 leda_refund_treaty
 * 
 * @author frank
 * @date 2024-10-29
 */
public class LedaRefundTreaty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 条款标题 */
    private String title;

    private Integer hour;

    /** 条款内容 */
    private String content;

    /** 是否删除，0:未删除，1:已删除 */
    private Long isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime refundDeadline;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ctime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date utime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDateTime getRefundDeadline() {
        return refundDeadline;
    }

    public void setRefundDeadline(LocalDateTime refundDeadline) {
        this.refundDeadline = refundDeadline;
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
