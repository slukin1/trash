package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PasskeyVerifyData implements Serializable {
    @SerializedName("verify_2fa")
    private boolean verify2fa;

    public boolean isVerify2fa() {
        return this.verify2fa;
    }
}
