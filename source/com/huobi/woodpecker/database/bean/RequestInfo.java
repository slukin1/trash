package com.huobi.woodpecker.database.bean;

import java.io.Serializable;

public class RequestInfo implements Serializable {
    private String action;
    private long date;

    /* renamed from: id  reason: collision with root package name */
    private long f21012id;
    private int priority;
    private String requestInfo;

    public String getAction() {
        return this.action;
    }

    public long getDate() {
        return this.date;
    }

    public long getId() {
        return this.f21012id;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getRequestInfo() {
        return this.requestInfo;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setDate(long j11) {
        this.date = j11;
    }

    public void setId(long j11) {
        this.f21012id = j11;
    }

    public void setPriority(int i11) {
        this.priority = i11;
    }

    public void setRequestInfo(String str) {
        this.requestInfo = str;
    }

    public String toString() {
        return "RequestInfo{id=" + this.f21012id + ", requestInfo='" + this.requestInfo + '\'' + ", date=" + this.date + ", type=" + this.action + '}';
    }
}
