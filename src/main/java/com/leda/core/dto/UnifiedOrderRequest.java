package com.leda.core.dto;

import lombok.Data;

@Data
public class UnifiedOrderRequest {
    /**
     * 商品描述
     */
    private String description;

    /**
     * 商户订单号
     */
    private String outTradeNo;
}
