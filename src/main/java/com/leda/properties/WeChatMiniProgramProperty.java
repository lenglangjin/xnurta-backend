package com.leda.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties(prefix = "wechat.mini-program")
public class WeChatMiniProgramProperty {

    private String appId;

    private String appSecret;

    private String token;

}
