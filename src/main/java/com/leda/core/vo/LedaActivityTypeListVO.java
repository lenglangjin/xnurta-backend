package com.leda.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @desc
 * @auth Frank
 * @date 2024/10/29 14:30
 */
@ApiModel("活动类型说明")
public class LedaActivityTypeListVO {
    /** 主键 */
    @ApiModelProperty("数据id")
    private Integer id;

    /** 组名称 */
    @ApiModelProperty(value = "活动类型名称",example = "跑步")
    private String name;

    /** 父组id */
    @ApiModelProperty(hidden = true)
    private Integer parentId;

    private List<LedaActivityTypeListVO> childTypes;

    public List<LedaActivityTypeListVO> getChildTypes() {
        return childTypes;
    }

    public void setChildTypes(List<LedaActivityTypeListVO> childTypes) {
        this.childTypes = childTypes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
