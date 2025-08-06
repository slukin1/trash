package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import p9.a;

public class GaGenerateData implements a, Serializable {
    @SerializedName("ga_key")
    private String gaKey;
    @SerializedName("login_name")
    private String loginName;
    @SerializedName("tsv_token")
    private String tsvToken;

    public String getGaKey() {
        return this.gaKey;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public String getTsvToken() {
        return this.tsvToken;
    }

    public void setGaKey(String str) {
        this.gaKey = str;
    }

    public void setLoginName(String str) {
        this.loginName = str;
    }
}
