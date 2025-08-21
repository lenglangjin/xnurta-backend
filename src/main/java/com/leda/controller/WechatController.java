package com.leda.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/wechat")
@Api(value = "微信",tags = "微信")
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @Value("${wx.mp.template.course-reminder:}")
    private String courseReminderTemplateId;
    @GetMapping("send")
    public String test() throws WxErrorException {
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("oOS_V1_HaOnZGEaGstQZ-is6eOj4")
                .templateId(courseReminderTemplateId)
                .url("") // 可以设置点击跳转的链接
                .build();

        // 添加模板数据
        templateMessage.addData(new WxMpTemplateData("expireTime", "2020/12/12", "#173177"));
        templateMessage.addData(new WxMpTemplateData("status", "未完成", "#173177"));
        templateMessage.addData(new WxMpTemplateData("phone", "18888888888", "#173177"));

        // 发送模板消息
        String msgId = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        log.info("成功发送课程提醒模板消息，用户：{}，活动：{}，消息ID：{}");

        return "true";
    }

}
