package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class HbgDialogAppVersion implements Serializable {
    private static final long serialVersionUID = 101808930561589182L;
    public List<Integer> deviceType;
    public int matchType;
    public List<String> version;

    public boolean canEqual(Object obj) {
        return obj instanceof HbgDialogAppVersion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HbgDialogAppVersion)) {
            return false;
        }
        HbgDialogAppVersion hbgDialogAppVersion = (HbgDialogAppVersion) obj;
        if (!hbgDialogAppVersion.canEqual(this) || getMatchType() != hbgDialogAppVersion.getMatchType()) {
            return false;
        }
        List<Integer> deviceType2 = getDeviceType();
        List<Integer> deviceType3 = hbgDialogAppVersion.getDeviceType();
        if (deviceType2 != null ? !deviceType2.equals(deviceType3) : deviceType3 != null) {
            return false;
        }
        List<String> version2 = getVersion();
        List<String> version3 = hbgDialogAppVersion.getVersion();
        return version2 != null ? version2.equals(version3) : version3 == null;
    }

    public List<Integer> getDeviceType() {
        return this.deviceType;
    }

    public int getMatchType() {
        return this.matchType;
    }

    public List<String> getVersion() {
        return this.version;
    }

    public int hashCode() {
        List<Integer> deviceType2 = getDeviceType();
        int i11 = 43;
        int matchType2 = ((getMatchType() + 59) * 59) + (deviceType2 == null ? 43 : deviceType2.hashCode());
        List<String> version2 = getVersion();
        int i12 = matchType2 * 59;
        if (version2 != null) {
            i11 = version2.hashCode();
        }
        return i12 + i11;
    }

    public void setDeviceType(List<Integer> list) {
        this.deviceType = list;
    }

    public void setMatchType(int i11) {
        this.matchType = i11;
    }

    public void setVersion(List<String> list) {
        this.version = list;
    }

    public String toString() {
        return "HbgDialogAppVersion(matchType=" + getMatchType() + ", deviceType=" + getDeviceType() + ", version=" + getVersion() + ")";
    }
}
