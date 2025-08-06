package com.tencent.qcloud.tuikit.tuichat.bean;

import java.io.Serializable;

public class UserStatusBean implements Serializable {
    public static final int STATUS_OFFLINE = 1;
    public static final int STATUS_ONLINE = 1;
    private int onlineStatus = 1;
    private String userID;

    public int getOnlineStatus() {
        return this.onlineStatus;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setOnlineStatus(int i11) {
        this.onlineStatus = i11;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
