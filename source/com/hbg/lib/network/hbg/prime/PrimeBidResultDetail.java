package com.hbg.lib.network.hbg.prime;

import java.io.Serializable;

public class PrimeBidResultDetail implements Serializable {
    private static final long serialVersionUID = -7920166242648909540L;
    private String digits;
    private String numOfDigits;
    private String percentage;

    public boolean canEqual(Object obj) {
        return obj instanceof PrimeBidResultDetail;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimeBidResultDetail)) {
            return false;
        }
        PrimeBidResultDetail primeBidResultDetail = (PrimeBidResultDetail) obj;
        if (!primeBidResultDetail.canEqual(this)) {
            return false;
        }
        String percentage2 = getPercentage();
        String percentage3 = primeBidResultDetail.getPercentage();
        if (percentage2 != null ? !percentage2.equals(percentage3) : percentage3 != null) {
            return false;
        }
        String digits2 = getDigits();
        String digits3 = primeBidResultDetail.getDigits();
        if (digits2 != null ? !digits2.equals(digits3) : digits3 != null) {
            return false;
        }
        String numOfDigits2 = getNumOfDigits();
        String numOfDigits3 = primeBidResultDetail.getNumOfDigits();
        return numOfDigits2 != null ? numOfDigits2.equals(numOfDigits3) : numOfDigits3 == null;
    }

    public String getDigits() {
        return this.digits;
    }

    public String getNumOfDigits() {
        return this.numOfDigits;
    }

    public String getPercentage() {
        return this.percentage;
    }

    public int hashCode() {
        String percentage2 = getPercentage();
        int i11 = 43;
        int hashCode = percentage2 == null ? 43 : percentage2.hashCode();
        String digits2 = getDigits();
        int hashCode2 = ((hashCode + 59) * 59) + (digits2 == null ? 43 : digits2.hashCode());
        String numOfDigits2 = getNumOfDigits();
        int i12 = hashCode2 * 59;
        if (numOfDigits2 != null) {
            i11 = numOfDigits2.hashCode();
        }
        return i12 + i11;
    }

    public void setDigits(String str) {
        this.digits = str;
    }

    public void setNumOfDigits(String str) {
        this.numOfDigits = str;
    }

    public void setPercentage(String str) {
        this.percentage = str;
    }

    public String toString() {
        return "PrimeBidResultDetail(percentage=" + getPercentage() + ", digits=" + getDigits() + ", numOfDigits=" + getNumOfDigits() + ")";
    }
}
