package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class CurrencyFromCCParallelData implements Serializable {
    private static final long serialVersionUID = 3067257902231497498L;
    private CurrencyFromCCAuthorizationData authInfo;
    private CurrencyFromCCJumioAuthData jumioAuthInfo;
    private CurrencyFromCCKYCLevel levelInfo;

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencyFromCCParallelData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyFromCCParallelData)) {
            return false;
        }
        CurrencyFromCCParallelData currencyFromCCParallelData = (CurrencyFromCCParallelData) obj;
        if (!currencyFromCCParallelData.canEqual(this)) {
            return false;
        }
        CurrencyFromCCKYCLevel levelInfo2 = getLevelInfo();
        CurrencyFromCCKYCLevel levelInfo3 = currencyFromCCParallelData.getLevelInfo();
        if (levelInfo2 != null ? !levelInfo2.equals(levelInfo3) : levelInfo3 != null) {
            return false;
        }
        CurrencyFromCCAuthorizationData authInfo2 = getAuthInfo();
        CurrencyFromCCAuthorizationData authInfo3 = currencyFromCCParallelData.getAuthInfo();
        if (authInfo2 != null ? !authInfo2.equals(authInfo3) : authInfo3 != null) {
            return false;
        }
        CurrencyFromCCJumioAuthData jumioAuthInfo2 = getJumioAuthInfo();
        CurrencyFromCCJumioAuthData jumioAuthInfo3 = currencyFromCCParallelData.getJumioAuthInfo();
        return jumioAuthInfo2 != null ? jumioAuthInfo2.equals(jumioAuthInfo3) : jumioAuthInfo3 == null;
    }

    public CurrencyFromCCAuthorizationData getAuthInfo() {
        return this.authInfo;
    }

    public CurrencyFromCCJumioAuthData getJumioAuthInfo() {
        return this.jumioAuthInfo;
    }

    public CurrencyFromCCKYCLevel getLevelInfo() {
        return this.levelInfo;
    }

    public int hashCode() {
        CurrencyFromCCKYCLevel levelInfo2 = getLevelInfo();
        int i11 = 43;
        int hashCode = levelInfo2 == null ? 43 : levelInfo2.hashCode();
        CurrencyFromCCAuthorizationData authInfo2 = getAuthInfo();
        int hashCode2 = ((hashCode + 59) * 59) + (authInfo2 == null ? 43 : authInfo2.hashCode());
        CurrencyFromCCJumioAuthData jumioAuthInfo2 = getJumioAuthInfo();
        int i12 = hashCode2 * 59;
        if (jumioAuthInfo2 != null) {
            i11 = jumioAuthInfo2.hashCode();
        }
        return i12 + i11;
    }

    public void setAuthInfo(CurrencyFromCCAuthorizationData currencyFromCCAuthorizationData) {
        this.authInfo = currencyFromCCAuthorizationData;
    }

    public void setJumioAuthInfo(CurrencyFromCCJumioAuthData currencyFromCCJumioAuthData) {
        this.jumioAuthInfo = currencyFromCCJumioAuthData;
    }

    public void setLevelInfo(CurrencyFromCCKYCLevel currencyFromCCKYCLevel) {
        this.levelInfo = currencyFromCCKYCLevel;
    }

    public String toString() {
        return "CurrencyFromCCParallelData(levelInfo=" + getLevelInfo() + ", authInfo=" + getAuthInfo() + ", jumioAuthInfo=" + getJumioAuthInfo() + ")";
    }
}
