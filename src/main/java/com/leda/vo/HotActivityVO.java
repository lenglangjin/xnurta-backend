package com.leda.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @desc
 * @auth Frank
 * @date 2024/12/10 9:30
 */
@Data
@ApiModel("获取热点活动列表接口字段说明")
public class HotActivityVO {
    @ApiModelProperty(value = "数据表id", name = "新增接口不需要传该字段，更新接口需要传")
    private Integer id;

    @ApiModelProperty(value = "活动标题", example = "千岛湖骑行")
    private String title;

    @ApiModelProperty(value = "活动类型id，活动列表接口返回的数据id", example = "1")
    private Integer typeId;

    @ApiModelProperty(value = "活动推荐人数", example = "10")
    private Integer acNum;

    @ApiModelProperty(value = "已经报名人数", example = "8")
    private Integer acApplyNum;

    @ApiModelProperty(value = "活动类型名称", example = "1")
    private String typeName;

    @ApiModelProperty(value = "活动类型图标", example = "https://www.kuailedazi.cn/api/leda/picture/getPictureByName/type_yundong")
    private String typeImgUrl;

    @ApiModelProperty(value = "活动主图（封面图）", example = "https://leda.oss-cn-shanghai.aliyuncs.com/20250224/ad1330df004046d69e197edf7ff4a1e6.png")
    private String mainPicture;

    /** 女士活动价格 */
    @ApiModelProperty(value = "男士活动价格", example = "88.88")
    private BigDecimal acPriceMale;

    /** 男士活动价格 */
    @ApiModelProperty(value = "女士活动价格", example = "88.88")
    private BigDecimal acPriceFemale;

    @ApiModelProperty(hidden = true)
    private LocalDateTime datetime;

    @ApiModelProperty(value = "活动日期", example = "1")
    private String date;

    @ApiModelProperty(value = "活动日期", example = "1")
    private String week;

    @ApiModelProperty(value = "活动开始时间 HH:ss", example = "1")
    private String time;

    @ApiModelProperty(value = "活动详细地址", example = "梁溪区南长街472号")
    private String address;

    @ApiModelProperty(value = "活动状态", example = "1")
    private Integer status;

    @ApiModelProperty(value = "报名状态", example = "0")
    private Integer applyStatus;
}
