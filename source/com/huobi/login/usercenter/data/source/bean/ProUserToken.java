package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.core.network.response.BaseResponse;

public class ProUserToken extends BaseResponse {
    @SerializedName("token")
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
