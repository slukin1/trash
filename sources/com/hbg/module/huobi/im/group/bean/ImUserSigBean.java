package com.hbg.module.huobi.im.group.bean;

import java.io.Serializable;

public final class ImUserSigBean implements Serializable {
    private String appId = "";
    private String showId = "";
    private String usersig = "";

    public final String getAppId() {
        return this.appId;
    }

    public final String getShowId() {
        return this.showId;
    }

    public final String getUsersig() {
        return this.usersig;
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setShowId(String str) {
        this.showId = str;
    }

    public final void setUsersig(String str) {
        this.usersig = str;
    }
}
