package com.leda.service.impl;

import cn.hutool.core.date.DateUtil;
import com.leda.entity.LedaActivity;
import com.leda.entity.LedaActivityApply;
import com.leda.entity.LedaUser;
import com.leda.mapper.LedaActivityApplyMapper;
import com.leda.mapper.LedaActivityMapper;
import com.leda.service.CourseReminderService;
import com.leda.service.wechat.WeChatTemplateMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程提醒服务实现类
 * 
 * @author frank
 * @date 2024-12-19
 */
@Slf4j
@Service
public class CourseReminderServiceImpl implements CourseReminderService {

    @Autowired
    private WeChatTemplateMessageService weChatTemplateMessageService;

    @Autowired
    private LedaActivityMapper ledaActivityMapper;

    @Autowired
    private LedaActivityApplyMapper ledaActivityApplyMapper;

    // 这里需要注入用户Mapper，暂时注释掉
    // @Autowired
    // private LedaUserMapper ledaUserMapper;

    @Override
    public void sendTomorrowCourseReminders() {
        String tomorrow = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        sendCourseRemindersByDate(tomorrow);
    }

    @Override
    public void sendCourseRemindersByDate(String date) {
        log.info("开始发送 {} 的课程提醒", date);
        
        try {
            // 获取需要发送提醒的活动列表
            List<Long> activityIds = getActivitiesNeedReminder(date);
            
            if (activityIds.isEmpty()) {
                log.info("{} 没有需要发送提醒的活动", date);
                return;
            }

            int successCount = 0;
            int totalCount = 0;

            for (Long activityId : activityIds) {
                try {
                    // 查询活动信息
                    LedaActivity activity = ledaActivityMapper.selectById(activityId);
                    if (activity == null) {
                        log.warn("活动 {} 不存在，跳过", activityId);
                        continue;
                    }

                    // 查询报名用户列表
                    List<LedaActivityApply> applies = ledaActivityApplyMapper.selectByActivityId(activityId);
                    
                    if (!applies.isEmpty()) {
                        for (LedaActivityApply apply : applies) {
                            try {
                                // 这里需要实现具体的查询逻辑
                                // LedaUser user = ledaUserMapper.selectById(apply.getApplyUserId());
                                
                                // 暂时使用模拟数据，实际应该从数据库查询
                                LedaUser user = getMockUser(apply.getApplyUserId());
                                
                                if (user != null && weChatTemplateMessageService.sendCourseReminderMessage(user, activity)) {
                                    successCount++;
                                }
                                totalCount++;
                            } catch (Exception e) {
                                log.error("发送用户 {} 的课程提醒失败", apply.getApplyUserId(), e);
                            }
                        }
                    }
                } catch (Exception e) {
                    log.error("处理活动 {} 的课程提醒失败", activityId, e);
                }
            }

            log.info("{} 的课程提醒发送完成，成功：{}，总数：{}", date, successCount, totalCount);
            
        } catch (Exception e) {
            log.error("发送 {} 的课程提醒失败", date, e);
        }
    }

    @Override
    public List<Long> getActivitiesNeedReminder(String date) {
        List<Long> activityIds = new ArrayList<>();
        
        try {
            // 使用真实的Mapper查询需要发送提醒的活动
            activityIds = ledaActivityMapper.selectActivityIdsByDate(date);
            log.info("查询到 {} 个需要发送提醒的活动", activityIds.size());
            
        } catch (Exception e) {
            log.error("获取 {} 需要发送提醒的活动列表失败", date, e);
        }
        
        return activityIds;
    }

    // 模拟方法，实际应该删除，需要实现真实的用户查询
    private LedaUser getMockUser(Long userId) {
        LedaUser user = LedaUser.builder()
                .id(userId)
                .nickname("测试用户")
                .openid("test_openid_123")
                .build();
        return user;
    }
} 