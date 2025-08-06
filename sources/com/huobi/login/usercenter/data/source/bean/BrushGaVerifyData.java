package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BrushGaVerifyData implements Serializable {
    @SerializedName("temp_ga_verify_pass_token")
    private String tempGaVerifyPassToken;

    public String getTempGaVerifyPassToken() {
        return this.tempGaVerifyPassToken;
    }

    public void setTempGaVerifyPassToken(String str) {
        this.tempGaVerifyPassToken = str;
    }
}
