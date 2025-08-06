package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class LendingDetail implements Serializable {
    private static final long serialVersionUID = -8142388712497016355L;
    public String deduction;
    public String lendingRate;

    public boolean canEqual(Object obj) {
        return obj instanceof LendingDetail;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LendingDetail)) {
            return false;
        }
        LendingDetail lendingDetail = (LendingDetail) obj;
        if (!lendingDetail.canEqual(this)) {
            return false;
        }
        String lendingRate2 = getLendingRate();
        String lendingRate3 = lendingDetail.getLendingRate();
        if (lendingRate2 != null ? !lendingRate2.equals(lendingRate3) : lendingRate3 != null) {
            return false;
        }
        String deduction2 = getDeduction();
        String deduction3 = lendingDetail.getDeduction();
        return deduction2 != null ? deduction2.equals(deduction3) : deduction3 == null;
    }

    public String getDeduction() {
        return this.deduction;
    }

    public String getLendingRate() {
        return this.lendingRate;
    }

    public int hashCode() {
        String lendingRate2 = getLendingRate();
        int i11 = 43;
        int hashCode = lendingRate2 == null ? 43 : lendingRate2.hashCode();
        String deduction2 = getDeduction();
        int i12 = (hashCode + 59) * 59;
        if (deduction2 != null) {
            i11 = deduction2.hashCode();
        }
        return i12 + i11;
    }

    public void setDeduction(String str) {
        this.deduction = str;
    }

    public void setLendingRate(String str) {
        this.lendingRate = str;
    }

    public String toString() {
        return "LendingDetail(lendingRate=" + getLendingRate() + ", deduction=" + getDeduction() + ")";
    }
}
