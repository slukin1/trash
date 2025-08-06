package com.hbg.lib.core.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class AliyunConfig implements Serializable {
    private static final long serialVersionUID = -2353796721629506141L;
    @SerializedName("filter_time")
    private int filterTime;
    @SerializedName("log_switch")
    private boolean logSwitch;
    @SerializedName("sample_rate")
    private int sampleRate;
    @SerializedName("url_path")
    private List<String> urlPath;

    public boolean canEqual(Object obj) {
        return obj instanceof AliyunConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AliyunConfig)) {
            return false;
        }
        AliyunConfig aliyunConfig = (AliyunConfig) obj;
        if (!aliyunConfig.canEqual(this) || isLogSwitch() != aliyunConfig.isLogSwitch() || getFilterTime() != aliyunConfig.getFilterTime()) {
            return false;
        }
        List<String> urlPath2 = getUrlPath();
        List<String> urlPath3 = aliyunConfig.getUrlPath();
        if (urlPath2 != null ? urlPath2.equals(urlPath3) : urlPath3 == null) {
            return getSampleRate() == aliyunConfig.getSampleRate();
        }
        return false;
    }

    public int getFilterTime() {
        return this.filterTime;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public List<String> getUrlPath() {
        return this.urlPath;
    }

    public int hashCode() {
        int filterTime2 = (((isLogSwitch() ? 79 : 97) + 59) * 59) + getFilterTime();
        List<String> urlPath2 = getUrlPath();
        return (((filterTime2 * 59) + (urlPath2 == null ? 43 : urlPath2.hashCode())) * 59) + getSampleRate();
    }

    public boolean isLogSwitch() {
        return this.logSwitch;
    }

    public void setFilterTime(int i11) {
        this.filterTime = i11;
    }

    public void setLogSwitch(boolean z11) {
        this.logSwitch = z11;
    }

    public void setSampleRate(int i11) {
        this.sampleRate = i11;
    }

    public void setUrlPath(List<String> list) {
        this.urlPath = list;
    }

    public String toString() {
        return "AliyunConfig(logSwitch=" + isLogSwitch() + ", filterTime=" + getFilterTime() + ", urlPath=" + getUrlPath() + ", sampleRate=" + getSampleRate() + ")";
    }
}
