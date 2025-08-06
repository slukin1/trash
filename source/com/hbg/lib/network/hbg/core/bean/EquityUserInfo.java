package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.math.BigDecimal;

public class EquityUserInfo implements Serializable {
    @SerializedName("deduction")
    private double deduction;
    @SerializedName("diffVolume")
    private String diffVolume;
    @SerializedName("discount")
    private double discount;
    @SerializedName("discountTitle")
    private String discountTitle;
    @SerializedName("endTime")
    private Long endTime;
    @SerializedName("feeRate")
    private BigDecimal feeRate;
    @SerializedName("firstPrimeRightsName")
    private String firstPrimeRightsName;
    @SerializedName("isWhiteValid")
    private int isWhiteValid;
    @SerializedName("jumpUrl")
    private String jumpUrl;
    @SerializedName("level")
    private int level;
    @SerializedName("levelIsTop")
    private int levelIsTop;
    @SerializedName("levelName")
    private String levelName;
    @SerializedName("levelType")
    private int levelType;
    @SerializedName("levelVolume")
    private String levelVolume;
    @SerializedName("nextLevel")
    private int nextLevel;
    @SerializedName("nextLevelName")
    private String nextLevelName;
    @SerializedName("nextLevelVolume")
    private String nextLevelVolume;
    @SerializedName("saveFeeVolume")
    private String saveFeeVolume;
    @SerializedName("secondPrimeRightsName")
    private String secondPrimeRightsName;
    @SerializedName("sysTime")
    private Long sysTime;
    @SerializedName("volume")
    private String volume;

    public double getDeduction() {
        return this.deduction;
    }

    public String getDiffVolume() {
        return this.diffVolume;
    }

    public double getDiscount() {
        return this.discount;
    }

    public String getDiscountTitle() {
        return this.discountTitle;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public BigDecimal getFeeRate() {
        return this.feeRate;
    }

    public String getFirstPrimeRightsName() {
        return this.firstPrimeRightsName;
    }

    public int getIsWhiteValid() {
        return this.isWhiteValid;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getLevel() {
        return this.level;
    }

    public int getLevelIsTop() {
        return this.levelIsTop;
    }

    public String getLevelName() {
        return this.levelName;
    }

    public int getLevelType() {
        return this.levelType;
    }

    public String getLevelVolume() {
        return this.levelVolume;
    }

    public int getNextLevel() {
        return this.nextLevel;
    }

    public String getNextLevelName() {
        return this.nextLevelName;
    }

    public String getNextLevelVolume() {
        return this.nextLevelVolume;
    }

    public String getSaveFeeVolume() {
        return this.saveFeeVolume;
    }

    public String getSecondPrimeRightsName() {
        return this.secondPrimeRightsName;
    }

    public Long getSysTime() {
        return this.sysTime;
    }

    public String getVolume() {
        return this.volume;
    }

    public void setDeduction(double d11) {
        this.deduction = d11;
    }

    public void setDiffVolume(String str) {
        this.diffVolume = str;
    }

    public void setDiscount(double d11) {
        this.discount = d11;
    }

    public void setDiscountTitle(String str) {
        this.discountTitle = str;
    }

    public void setEndTime(Long l11) {
        this.endTime = l11;
    }

    public void setFeeRate(BigDecimal bigDecimal) {
        this.feeRate = bigDecimal;
    }

    public void setFirstPrimeRightsName(String str) {
        this.firstPrimeRightsName = str;
    }

    public void setIsWhiteValid(int i11) {
        this.isWhiteValid = i11;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setLevel(int i11) {
        this.level = i11;
    }

    public void setLevelIsTop(int i11) {
        this.levelIsTop = i11;
    }

    public void setLevelName(String str) {
        this.levelName = str;
    }

    public void setLevelType(int i11) {
        this.levelType = i11;
    }

    public void setLevelVolume(String str) {
        this.levelVolume = str;
    }

    public void setNextLevel(int i11) {
        this.nextLevel = i11;
    }

    public void setNextLevelName(String str) {
        this.nextLevelName = str;
    }

    public void setNextLevelVolume(String str) {
        this.nextLevelVolume = str;
    }

    public void setSaveFeeVolume(String str) {
        this.saveFeeVolume = str;
    }

    public void setSecondPrimeRightsName(String str) {
        this.secondPrimeRightsName = str;
    }

    public void setSysTime(Long l11) {
        this.sysTime = l11;
    }

    public void setVolume(String str) {
        this.volume = str;
    }
}
