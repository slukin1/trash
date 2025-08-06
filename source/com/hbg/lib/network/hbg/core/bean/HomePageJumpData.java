package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class HomePageJumpData implements Serializable {
    private int jumpMode;
    private String jumpSymbol;
    private String jumpUrl;
    private int needLogin;
    private String title;

    public int getJumpMode() {
        return this.jumpMode;
    }

    public String getJumpSymbol() {
        return this.jumpSymbol;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getNeedLogin() {
        return this.needLogin;
    }

    public String getTitle() {
        return this.title;
    }

    public void setJumpMode(int i11) {
        this.jumpMode = i11;
    }

    public void setJumpSymbol(String str) {
        this.jumpSymbol = str;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setNeedLogin(int i11) {
        this.needLogin = i11;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
