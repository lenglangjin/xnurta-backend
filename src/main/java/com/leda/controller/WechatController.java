package com.leda.controller;

import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderV3Result;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.leda.core.vo.wechat.WxPayCallBackRequest;
import com.leda.core.vo.wechat.WxPayCreateOrderParam;
import com.leda.service.wechat.WeChatPayHelper;
import com.leda.utils.AjaxResult;
import com.leda.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@Slf4j
@RestController
@RequestMapping("/wechat")
@Api(value = "微信支付",tags = "微信支付")
public class WechatController {


}
