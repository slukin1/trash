package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import p9.a;

public class CodeVerifyData implements a, Serializable {
    @SerializedName("token")
    private String token;
    @SerializedName("tsv_token")
    private String tsvToken;

    public String getToken() {
        return this.token;
    }

    public String getTsvToken() {
        return this.tsvToken;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTsvToken(String str) {
        this.tsvToken = str;
    }
}
