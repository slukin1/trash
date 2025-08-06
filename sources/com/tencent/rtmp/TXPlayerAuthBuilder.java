package com.tencent.rtmp;

public class TXPlayerAuthBuilder {
    public int appId;
    public int exper = -1;
    public String fileId;
    public boolean isHttps;
    public String sign;
    public String timeout;

    /* renamed from: us  reason: collision with root package name */
    public String f48603us;

    public int getAppId() {
        return this.appId;
    }

    public int getExper() {
        return this.exper;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getSign() {
        return this.sign;
    }

    public String getTimeout() {
        return this.timeout;
    }

    public String getUs() {
        return this.f48603us;
    }

    public boolean isHttps() {
        return this.isHttps;
    }

    public void setAppId(int i11) {
        this.appId = i11;
    }

    public void setExper(int i11) {
        this.exper = i11;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setHttps(boolean z11) {
        this.isHttps = z11;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setTimeout(String str) {
        this.timeout = str;
    }

    public void setUs(String str) {
        this.f48603us = str;
    }
}
