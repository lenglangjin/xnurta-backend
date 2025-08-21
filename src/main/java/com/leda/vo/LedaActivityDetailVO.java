package com.leda.vo;


import com.leda.entity.LedaActivity;
import com.leda.entity.LedaActivityGroup;
import com.leda.entity.LedaRefundTreaty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @desc
 * @auth Frank
 * @date 2024/10/31 9:16
 */
@ApiModel("活动详情、更新、创建等接口字段说明")
public class LedaActivityDetailVO extends LedaActivity {

    @ApiModelProperty(value = "类型名称")
    private String typeName;

    @ApiModelProperty(value = "类型名称")
    private String typeImgUrl;

    @ApiModelProperty(value = "活动状态", example = "梁溪区南长街472号")
    private BigDecimal acPrice;

    @ApiModelProperty(value = "图片上传接口返回的url", example = "1,2,3")
    private List<String> pictureUrls;

    @ApiModelProperty(value = "活动分组信息（对象）")
    private List<LedaActivityGroup> ledaActivityGroups;

    @ApiModelProperty(value = "退款政策id列表")
    private LedaRefundTreaty ledaRefundTreaty;

    @ApiModelProperty(value = "报名状态", example = "0")
    private Integer applyStatus;

    public List<LedaActivityGroup> getLedaActivityGroups() {
        return ledaActivityGroups;
    }

    public void setLedaActivityGroups(List<LedaActivityGroup> ledaActivityGroups) {
        this.ledaActivityGroups = ledaActivityGroups;
    }

    public LedaRefundTreaty getLedaRefundTreaty() {
        return ledaRefundTreaty;
    }

    public void setLedaRefundTreaty(LedaRefundTreaty ledaRefundTreaty) {
        this.ledaRefundTreaty = ledaRefundTreaty;
    }

    public String getTypeImgUrl() {
        return typeImgUrl;
    }

    public void setTypeImgUrl(String typeImgUrl) {
        this.typeImgUrl = typeImgUrl;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public BigDecimal getAcPrice() {
        return acPrice;
    }

    public void setAcPrice(BigDecimal acPrice) {
        this.acPrice = acPrice;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }
}
