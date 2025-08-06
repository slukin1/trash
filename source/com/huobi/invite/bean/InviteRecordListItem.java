package com.huobi.invite.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.invite.viewhandler.InviteRecordListItemHandler;
import java.io.Serializable;

public class InviteRecordListItem implements s9.a, Serializable {
    private static final long serialVersionUID = -9189370236209337630L;
    @SerializedName("account_name")
    private String accountName;
    public transient a callback;
    @SerializedName("point_rate")
    private String pointRate;
    @SerializedName("register_time")
    private long registerTime;
    private int state;
    @SerializedName("usdt_rate")
    private String usdtRate;
    @SerializedName("valid_day")
    private int validDay;

    public interface a {
        void a(InviteRecordListItem inviteRecordListItem);
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getPointRate() {
        return this.pointRate;
    }

    public long getRegisterTime() {
        return this.registerTime;
    }

    public int getState() {
        return this.state;
    }

    public String getUsdtRate() {
        return this.usdtRate;
    }

    public int getValidDay() {
        return this.validDay;
    }

    public String getViewHandlerName() {
        return InviteRecordListItemHandler.class.getName();
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setPointRate(String str) {
        this.pointRate = str;
    }

    public void setRegisterTime(long j11) {
        this.registerTime = j11;
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public void setUsdtRate(String str) {
        this.usdtRate = str;
    }

    public void setValidDay(int i11) {
        this.validDay = i11;
    }
}
