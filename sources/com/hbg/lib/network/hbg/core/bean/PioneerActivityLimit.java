package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PioneerActivityLimit implements Serializable {
    private static final long serialVersionUID = -7875394804471020734L;
    private boolean authKyc;
    @SerializedName("country_disabled")
    private boolean countryDisabled;
    @SerializedName("currency_code")
    private String currencyCode;

    public boolean canEqual(Object obj) {
        return obj instanceof PioneerActivityLimit;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PioneerActivityLimit)) {
            return false;
        }
        PioneerActivityLimit pioneerActivityLimit = (PioneerActivityLimit) obj;
        if (!pioneerActivityLimit.canEqual(this)) {
            return false;
        }
        String currencyCode2 = getCurrencyCode();
        String currencyCode3 = pioneerActivityLimit.getCurrencyCode();
        if (currencyCode2 != null ? currencyCode2.equals(currencyCode3) : currencyCode3 == null) {
            return isCountryDisabled() == pioneerActivityLimit.isCountryDisabled() && isAuthKyc() == pioneerActivityLimit.isAuthKyc();
        }
        return false;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public int hashCode() {
        String currencyCode2 = getCurrencyCode();
        int i11 = 79;
        int hashCode = ((((currencyCode2 == null ? 43 : currencyCode2.hashCode()) + 59) * 59) + (isCountryDisabled() ? 79 : 97)) * 59;
        if (!isAuthKyc()) {
            i11 = 97;
        }
        return hashCode + i11;
    }

    public boolean isAuthKyc() {
        return this.authKyc;
    }

    public boolean isCountryDisabled() {
        return this.countryDisabled;
    }

    public void setAuthKyc(boolean z11) {
        this.authKyc = z11;
    }

    public void setCountryDisabled(boolean z11) {
        this.countryDisabled = z11;
    }

    public void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public String toString() {
        return "PioneerActivityLimit(currencyCode=" + getCurrencyCode() + ", countryDisabled=" + isCountryDisabled() + ", authKyc=" + isAuthKyc() + ")";
    }
}
