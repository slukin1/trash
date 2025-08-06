package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class UserVO implements Serializable {
    public static final int C1_AUTH = 1;
    public static final int C2_AUTH = 2;
    public static final int UN_AUTH = 0;
    private String areaType;
    private int country;
    private String faceUrl;
    private String gmtCreate;
    private long gmtRegister;

    /* renamed from: id  reason: collision with root package name */
    private int f70596id;
    private boolean isApplyTradeLevel;
    private boolean isGaBind;
    private boolean isMailBind;
    private boolean isMerchant;
    private boolean isPhoneBind;
    private boolean isTradeBind;
    private int merchantLevel;
    private String merchantType;
    private int realBind;
    private String realName;
    private int sendable;
    private int showId;
    private int tradeLevel;
    private String userName;
    public boolean verifyWayHaveSet;

    public String getAreaType() {
        return this.areaType;
    }

    public int getCountry() {
        return this.country;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getGmtCreate() {
        return this.gmtCreate;
    }

    public long getGmtRegister() {
        return this.gmtRegister;
    }

    public int getId() {
        return this.f70596id;
    }

    public int getMerchantLevel() {
        return this.merchantLevel;
    }

    public String getMerchantType() {
        return this.merchantType;
    }

    public int getRealBind() {
        return this.realBind;
    }

    public String getRealName() {
        return this.realName;
    }

    public int getSendable() {
        return this.sendable;
    }

    public int getShowId() {
        return this.showId;
    }

    public int getTradeLevel() {
        return this.tradeLevel;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean isHighAuth() {
        return this.realBind == 2;
    }

    public boolean isIsApplyTradeLevel() {
        return this.isApplyTradeLevel;
    }

    public boolean isIsGaBind() {
        return this.isGaBind;
    }

    public boolean isIsMailBind() {
        return this.isMailBind;
    }

    public boolean isIsMerchant() {
        return this.isMerchant;
    }

    public boolean isIsPhoneBind() {
        return this.isPhoneBind;
    }

    public boolean isIsTradeBind() {
        return this.isTradeBind;
    }

    public boolean isRealNameAuth() {
        return this.realBind == 1;
    }

    public boolean isVerifyWayHaveSet() {
        return this.verifyWayHaveSet;
    }

    public void setAreaType(String str) {
        this.areaType = str;
    }

    public void setCountry(int i11) {
        this.country = i11;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setGmtCreate(String str) {
        this.gmtCreate = str;
    }

    public void setGmtRegister(long j11) {
        this.gmtRegister = j11;
    }

    public void setId(int i11) {
        this.f70596id = i11;
    }

    public void setIsApplyTradeLevel(boolean z11) {
        this.isApplyTradeLevel = z11;
    }

    public void setIsGaBind(boolean z11) {
        this.isGaBind = z11;
    }

    public void setIsMailBind(boolean z11) {
        this.isMailBind = z11;
    }

    public void setIsMerchant(boolean z11) {
        this.isMerchant = z11;
    }

    public void setIsPhoneBind(boolean z11) {
        this.isPhoneBind = z11;
    }

    public void setIsTradeBind(boolean z11) {
        this.isTradeBind = z11;
    }

    public void setMerchantLevel(int i11) {
        this.merchantLevel = i11;
    }

    public void setRealBind(int i11) {
        this.realBind = i11;
    }

    public void setRealName(String str) {
        this.realName = str;
    }

    public void setSendable(int i11) {
        this.sendable = i11;
    }

    public void setShowId(int i11) {
        this.showId = i11;
    }

    public void setTradeLevel(int i11) {
        this.tradeLevel = i11;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
