package com.leda.core.vo.wechat;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WxPayCallBackRequest {

    /**
     * 通知id
     */
    private String id;
    /**
     * 通知创建的时间，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，
     * T出现在字符串中，表示time元素的开头，HH:mm:ss.表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。
     * 例如：2015-05-20T13:29:35+08:00表示北京时间2015年05月20日13点29分35秒。
     * 示例值：2015-05-20T13:29:35+08:00
     */
    private String create_time;
    /**
     * 通知的类型，支付成功通知的类型为TRANSACTION.SUCCESS
     * 示例值：TRANSACTION.SUCCESS
     */
    private String event_type;
    /**
     * 通知的资源数据类型，支付成功通知为encrypt-resource
     * 示例值：encrypt-resource
     */
    private String resource_type;
    /**
     * 通知资源数据
     * json格式，见示例
     */
    private Resource resource;

    /**
     * 回调摘要，示例：支付成功
     */
    private String summary;

    @Data
    public class Resource{

        /** 加密算法类型
         * 对开启结果数据进行加密的加密算法，目前只支持AEAD_AES_256_GCM
         * 示例值：AEAD_AES_256_GCM
         */
        private String algorithm;
        /**
         * Base64编码后的开启/停用结果数据密文
         * 示例值：sadsadsadsad
         */
        private String ciphertext;
        /**
         * 附加数据
         * 示例值：fdasfwqewlkja484w
         */
        private String associated_dat;

        /**
         * 	原始回调类型，为transaction
         * 示例值：transaction
         */
        private String original_type;

        /**
         * 加密使用的随机串
         */
        private String nonce;

    }
}
