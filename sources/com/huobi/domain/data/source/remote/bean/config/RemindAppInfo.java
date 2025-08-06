package com.huobi.domain.data.source.remote.bean.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RemindAppInfo implements Serializable {
    @SerializedName("bundleIdentifier")
    private String packageName;
    @SerializedName("version")
    private int versionCode;

    public boolean canEqual(Object obj) {
        return obj instanceof RemindAppInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemindAppInfo)) {
            return false;
        }
        RemindAppInfo remindAppInfo = (RemindAppInfo) obj;
        if (!remindAppInfo.canEqual(this)) {
            return false;
        }
        String packageName2 = getPackageName();
        String packageName3 = remindAppInfo.getPackageName();
        if (packageName2 != null ? packageName2.equals(packageName3) : packageName3 == null) {
            return getVersionCode() == remindAppInfo.getVersionCode();
        }
        return false;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        String packageName2 = getPackageName();
        return (((packageName2 == null ? 43 : packageName2.hashCode()) + 59) * 59) + getVersionCode();
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setVersionCode(int i11) {
        this.versionCode = i11;
    }

    public String toString() {
        return "RemindAppInfo(packageName=" + getPackageName() + ", versionCode=" + getVersionCode() + ")";
    }
}
