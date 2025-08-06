package com.hbg.lib.network.hbg.core.bean;

import android.text.TextUtils;
import java.io.Serializable;

public class CurrencyFromCCKYCLevel implements Serializable {
    private static final long serialVersionUID = -1817698282201638982L;
    private int level;
    private String sourceAppId;

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencyFromCCKYCLevel;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyFromCCKYCLevel)) {
            return false;
        }
        CurrencyFromCCKYCLevel currencyFromCCKYCLevel = (CurrencyFromCCKYCLevel) obj;
        if (!currencyFromCCKYCLevel.canEqual(this) || getLevel() != currencyFromCCKYCLevel.getLevel()) {
            return false;
        }
        String sourceAppId2 = getSourceAppId();
        String sourceAppId3 = currencyFromCCKYCLevel.getSourceAppId();
        return sourceAppId2 != null ? sourceAppId2.equals(sourceAppId3) : sourceAppId3 == null;
    }

    public int getLevel() {
        return this.level;
    }

    public String getSourceAppId() {
        return this.sourceAppId;
    }

    public int hashCode() {
        String sourceAppId2 = getSourceAppId();
        return ((getLevel() + 59) * 59) + (sourceAppId2 == null ? 43 : sourceAppId2.hashCode());
    }

    public boolean isPassed(String str) {
        return TextUtils.equals(this.sourceAppId, str) && this.level >= 2;
    }

    public void setLevel(int i11) {
        this.level = i11;
    }

    public void setSourceAppId(String str) {
        this.sourceAppId = str;
    }

    public String toString() {
        return "CurrencyFromCCKYCLevel(level=" + getLevel() + ", sourceAppId=" + getSourceAppId() + ")";
    }
}
