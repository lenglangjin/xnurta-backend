package com.leda.service.wechat.impl;

import cn.hutool.core.util.StrUtil;
import com.leda.entity.LedaActivity;
import com.leda.entity.LedaUser;
import com.leda.service.wechat.WeChatTemplateMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 微信模板消息推送服务实现类
 * 
 * @author frank
 * @date 2024-12-19
 */
@Slf4j
@Service
public class WeChatTemplateMessageServiceImpl implements WeChatTemplateMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Value("${wx.mp.template.course-reminder:}")
    private String courseReminderTemplateId;

    @Override
    public boolean sendCourseReminderMessage(LedaUser user, LedaActivity activity) {
        try {
            // 检查用户是否有openid
            if (StrUtil.isBlank(user.getOpenid())) {
                log.warn("用户 {} 没有绑定微信公众号，无法发送模板消息", user.getNickname());
                return false;
            }

            // 检查模板ID是否配置
            if (StrUtil.isBlank(courseReminderTemplateId)) {
                log.error("课程提醒模板ID未配置，请检查配置文件");
                return false;
            }

            // 构建模板消息
            WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                    .toUser(user.getOpenid())
                    .templateId(courseReminderTemplateId)
                    .url("") // 可以设置点击跳转的链接
                    .build();

            // 添加模板数据
            templateMessage.addData(new WxMpTemplateData("first", "您好，明天有课程安排，请及时参加！", "#173177"));
            templateMessage.addData(new WxMpTemplateData("keyword1", activity.getTitle(), "#173177"));
            templateMessage.addData(new WxMpTemplateData("keyword2", 
                activity.getAcTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), "#173177"));
            templateMessage.addData(new WxMpTemplateData("keyword3", 
                activity.getProvince() + activity.getCity() + activity.getAddress(), "#173177"));
            templateMessage.addData(new WxMpTemplateData("keyword4", 
                activity.getIntroduction() != null ? activity.getIntroduction().substring(0, Math.min(activity.getIntroduction().length(), 50)) : "无", "#173177"));
            templateMessage.addData(new WxMpTemplateData("remark", "请提前做好准备，准时参加！", "#173177"));

            // 发送模板消息
            String msgId = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            log.info("成功发送课程提醒模板消息，用户：{}，活动：{}，消息ID：{}", 
                user.getNickname(), activity.getTitle(), msgId);
            
            return true;
        } catch (Exception e) {
            log.error("发送课程提醒模板消息失败，用户：{}，活动：{}", user.getNickname(), activity.getTitle(), e);
            return false;
        }
    }

    @Override
    public int sendBatchCourseReminderMessage(Long activityId) {
        // 这里需要调用其他服务获取活动信息和报名用户列表
        // 暂时返回0，具体实现需要依赖其他服务
        log.info("批量发送课程提醒模板消息，活动ID：{}", activityId);
        return 0;
    }
} 