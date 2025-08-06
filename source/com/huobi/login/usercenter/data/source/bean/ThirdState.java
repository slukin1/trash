package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;

public class ThirdState {
    @SerializedName("expire_time")

    /* renamed from: a  reason: collision with root package name */
    public String f75684a;
    @SerializedName("state")

    /* renamed from: b  reason: collision with root package name */
    public String f75685b;

    public String a() {
        return this.f75685b;
    }

    public String toString() {
        return "ThirdState{expireTime='" + this.f75684a + '\'' + ", state='" + this.f75685b + '\'' + '}';
    }
}
