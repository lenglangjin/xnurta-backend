package com.leda.service.wechat;

import com.leda.entity.LedaActivity;
import com.leda.entity.LedaUser;

/**
 * 微信模板消息推送服务
 * 
 * @author frank
 * @date 2024-12-19
 */
public interface WeChatTemplateMessageService {

    /**
     * 发送课程提醒模板消息
     * 
     * @param user 用户信息
     * @param activity 活动信息
     * @return 是否发送成功
     */
    boolean sendCourseReminderMessage(LedaUser user, LedaActivity activity);

    /**
     * 发送课程提醒模板消息（批量）
     * 
     * @param activityId 活动ID
     * @return 发送成功的数量
     */
    int sendBatchCourseReminderMessage(Long activityId);
} 