package com.leda.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @desc
 * @auth Frank
 * @date 2024/10/29 9:16
 */
@ApiModel("活动实体类")
public class LedaActivity extends BaseEntity {

    @ApiModelProperty(value = "数据表id", name = "新增接口不需要传该字段，更新接口需要传")
    private Integer id;
    @ApiModelProperty(value = "活动标题", example = "千岛湖骑行")
    private String title;
    @ApiModelProperty(value = "活动内容介绍", example = "活动规则，新手提示，地址指引")
    private String introduction;
    @ApiModelProperty(value = "活动规则", example = "不能脱离队伍布拉布拉布拉布", hidden = true)
    private String rule;
    @ApiModelProperty(value = "新手提示", example = "新手该休息休息", hidden = true)
    private String beginnerTip;
    @ApiModelProperty(value = "地址指引", example = "千岛湖骑行路线", hidden = true)
    private String addressDesc;
    @ApiModelProperty(value = "停车说明", example = "1号停车场免费停车布拉布拉布拉")
    private String parkingDesc;
    @ApiModelProperty(value = "是否线下，1是线下 0否", example = "1")
    private Integer isOffline;
    @ApiModelProperty(value = "活动类型id，活动列表接口返回的数据id", example = "1")
    private Integer typeId;
    @ApiModelProperty(value = "活动地所在省份", example = "江苏")
    private String province;
    @ApiModelProperty(value = "活动地所在市区城市", example = "无锡")
    private String city;
    @ApiModelProperty(value = "活动详细地址", example = "梁溪区南长街472号")
    private String address;
    @ApiModelProperty(value = "经度", example = "120.311664")
    private BigDecimal longitude;
    @ApiModelProperty(value = "纬度", example = "31.490505")
    private BigDecimal latitude;
    @ApiModelProperty(value = "活动时间", example = "2024-11-11 08:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime acTime;
    @ApiModelProperty(value = "活动截止日期", example = "2024-11-11 08:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cutoffTime;
    @ApiModelProperty(value = "是否允许后选人", example = "1是 0否")
    private Integer isCandidate;
    @ApiModelProperty(value = "是否限购1个", example = "1是 0否")
    private Integer isLimitOne;
    @ApiModelProperty(hidden = true)
    private Integer isDeleted;
    @ApiModelProperty(hidden = true)
    private Integer userId;
    @ApiModelProperty(hidden = true)
    private Integer hotNum;
    @ApiModelProperty(hidden = true)
    private Integer status;
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ctime;
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime utime;

    public Integer getHotNum() {
        return hotNum;
    }

    public void setHotNum(Integer hotNum) {
        this.hotNum = hotNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getBeginnerTip() {
        return beginnerTip;
    }

    public void setBeginnerTip(String beginnerTip) {
        this.beginnerTip = beginnerTip;
    }

    public String getAddressDesc() {
        return addressDesc;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public String getParkingDesc() {
        return parkingDesc;
    }

    public void setParkingDesc(String parkingDesc) {
        this.parkingDesc = parkingDesc;
    }

    public Integer getIsOffline() {
        return isOffline;
    }

    public void setIsOffline(Integer isOffline) {
        this.isOffline = isOffline;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public LocalDateTime getAcTime() {
        return acTime;
    }

    public void setAcTime(LocalDateTime acTime) {
        this.acTime = acTime;
    }

    public LocalDateTime getCutoffTime() {
        return cutoffTime;
    }

    public void setCutoffTime(LocalDateTime cutoffTime) {
        this.cutoffTime = cutoffTime;
    }

    public Integer getIsCandidate() {
        return isCandidate;
    }

    public void setIsCandidate(Integer isCandidate) {
        this.isCandidate = isCandidate;
    }

    public Integer getIsLimitOne() {
        return isLimitOne;
    }

    public void setIsLimitOne(Integer isLimitOne) {
        this.isLimitOne = isLimitOne;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public LocalDateTime getUtime() {
        return utime;
    }

    public void setUtime(LocalDateTime utime) {
        this.utime = utime;
    }
}
