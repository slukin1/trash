package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class PrimeKycLimit implements Serializable {
    public static final int BLACK_STATE_KYC = 2;
    public static final int BLACK_STATE_NOT = 0;
    public static final int BLACK_STATE_REGISTER = 1;
    public static final int KYC_STATE_NEED = 1;
    public static final int KYC_STATE_NOT = 0;
    public static final int KYC_STATE_SENIOR_NEED = 2;
    private static final long serialVersionUID = -2649091659262384692L;
    private int blackKycType;
    private int kyc;

    public boolean canEqual(Object obj) {
        return obj instanceof PrimeKycLimit;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimeKycLimit)) {
            return false;
        }
        PrimeKycLimit primeKycLimit = (PrimeKycLimit) obj;
        return primeKycLimit.canEqual(this) && getKyc() == primeKycLimit.getKyc() && getBlackKycType() == primeKycLimit.getBlackKycType();
    }

    public int getBlackKycType() {
        return this.blackKycType;
    }

    public int getKyc() {
        return this.kyc;
    }

    public int hashCode() {
        return ((getKyc() + 59) * 59) + getBlackKycType();
    }

    public void setBlackKycType(int i11) {
        this.blackKycType = i11;
    }

    public void setKyc(int i11) {
        this.kyc = i11;
    }

    public String toString() {
        return "PrimeKycLimit(kyc=" + getKyc() + ", blackKycType=" + getBlackKycType() + ")";
    }
}
