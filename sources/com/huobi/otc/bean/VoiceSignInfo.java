package com.huobi.otc.bean;

import java.io.Serializable;

public class VoiceSignInfo implements Serializable {
    private String tencentUserId;
    private String userSign;

    public boolean canEqual(Object obj) {
        return obj instanceof VoiceSignInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoiceSignInfo)) {
            return false;
        }
        VoiceSignInfo voiceSignInfo = (VoiceSignInfo) obj;
        if (!voiceSignInfo.canEqual(this)) {
            return false;
        }
        String tencentUserId2 = getTencentUserId();
        String tencentUserId3 = voiceSignInfo.getTencentUserId();
        if (tencentUserId2 != null ? !tencentUserId2.equals(tencentUserId3) : tencentUserId3 != null) {
            return false;
        }
        String userSign2 = getUserSign();
        String userSign3 = voiceSignInfo.getUserSign();
        return userSign2 != null ? userSign2.equals(userSign3) : userSign3 == null;
    }

    public String getTencentUserId() {
        return this.tencentUserId;
    }

    public String getUserSign() {
        return this.userSign;
    }

    public int hashCode() {
        String tencentUserId2 = getTencentUserId();
        int i11 = 43;
        int hashCode = tencentUserId2 == null ? 43 : tencentUserId2.hashCode();
        String userSign2 = getUserSign();
        int i12 = (hashCode + 59) * 59;
        if (userSign2 != null) {
            i11 = userSign2.hashCode();
        }
        return i12 + i11;
    }

    public void setTencentUserId(String str) {
        this.tencentUserId = str;
    }

    public void setUserSign(String str) {
        this.userSign = str;
    }

    public String toString() {
        return "VoiceSignInfo(tencentUserId=" + getTencentUserId() + ", userSign=" + getUserSign() + ")";
    }
}
