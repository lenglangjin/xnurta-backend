package com.leda.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc
 * @auth Frank
 * @date 2024/10/31 14:57
 */
@ApiModel("退款条款")
public class LedaRefundTreatyVO {
    /** 主键 */
    @ApiModelProperty("退款条约id")
    private Long id;

    /** 条款标题 */
    @ApiModelProperty("退款条约title")
    private String title;

    @ApiModelProperty("退款条约内容")
    /** 条款内容 */
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
