package com.leda.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LedaLoginDto {

    @ApiModelProperty("获取openid的code")
    private String openidCode;

    @ApiModelProperty("获取电话的code")
    private String phoneCode;


}
