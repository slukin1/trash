package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class TokenResp implements IMessageEntity {
    @Packed
    private String belongId;
    @Packed
    private int retCode = 0;
    @Packed
    private String subjectId;
    @Packed
    private String token = "";

    public String getBelongId() {
        return this.belongId;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getSubjectId() {
        return this.subjectId;
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

    public void setSubjectId(String str) {
        this.subjectId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
