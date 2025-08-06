package com.huobi.invite.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class InviterInfo implements Serializable {
    private static final long serialVersionUID = -6297657398386576183L;
    @SerializedName("invalid_count")
    private int invalidCount;
    @SerializedName("invite_code")
    private String inviteCode;
    @SerializedName("point_rate")
    private String pointRate;
    @SerializedName("share_url")
    private String shareUrl;
    private int total;
    @SerializedName("usdt_rate")
    private String usdtRate;
    @SerializedName("valid_count")
    private int validCount;
    @SerializedName("valid_day")
    private int validDay;

    public int getInvalidCount() {
        return this.invalidCount;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public String getPointRate() {
        return this.pointRate;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public int getTotal() {
        return this.total;
    }

    public String getUsdtRate() {
        return this.usdtRate;
    }

    public int getValidCount() {
        return this.validCount;
    }

    public int getValidDay() {
        return this.validDay;
    }

    public void setInvalidCount(int i11) {
        this.invalidCount = i11;
    }

    public void setInviteCode(String str) {
        this.inviteCode = str;
    }

    public void setPointRate(String str) {
        this.pointRate = str;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public void setTotal(int i11) {
        this.total = i11;
    }

    public void setUsdtRate(String str) {
        this.usdtRate = str;
    }

    public void setValidCount(int i11) {
        this.validCount = i11;
    }

    public void setValidDay(int i11) {
        this.validDay = i11;
    }
}
