package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class PushUserSig implements Serializable {
    private String nickName;
    private String tencentUserId;
    private String userSign;

    public String getName() {
        return this.nickName;
    }

    public String getTencentUserId() {
        return this.tencentUserId;
    }

    public String getUserSign() {
        return this.userSign;
    }

    public void setTencentUserId(String str) {
        this.tencentUserId = str;
    }

    public void setUserSign(String str) {
        this.userSign = str;
    }
}
