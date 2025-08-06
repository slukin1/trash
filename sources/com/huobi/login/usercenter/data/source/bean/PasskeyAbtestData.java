package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PasskeyAbtestData implements Serializable {
    @SerializedName("ab_test")
    private boolean abTest;

    public boolean isAbTest() {
        return this.abTest;
    }
}
