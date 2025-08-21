package com.leda.controller;

import com.leda.service.CourseReminderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 课程提醒控制器
 * 
 * @author frank
 * @date 2024-12-19
 */
@Slf4j
@RestController
@RequestMapping("/course-reminder")
@Api(tags = "课程提醒管理")
public class CourseReminderController {

    @Autowired
    private CourseReminderService courseReminderService;

    /**
     * 手动发送明天的课程提醒
     */
    @PostMapping("/send-tomorrow")
    @ApiOperation("手动发送明天的课程提醒")
    public Map<String, Object> sendTomorrowReminders() {
        Map<String, Object> result = new HashMap<>();
        
        try {
            log.info("手动触发发送明天的课程提醒");
            courseReminderService.sendTomorrowCourseReminders();
            
            result.put("success", true);
            result.put("message", "明天的课程提醒发送完成");
            result.put("timestamp", System.currentTimeMillis());
            
        } catch (Exception e) {
            log.error("手动发送明天的课程提醒失败", e);
            result.put("success", false);
            result.put("message", "发送失败：" + e.getMessage());
            result.put("timestamp", System.currentTimeMillis());
        }
        
        return result;
    }

    /**
     * 手动发送指定日期的课程提醒
     */
    @PostMapping("/send-by-date")
    @ApiOperation("手动发送指定日期的课程提醒")
    public Map<String, Object> sendRemindersByDate(
            @ApiParam(value = "日期", example = "2024-12-20", required = true)
            @RequestParam String date) {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            // 验证日期格式
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
            log.info("手动触发发送 {} 的课程提醒", date);
            courseReminderService.sendCourseRemindersByDate(date);
            
            result.put("success", true);
            result.put("message", date + " 的课程提醒发送完成");
            result.put("timestamp", System.currentTimeMillis());
            
        } catch (Exception e) {
            log.error("手动发送 {} 的课程提醒失败", date, e);
            result.put("success", false);
            result.put("message", "发送失败：" + e.getMessage());
            result.put("timestamp", System.currentTimeMillis());
        }
        
        return result;
    }

    /**
     * 获取需要发送提醒的活动列表
     */
    @GetMapping("/activities")
    @ApiOperation("获取指定日期需要发送提醒的活动列表")
    public Map<String, Object> getActivitiesNeedReminder(
            @ApiParam(value = "日期", example = "2024-12-20", required = true)
            @RequestParam String date) {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            // 验证日期格式
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
            java.util.List<java.lang.Long> activityIds = courseReminderService.getActivitiesNeedReminder(date);
            
            result.put("success", true);
            result.put("data", activityIds);
            result.put("count", activityIds.size());
            result.put("timestamp", System.currentTimeMillis());
            
        } catch (Exception e) {
            log.error("获取 {} 需要发送提醒的活动列表失败", date, e);
            result.put("success", false);
            result.put("message", "获取失败：" + e.getMessage());
            result.put("timestamp", System.currentTimeMillis());
        }
        
        return result;
    }
} 