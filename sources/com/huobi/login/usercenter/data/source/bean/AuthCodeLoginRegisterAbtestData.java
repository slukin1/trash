package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AuthCodeLoginRegisterAbtestData implements Serializable {
    @SerializedName("ab_test")
    private boolean abTest;

    public boolean isAbTest() {
        return this.abTest;
    }

    public void setAbTest(boolean z11) {
        this.abTest = z11;
    }
}
