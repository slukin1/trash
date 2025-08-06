package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class C2CBorrowExpiredStatistics implements Serializable {
    private int baseCurrencyCount;
    private int quoteCurrencyCount;

    public boolean canEqual(Object obj) {
        return obj instanceof C2CBorrowExpiredStatistics;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CBorrowExpiredStatistics)) {
            return false;
        }
        C2CBorrowExpiredStatistics c2CBorrowExpiredStatistics = (C2CBorrowExpiredStatistics) obj;
        return c2CBorrowExpiredStatistics.canEqual(this) && getQuoteCurrencyCount() == c2CBorrowExpiredStatistics.getQuoteCurrencyCount() && getBaseCurrencyCount() == c2CBorrowExpiredStatistics.getBaseCurrencyCount();
    }

    public int getBaseCurrencyCount() {
        return this.baseCurrencyCount;
    }

    public int getQuoteCurrencyCount() {
        return this.quoteCurrencyCount;
    }

    public int hashCode() {
        return ((getQuoteCurrencyCount() + 59) * 59) + getBaseCurrencyCount();
    }

    public void setBaseCurrencyCount(int i11) {
        this.baseCurrencyCount = i11;
    }

    public void setQuoteCurrencyCount(int i11) {
        this.quoteCurrencyCount = i11;
    }

    public String toString() {
        return "C2CBorrowExpiredStatistics(quoteCurrencyCount=" + getQuoteCurrencyCount() + ", baseCurrencyCount=" + getBaseCurrencyCount() + ")";
    }
}
