package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RegisterCheckIpData implements Serializable {
    @SerializedName("alter_msg")
    private String alterMsg;
    @SerializedName("detention_msg")
    private String detentionMsg;
    @SerializedName("limit_type")
    private String limitType;

    public String getAlterMsg() {
        return this.alterMsg;
    }

    public String getDetentionMsg() {
        return this.detentionMsg;
    }

    public String getLimitType() {
        return this.limitType;
    }

    public void setAlterMsg(String str) {
        this.alterMsg = str;
    }

    public void setDetentionMsg(String str) {
        this.detentionMsg = str;
    }

    public void setLimitType(String str) {
        this.limitType = str;
    }
}
