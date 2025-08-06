package com.huobi.litere.trade.callback;

import java.io.Serializable;

public class OtcBalanceDataItem implements Serializable {
    private double borrow;
    private int coinId;
    private int coinType;
    private double frozen;
    private double total;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcBalanceDataItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcBalanceDataItem)) {
            return false;
        }
        OtcBalanceDataItem otcBalanceDataItem = (OtcBalanceDataItem) obj;
        return otcBalanceDataItem.canEqual(this) && getCoinId() == otcBalanceDataItem.getCoinId() && Double.compare(getTotal(), otcBalanceDataItem.getTotal()) == 0 && Double.compare(getFrozen(), otcBalanceDataItem.getFrozen()) == 0 && Double.compare(getBorrow(), otcBalanceDataItem.getBorrow()) == 0 && getCoinType() == otcBalanceDataItem.getCoinType();
    }

    public double getBorrow() {
        return this.borrow;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public int getCoinType() {
        return this.coinType;
    }

    public double getFrozen() {
        return this.frozen;
    }

    public double getTotal() {
        return this.total;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(getTotal());
        int coinId2 = ((getCoinId() + 59) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(getFrozen());
        int i11 = (coinId2 * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(getBorrow());
        return (((i11 * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 59) + getCoinType();
    }

    public void setBorrow(double d11) {
        this.borrow = d11;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setCoinType(int i11) {
        this.coinType = i11;
    }

    public void setFrozen(double d11) {
        this.frozen = d11;
    }

    public void setTotal(double d11) {
        this.total = d11;
    }

    public String toString() {
        return "OtcBalanceDataItem(coinId=" + getCoinId() + ", total=" + getTotal() + ", frozen=" + getFrozen() + ", borrow=" + getBorrow() + ", coinType=" + getCoinType() + ")";
    }
}
