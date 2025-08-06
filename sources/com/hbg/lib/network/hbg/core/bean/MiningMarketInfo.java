package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class MiningMarketInfo implements Serializable {
    private String digitalAssetTotalAmount;
    private String digitalCurrency;
    private String digitalIncomeTotalAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof MiningMarketInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MiningMarketInfo)) {
            return false;
        }
        MiningMarketInfo miningMarketInfo = (MiningMarketInfo) obj;
        if (!miningMarketInfo.canEqual(this)) {
            return false;
        }
        String digitalAssetTotalAmount2 = getDigitalAssetTotalAmount();
        String digitalAssetTotalAmount3 = miningMarketInfo.getDigitalAssetTotalAmount();
        if (digitalAssetTotalAmount2 != null ? !digitalAssetTotalAmount2.equals(digitalAssetTotalAmount3) : digitalAssetTotalAmount3 != null) {
            return false;
        }
        String digitalCurrency2 = getDigitalCurrency();
        String digitalCurrency3 = miningMarketInfo.getDigitalCurrency();
        if (digitalCurrency2 != null ? !digitalCurrency2.equals(digitalCurrency3) : digitalCurrency3 != null) {
            return false;
        }
        String digitalIncomeTotalAmount2 = getDigitalIncomeTotalAmount();
        String digitalIncomeTotalAmount3 = miningMarketInfo.getDigitalIncomeTotalAmount();
        return digitalIncomeTotalAmount2 != null ? digitalIncomeTotalAmount2.equals(digitalIncomeTotalAmount3) : digitalIncomeTotalAmount3 == null;
    }

    public String getDigitalAssetTotalAmount() {
        return this.digitalAssetTotalAmount;
    }

    public String getDigitalCurrency() {
        return this.digitalCurrency;
    }

    public String getDigitalIncomeTotalAmount() {
        return this.digitalIncomeTotalAmount;
    }

    public int hashCode() {
        String digitalAssetTotalAmount2 = getDigitalAssetTotalAmount();
        int i11 = 43;
        int hashCode = digitalAssetTotalAmount2 == null ? 43 : digitalAssetTotalAmount2.hashCode();
        String digitalCurrency2 = getDigitalCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (digitalCurrency2 == null ? 43 : digitalCurrency2.hashCode());
        String digitalIncomeTotalAmount2 = getDigitalIncomeTotalAmount();
        int i12 = hashCode2 * 59;
        if (digitalIncomeTotalAmount2 != null) {
            i11 = digitalIncomeTotalAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setDigitalAssetTotalAmount(String str) {
        this.digitalAssetTotalAmount = str;
    }

    public void setDigitalCurrency(String str) {
        this.digitalCurrency = str;
    }

    public void setDigitalIncomeTotalAmount(String str) {
        this.digitalIncomeTotalAmount = str;
    }

    public String toString() {
        return "MiningMarketInfo(digitalAssetTotalAmount=" + getDigitalAssetTotalAmount() + ", digitalCurrency=" + getDigitalCurrency() + ", digitalIncomeTotalAmount=" + getDigitalIncomeTotalAmount() + ")";
    }
}
