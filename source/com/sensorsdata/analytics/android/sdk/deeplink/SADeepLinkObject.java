package com.sensorsdata.analytics.android.sdk.deeplink;

import java.io.Serializable;

public class SADeepLinkObject implements Serializable {
    private long mAppAwakePassedTime;
    private String mChannels;
    private String mParams;
    private boolean success;

    public SADeepLinkObject(String str, String str2, boolean z11, long j11) {
        this.mParams = str;
        this.mChannels = str2;
        this.success = z11;
        this.mAppAwakePassedTime = j11;
    }

    public long getAppAwakePassedTime() {
        return this.mAppAwakePassedTime;
    }

    public String getChannels() {
        return this.mChannels;
    }

    public String getParams() {
        return this.mParams;
    }

    public boolean isSuccess() {
        return this.success;
    }
}
