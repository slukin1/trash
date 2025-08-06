package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class MineAccountItem implements Serializable {
    private static final int TRANSFERABLE_OK = 1;
    private String currency;
    private int transferable;

    public boolean canEqual(Object obj) {
        return obj instanceof MineAccountItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MineAccountItem)) {
            return false;
        }
        MineAccountItem mineAccountItem = (MineAccountItem) obj;
        if (!mineAccountItem.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = mineAccountItem.getCurrency();
        if (currency2 != null ? currency2.equals(currency3) : currency3 == null) {
            return getTransferable() == mineAccountItem.getTransferable();
        }
        return false;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getTransferable() {
        return this.transferable;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        return (((currency2 == null ? 43 : currency2.hashCode()) + 59) * 59) + getTransferable();
    }

    public boolean isTransferable() {
        return this.transferable == 1;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setTransferable(int i11) {
        this.transferable = i11;
    }

    public String toString() {
        return "MineAccountItem(currency=" + getCurrency() + ", transferable=" + getTransferable() + ")";
    }
}
