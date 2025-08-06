package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcSeniorInfo implements Serializable {
    private static final long serialVersionUID = 4411042444484878343L;
    private String accumulative;
    private int currencyId;
    private String currencyName;
    private String single;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcSeniorInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcSeniorInfo)) {
            return false;
        }
        OtcSeniorInfo otcSeniorInfo = (OtcSeniorInfo) obj;
        if (!otcSeniorInfo.canEqual(this)) {
            return false;
        }
        String single2 = getSingle();
        String single3 = otcSeniorInfo.getSingle();
        if (single2 != null ? !single2.equals(single3) : single3 != null) {
            return false;
        }
        String currencyName2 = getCurrencyName();
        String currencyName3 = otcSeniorInfo.getCurrencyName();
        if (currencyName2 != null ? !currencyName2.equals(currencyName3) : currencyName3 != null) {
            return false;
        }
        String accumulative2 = getAccumulative();
        String accumulative3 = otcSeniorInfo.getAccumulative();
        if (accumulative2 != null ? accumulative2.equals(accumulative3) : accumulative3 == null) {
            return getCurrencyId() == otcSeniorInfo.getCurrencyId();
        }
        return false;
    }

    public String getAccumulative() {
        return this.accumulative;
    }

    public int getCurrencyId() {
        return this.currencyId;
    }

    public String getCurrencyName() {
        return this.currencyName;
    }

    public String getSingle() {
        return this.single;
    }

    public int hashCode() {
        String single2 = getSingle();
        int i11 = 43;
        int hashCode = single2 == null ? 43 : single2.hashCode();
        String currencyName2 = getCurrencyName();
        int hashCode2 = ((hashCode + 59) * 59) + (currencyName2 == null ? 43 : currencyName2.hashCode());
        String accumulative2 = getAccumulative();
        int i12 = hashCode2 * 59;
        if (accumulative2 != null) {
            i11 = accumulative2.hashCode();
        }
        return ((i12 + i11) * 59) + getCurrencyId();
    }

    public void setAccumulative(String str) {
        this.accumulative = str;
    }

    public void setCurrencyId(int i11) {
        this.currencyId = i11;
    }

    public void setCurrencyName(String str) {
        this.currencyName = str;
    }

    public void setSingle(String str) {
        this.single = str;
    }

    public String toString() {
        return "OtcSeniorInfo(single=" + getSingle() + ", currencyName=" + getCurrencyName() + ", accumulative=" + getAccumulative() + ", currencyId=" + getCurrencyId() + ")";
    }
}
