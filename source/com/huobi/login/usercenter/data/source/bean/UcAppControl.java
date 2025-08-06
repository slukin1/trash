package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UcAppControl implements Serializable {
    private static final long serialVersionUID = -3851260519577400496L;
    @SerializedName("login_way")
    private String loginWay;
    @SerializedName("register_way")
    private String registerWay;
    @SerializedName("web_host")
    private String webHost;

    public String getLoginWay() {
        return this.loginWay;
    }

    public String getRegisterWay() {
        return this.registerWay;
    }

    public String getWebHost() {
        return this.webHost;
    }

    public void setLoginWay(String str) {
        this.loginWay = str;
    }

    public void setRegisterWay(String str) {
        this.registerWay = str;
    }

    public void setWebHost(String str) {
        this.webHost = str;
    }
}
