package com.leda.config;

import com.leda.service.CourseReminderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务配置类
 * 
 * @author frank
 * @date 2024-12-19
 */
@Slf4j
@Configuration
@EnableScheduling
public class ScheduleConfig {

    @Autowired
    private CourseReminderService courseReminderService;

    /**
     * 每天早上8点发送明天的课程提醒
     * cron表达式：秒 分 时 日 月 周
     */
    @Scheduled(cron = "0 0 8 * * ?")
    public void sendTomorrowCourseReminders() {
        log.info("开始执行定时任务：发送明天的课程提醒");
        try {
            courseReminderService.sendTomorrowCourseReminders();
            log.info("定时任务执行完成：发送明天的课程提醒");
        } catch (Exception e) {
            log.error("定时任务执行失败：发送明天的课程提醒", e);
        }
    }

    /**
     * 每天晚上8点发送后天的课程提醒（可选，用于测试）
     * cron表达式：秒 分 时 日 月 周
     */
    @Scheduled(cron = "0 0 20 * * ?")
    public void sendAfterTomorrowCourseReminders() {
        log.info("开始执行定时任务：发送后天的课程提醒");
        try {
            // 获取后天的日期
            String afterTomorrow = java.time.LocalDate.now().plusDays(2)
                    .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            courseReminderService.sendCourseRemindersByDate(afterTomorrow);
            log.info("定时任务执行完成：发送后天的课程提醒");
        } catch (Exception e) {
            log.error("定时任务执行失败：发送后天的课程提醒", e);
        }
    }
} 