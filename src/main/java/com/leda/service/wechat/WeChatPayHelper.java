package com.leda.service.wechat;


import com.binarywang.spring.starter.wxjava.pay.properties.WxPayProperties;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderV3Request;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderV3Result;
import com.github.binarywang.wxpay.bean.result.enums.TradeTypeEnum;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.leda.core.vo.wechat.WxPayCreateOrderRequest;
import com.leda.core.vo.wechat.WxPayCreateOrderParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WeChatPayHelper {

    @Autowired
    private WxPayService wxPayService;

    @Autowired
    private WxPayProperties wxPayProperties;

    @Value("${wx.pay.notifyUrl:https://www.kuailedazi.cn/api/leda/wechat/pay/callback}")
    private String notifyUrl;

    /**
     * 预创建订单
     * @param wxPayCreateOrder
     * @link https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_1.shtml
     * @return WxPayUnifiedOrderV3Result
     */
    public WxPayUnifiedOrderV3Result.JsapiResult preCreateOrder(WxPayCreateOrderParam wxPayCreateOrder) throws WxPayException {
        try {
            WxPayUnifiedOrderV3Request request = new WxPayUnifiedOrderV3Request();
            copyProperties(wxPayProperties,wxPayCreateOrder,request);
            WxPayUnifiedOrderV3Result.JsapiResult result = wxPayService.createOrderV3(TradeTypeEnum.JSAPI,request);
            return result;
        } catch (WxPayException e) {
            log.error("订单创建失败:{}",e);
            throw e;
        }
    }

    private void copyProperties(WxPayProperties wxPayProperties, WxPayCreateOrderParam wxPayCreateOrder, WxPayUnifiedOrderV3Request request){
        request.setAppid(wxPayProperties.getAppId());
        //直连商户好
        request.setMchid(wxPayProperties.getMchId());
        request.setDescription(wxPayCreateOrder.getDescription());
        //商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一
        request.setOutTradeNo(RandomStringUtils.randomAlphanumeric(32));
        //可选 订单失效时间
        //request.setTimeExpire("交易结束时间");
        //可选
        request.setAttach(wxPayCreateOrder.getAttach());
        //支付回调
        request.setNotifyUrl(notifyUrl);
        //订单金额信息
        WxPayUnifiedOrderV3Request.Amount amount = new WxPayUnifiedOrderV3Request.Amount();
        //订单总金额
        amount.setTotal(wxPayCreateOrder.getAmount());
        amount.setCurrency("CNY");
        request.setAmount(amount);
        //支付者
        WxPayUnifiedOrderV3Request.Payer payer = new WxPayUnifiedOrderV3Request.Payer();
        payer.setOpenid(wxPayCreateOrder.getOpenid());
        request.setPayer(payer);

        //优惠功能  detail
        //场景信息  scene_info
        //结算信息 settle_info
    }

}
