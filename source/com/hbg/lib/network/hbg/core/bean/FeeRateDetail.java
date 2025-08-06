package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class FeeRateDetail implements Serializable {
    private static final long serialVersionUID = -8142388712497016355L;
    public String makerDeduction;
    public String makerFeeRate;
    public String takerDeduction;
    public String takerFeeRate;

    public boolean canEqual(Object obj) {
        return obj instanceof FeeRateDetail;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeeRateDetail)) {
            return false;
        }
        FeeRateDetail feeRateDetail = (FeeRateDetail) obj;
        if (!feeRateDetail.canEqual(this)) {
            return false;
        }
        String makerFeeRate2 = getMakerFeeRate();
        String makerFeeRate3 = feeRateDetail.getMakerFeeRate();
        if (makerFeeRate2 != null ? !makerFeeRate2.equals(makerFeeRate3) : makerFeeRate3 != null) {
            return false;
        }
        String takerFeeRate2 = getTakerFeeRate();
        String takerFeeRate3 = feeRateDetail.getTakerFeeRate();
        if (takerFeeRate2 != null ? !takerFeeRate2.equals(takerFeeRate3) : takerFeeRate3 != null) {
            return false;
        }
        String makerDeduction2 = getMakerDeduction();
        String makerDeduction3 = feeRateDetail.getMakerDeduction();
        if (makerDeduction2 != null ? !makerDeduction2.equals(makerDeduction3) : makerDeduction3 != null) {
            return false;
        }
        String takerDeduction2 = getTakerDeduction();
        String takerDeduction3 = feeRateDetail.getTakerDeduction();
        return takerDeduction2 != null ? takerDeduction2.equals(takerDeduction3) : takerDeduction3 == null;
    }

    public String getMakerDeduction() {
        return this.makerDeduction;
    }

    public String getMakerFeeRate() {
        return this.makerFeeRate;
    }

    public String getTakerDeduction() {
        return this.takerDeduction;
    }

    public String getTakerFeeRate() {
        return this.takerFeeRate;
    }

    public int hashCode() {
        String makerFeeRate2 = getMakerFeeRate();
        int i11 = 43;
        int hashCode = makerFeeRate2 == null ? 43 : makerFeeRate2.hashCode();
        String takerFeeRate2 = getTakerFeeRate();
        int hashCode2 = ((hashCode + 59) * 59) + (takerFeeRate2 == null ? 43 : takerFeeRate2.hashCode());
        String makerDeduction2 = getMakerDeduction();
        int hashCode3 = (hashCode2 * 59) + (makerDeduction2 == null ? 43 : makerDeduction2.hashCode());
        String takerDeduction2 = getTakerDeduction();
        int i12 = hashCode3 * 59;
        if (takerDeduction2 != null) {
            i11 = takerDeduction2.hashCode();
        }
        return i12 + i11;
    }

    public void setMakerDeduction(String str) {
        this.makerDeduction = str;
    }

    public void setMakerFeeRate(String str) {
        this.makerFeeRate = str;
    }

    public void setTakerDeduction(String str) {
        this.takerDeduction = str;
    }

    public void setTakerFeeRate(String str) {
        this.takerFeeRate = str;
    }

    public String toString() {
        return "FeeRateDetail(makerFeeRate=" + getMakerFeeRate() + ", takerFeeRate=" + getTakerFeeRate() + ", makerDeduction=" + getMakerDeduction() + ", takerDeduction=" + getTakerDeduction() + ")";
    }
}
