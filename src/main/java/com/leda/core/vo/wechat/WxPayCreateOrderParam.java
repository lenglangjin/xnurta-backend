package com.leda.core.vo.wechat;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class WxPayCreateOrderParam {
    /**
     * 订单金额，单位分
     */
    private Integer amount;
    /**
     * openid
     */
    private String openid;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 附加数据
     */
    private String attach = "";

    protected String outTradeNo;

}

