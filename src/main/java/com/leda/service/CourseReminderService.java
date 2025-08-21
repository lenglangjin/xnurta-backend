package com.leda.service;

import java.util.List;

/**
 * 课程提醒服务
 * 
 * @author frank
 * @date 2024-12-19
 */
public interface CourseReminderService {

    /**
     * 发送明天的课程提醒
     */
    void sendTomorrowCourseReminders();

    /**
     * 发送指定日期的课程提醒
     * 
     * @param date 日期字符串，格式：yyyy-MM-dd
     */
    void sendCourseRemindersByDate(String date);

    /**
     * 获取需要发送提醒的活动列表
     * 
     * @param date 日期字符串，格式：yyyy-MM-dd
     * @return 活动ID列表
     */
    List<Long> getActivitiesNeedReminder(String date);
} 