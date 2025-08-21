package com.leda.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Builder
public class LedaUser /*extends BaseEntity */{

    @ApiModelProperty(hidden = true)
    private Long id;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickname;


    /**
     * openid
     */
    @ApiModelProperty(value = "openid")
    private String openid;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    /**
     *星座
     */
    @ApiModelProperty(value = "星座")
    private String constellation;
    /**
     * MBTI
     */
    @ApiModelProperty(value = "MBTI")
    private String mbti;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;
    /**
     * 偏好
     */
    @ApiModelProperty(value = "偏好")
    private String hobby;


}
