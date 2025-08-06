package com.huobi.trade.prime.bean;

import java.io.Serializable;

public class PrimeAveragePosition implements Serializable {
    public static final int USER_PRIME_IDENTITY_NORMAL = 0;
    public static final int USER_PRIME_IDENTITY_SPECIAL = 1;
    private static final long serialVersionUID = -8162197513269411572L;
    private int averagePosition;
    private int level;
    private String maxAccumulatedBuyableQuota;
    private int needAmount;
    private int primeIdentity;
    private boolean qualify;
    private boolean whiteList;

    public boolean canEqual(Object obj) {
        return obj instanceof PrimeAveragePosition;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimeAveragePosition)) {
            return false;
        }
        PrimeAveragePosition primeAveragePosition = (PrimeAveragePosition) obj;
        if (!primeAveragePosition.canEqual(this) || getAveragePosition() != primeAveragePosition.getAveragePosition() || isQualify() != primeAveragePosition.isQualify() || isWhiteList() != primeAveragePosition.isWhiteList() || getNeedAmount() != primeAveragePosition.getNeedAmount() || getPrimeIdentity() != primeAveragePosition.getPrimeIdentity()) {
            return false;
        }
        String maxAccumulatedBuyableQuota2 = getMaxAccumulatedBuyableQuota();
        String maxAccumulatedBuyableQuota3 = primeAveragePosition.getMaxAccumulatedBuyableQuota();
        if (maxAccumulatedBuyableQuota2 != null ? maxAccumulatedBuyableQuota2.equals(maxAccumulatedBuyableQuota3) : maxAccumulatedBuyableQuota3 == null) {
            return getLevel() == primeAveragePosition.getLevel();
        }
        return false;
    }

    public int getAveragePosition() {
        return this.averagePosition;
    }

    public int getLevel() {
        return this.level;
    }

    public String getMaxAccumulatedBuyableQuota() {
        return this.maxAccumulatedBuyableQuota;
    }

    public int getNeedAmount() {
        return this.needAmount;
    }

    public int getPrimeIdentity() {
        return this.primeIdentity;
    }

    public int hashCode() {
        int i11 = 79;
        int averagePosition2 = (((getAveragePosition() + 59) * 59) + (isQualify() ? 79 : 97)) * 59;
        if (!isWhiteList()) {
            i11 = 97;
        }
        int needAmount2 = ((((averagePosition2 + i11) * 59) + getNeedAmount()) * 59) + getPrimeIdentity();
        String maxAccumulatedBuyableQuota2 = getMaxAccumulatedBuyableQuota();
        return (((needAmount2 * 59) + (maxAccumulatedBuyableQuota2 == null ? 43 : maxAccumulatedBuyableQuota2.hashCode())) * 59) + getLevel();
    }

    public PrimeAveragePosition initTestData() {
        setQualify(true);
        setMaxAccumulatedBuyableQuota("10000");
        return this;
    }

    public boolean isQualify() {
        return this.qualify;
    }

    public boolean isWhiteList() {
        return this.whiteList;
    }

    public void setAveragePosition(int i11) {
        this.averagePosition = i11;
    }

    public void setLevel(int i11) {
        this.level = i11;
    }

    public void setMaxAccumulatedBuyableQuota(String str) {
        this.maxAccumulatedBuyableQuota = str;
    }

    public void setNeedAmount(int i11) {
        this.needAmount = i11;
    }

    public void setPrimeIdentity(int i11) {
        this.primeIdentity = i11;
    }

    public void setQualify(boolean z11) {
        this.qualify = z11;
    }

    public void setWhiteList(boolean z11) {
        this.whiteList = z11;
    }

    public String toString() {
        return "PrimeAveragePosition(averagePosition=" + getAveragePosition() + ", qualify=" + isQualify() + ", whiteList=" + isWhiteList() + ", needAmount=" + getNeedAmount() + ", primeIdentity=" + getPrimeIdentity() + ", maxAccumulatedBuyableQuota=" + getMaxAccumulatedBuyableQuota() + ", level=" + getLevel() + ")";
    }
}
