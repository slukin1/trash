package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class CurrencyFromCCJumioAuthData implements Serializable {
    public static final int AUTH_LEVEL_L1 = 1;
    public static final int AUTH_LEVEL_L2 = 2;
    public static final int AUTH_LEVEL_L3 = 3;
    public static final int AUTH_LEVEL_L4 = 4;
    private static final long serialVersionUID = -6210535741149341488L;
    private int authLevel;
    private int authState;

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencyFromCCJumioAuthData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyFromCCJumioAuthData)) {
            return false;
        }
        CurrencyFromCCJumioAuthData currencyFromCCJumioAuthData = (CurrencyFromCCJumioAuthData) obj;
        return currencyFromCCJumioAuthData.canEqual(this) && getAuthState() == currencyFromCCJumioAuthData.getAuthState() && getAuthLevel() == currencyFromCCJumioAuthData.getAuthLevel();
    }

    public int getAuthLevel() {
        return this.authLevel;
    }

    public int getAuthState() {
        return this.authState;
    }

    public int hashCode() {
        return ((getAuthState() + 59) * 59) + getAuthLevel();
    }

    public boolean isPassed() {
        return this.authState == 2 && this.authLevel == 2;
    }

    public void setAuthLevel(int i11) {
        this.authLevel = i11;
    }

    public void setAuthState(int i11) {
        this.authState = i11;
    }

    public String toString() {
        return "CurrencyFromCCJumioAuthData(authState=" + getAuthState() + ", authLevel=" + getAuthLevel() + ")";
    }
}
