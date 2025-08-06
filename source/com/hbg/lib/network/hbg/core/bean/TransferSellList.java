package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class TransferSellList implements Serializable {
    private String currencys;
    private int isClearRange;

    public boolean canEqual(Object obj) {
        return obj instanceof TransferSellList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransferSellList)) {
            return false;
        }
        TransferSellList transferSellList = (TransferSellList) obj;
        if (!transferSellList.canEqual(this)) {
            return false;
        }
        String currencys2 = getCurrencys();
        String currencys3 = transferSellList.getCurrencys();
        if (currencys2 != null ? currencys2.equals(currencys3) : currencys3 == null) {
            return getIsClearRange() == transferSellList.getIsClearRange();
        }
        return false;
    }

    public String getCurrencys() {
        return this.currencys;
    }

    public int getIsClearRange() {
        return this.isClearRange;
    }

    public int hashCode() {
        String currencys2 = getCurrencys();
        return (((currencys2 == null ? 43 : currencys2.hashCode()) + 59) * 59) + getIsClearRange();
    }

    public void setCurrencys(String str) {
        this.currencys = str;
    }

    public void setIsClearRange(int i11) {
        this.isClearRange = i11;
    }

    public String toString() {
        return "TransferSellList(currencys=" + getCurrencys() + ", isClearRange=" + getIsClearRange() + ")";
    }
}
