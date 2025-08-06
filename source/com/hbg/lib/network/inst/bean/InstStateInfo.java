package com.hbg.lib.network.inst.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class InstStateInfo implements Serializable {
    public static final int STATE_FAIL = 4;
    public static final int STATE_SUCC = 3;
    public static final int STATE_WAIT = 1;
    private static final long serialVersionUID = 525516108896139763L;
    @SerializedName("countryId")
    private long countryId;
    @SerializedName("language")
    private int language;
    @SerializedName("levelType")
    private int levelType;
    @SerializedName("state")
    private Integer state;

    public boolean canEqual(Object obj) {
        return obj instanceof InstStateInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstStateInfo)) {
            return false;
        }
        InstStateInfo instStateInfo = (InstStateInfo) obj;
        if (!instStateInfo.canEqual(this)) {
            return false;
        }
        Integer state2 = getState();
        Integer state3 = instStateInfo.getState();
        if (state2 != null ? state2.equals(state3) : state3 == null) {
            return getLanguage() == instStateInfo.getLanguage() && getCountryId() == instStateInfo.getCountryId() && getLevelType() == instStateInfo.getLevelType();
        }
        return false;
    }

    public long getCountryId() {
        return this.countryId;
    }

    public int getLanguage() {
        return this.language;
    }

    public int getLevelType() {
        return this.levelType;
    }

    public Integer getState() {
        return this.state;
    }

    public int hashCode() {
        Integer state2 = getState();
        int hashCode = (((state2 == null ? 43 : state2.hashCode()) + 59) * 59) + getLanguage();
        long countryId2 = getCountryId();
        return (((hashCode * 59) + ((int) (countryId2 ^ (countryId2 >>> 32)))) * 59) + getLevelType();
    }

    public void setCountryId(long j11) {
        this.countryId = j11;
    }

    public void setLanguage(int i11) {
        this.language = i11;
    }

    public void setLevelType(int i11) {
        this.levelType = i11;
    }

    public void setState(Integer num) {
        this.state = num;
    }

    public String toString() {
        return "InstStateInfo(state=" + getState() + ", language=" + getLanguage() + ", countryId=" + getCountryId() + ", levelType=" + getLevelType() + ")";
    }
}
