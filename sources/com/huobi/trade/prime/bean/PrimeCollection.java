package com.huobi.trade.prime.bean;

import com.hbg.lib.data.symbol.PrimeInfo;
import java.io.Serializable;

public class PrimeCollection implements Serializable {
    private String limit;
    private PrimeAveragePosition primeAveragePosition;
    private PrimeInfo primeInfo;

    public PrimeCollection(PrimeInfo primeInfo2, String str, PrimeAveragePosition primeAveragePosition2) {
        this.primeInfo = primeInfo2;
        this.limit = str;
        this.primeAveragePosition = primeAveragePosition2;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PrimeCollection;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimeCollection)) {
            return false;
        }
        PrimeCollection primeCollection = (PrimeCollection) obj;
        if (!primeCollection.canEqual(this)) {
            return false;
        }
        PrimeInfo primeInfo2 = getPrimeInfo();
        PrimeInfo primeInfo3 = primeCollection.getPrimeInfo();
        if (primeInfo2 != null ? !primeInfo2.equals(primeInfo3) : primeInfo3 != null) {
            return false;
        }
        String limit2 = getLimit();
        String limit3 = primeCollection.getLimit();
        if (limit2 != null ? !limit2.equals(limit3) : limit3 != null) {
            return false;
        }
        PrimeAveragePosition primeAveragePosition2 = getPrimeAveragePosition();
        PrimeAveragePosition primeAveragePosition3 = primeCollection.getPrimeAveragePosition();
        return primeAveragePosition2 != null ? primeAveragePosition2.equals(primeAveragePosition3) : primeAveragePosition3 == null;
    }

    public String getLimit() {
        return this.limit;
    }

    public PrimeAveragePosition getPrimeAveragePosition() {
        return this.primeAveragePosition;
    }

    public PrimeInfo getPrimeInfo() {
        return this.primeInfo;
    }

    public int hashCode() {
        PrimeInfo primeInfo2 = getPrimeInfo();
        int i11 = 43;
        int hashCode = primeInfo2 == null ? 43 : primeInfo2.hashCode();
        String limit2 = getLimit();
        int hashCode2 = ((hashCode + 59) * 59) + (limit2 == null ? 43 : limit2.hashCode());
        PrimeAveragePosition primeAveragePosition2 = getPrimeAveragePosition();
        int i12 = hashCode2 * 59;
        if (primeAveragePosition2 != null) {
            i11 = primeAveragePosition2.hashCode();
        }
        return i12 + i11;
    }

    public void setLimit(String str) {
        this.limit = str;
    }

    public void setPrimeAveragePosition(PrimeAveragePosition primeAveragePosition2) {
        this.primeAveragePosition = primeAveragePosition2;
    }

    public void setPrimeInfo(PrimeInfo primeInfo2) {
        this.primeInfo = primeInfo2;
    }

    public String toString() {
        return "PrimeCollection(primeInfo=" + getPrimeInfo() + ", limit=" + getLimit() + ", primeAveragePosition=" + getPrimeAveragePosition() + ")";
    }
}
