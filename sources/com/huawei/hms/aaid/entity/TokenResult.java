package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Result;

public class TokenResult extends Result {
    @Packed
    private String belongId;
    @Packed
    private int retCode = 0;
    @Packed
    private String token = "";

    public String getBelongId() {
        return this.belongId;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getToken() {
        return this.token;
    }

    public void setBelongId(String str) {
        this.belongId = str;
    }

    public void setRetCode(int i11) {
        this.retCode = i11;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
