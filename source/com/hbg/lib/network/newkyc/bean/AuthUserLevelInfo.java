package com.hbg.lib.network.newkyc.bean;

import java.io.Serializable;

public class AuthUserLevelInfo implements Serializable {
    public Integer authState;
    public Integer authType;
    public Integer maxLevel;
    public Long uid;

    public boolean canEqual(Object obj) {
        return obj instanceof AuthUserLevelInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthUserLevelInfo)) {
            return false;
        }
        AuthUserLevelInfo authUserLevelInfo = (AuthUserLevelInfo) obj;
        if (!authUserLevelInfo.canEqual(this)) {
            return false;
        }
        Long uid2 = getUid();
        Long uid3 = authUserLevelInfo.getUid();
        if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
            return false;
        }
        Integer maxLevel2 = getMaxLevel();
        Integer maxLevel3 = authUserLevelInfo.getMaxLevel();
        if (maxLevel2 != null ? !maxLevel2.equals(maxLevel3) : maxLevel3 != null) {
            return false;
        }
        Integer authState2 = getAuthState();
        Integer authState3 = authUserLevelInfo.getAuthState();
        if (authState2 != null ? !authState2.equals(authState3) : authState3 != null) {
            return false;
        }
        Integer authType2 = getAuthType();
        Integer authType3 = authUserLevelInfo.getAuthType();
        return authType2 != null ? authType2.equals(authType3) : authType3 == null;
    }

    public Integer getAuthState() {
        return this.authState;
    }

    public Integer getAuthType() {
        return this.authType;
    }

    public Integer getMaxLevel() {
        return this.maxLevel;
    }

    public Long getUid() {
        return this.uid;
    }

    public int hashCode() {
        Long uid2 = getUid();
        int i11 = 43;
        int hashCode = uid2 == null ? 43 : uid2.hashCode();
        Integer maxLevel2 = getMaxLevel();
        int hashCode2 = ((hashCode + 59) * 59) + (maxLevel2 == null ? 43 : maxLevel2.hashCode());
        Integer authState2 = getAuthState();
        int hashCode3 = (hashCode2 * 59) + (authState2 == null ? 43 : authState2.hashCode());
        Integer authType2 = getAuthType();
        int i12 = hashCode3 * 59;
        if (authType2 != null) {
            i11 = authType2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isC2Complete() {
        return this.maxLevel.intValue() > 2 || (this.maxLevel.intValue() == 2 && this.authState.intValue() == 2);
    }

    public boolean isC3Complete() {
        return this.maxLevel.intValue() == 3 && this.authState.intValue() == 2;
    }

    public boolean isL1Complete() {
        return this.maxLevel.intValue() >= 1;
    }

    public boolean isL4Complete() {
        return this.maxLevel.intValue() > 3;
    }

    public void setAuthState(Integer num) {
        this.authState = num;
    }

    public void setAuthType(Integer num) {
        this.authType = num;
    }

    public void setMaxLevel(Integer num) {
        this.maxLevel = num;
    }

    public void setUid(Long l11) {
        this.uid = l11;
    }

    public String toString() {
        return "AuthUserLevelInfo(uid=" + getUid() + ", maxLevel=" + getMaxLevel() + ", authState=" + getAuthState() + ", authType=" + getAuthType() + ")";
    }
}
