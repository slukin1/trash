package com.hbg.lib.network.otc.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WalletCoinBean implements Serializable {
    private String borrow;
    private int coinId;
    private String frozen;
    @SerializedName("total")
    private String total;

    public boolean canEqual(Object obj) {
        return obj instanceof WalletCoinBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WalletCoinBean)) {
            return false;
        }
        WalletCoinBean walletCoinBean = (WalletCoinBean) obj;
        if (!walletCoinBean.canEqual(this)) {
            return false;
        }
        String borrow2 = getBorrow();
        String borrow3 = walletCoinBean.getBorrow();
        if (borrow2 != null ? !borrow2.equals(borrow3) : borrow3 != null) {
            return false;
        }
        if (getCoinId() != walletCoinBean.getCoinId()) {
            return false;
        }
        String frozen2 = getFrozen();
        String frozen3 = walletCoinBean.getFrozen();
        if (frozen2 != null ? !frozen2.equals(frozen3) : frozen3 != null) {
            return false;
        }
        String total2 = getTotal();
        String total3 = walletCoinBean.getTotal();
        return total2 != null ? total2.equals(total3) : total3 == null;
    }

    public String getBorrow() {
        return this.borrow;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public String getFrozen() {
        return this.frozen;
    }

    public String getTotal() {
        return this.total;
    }

    public int hashCode() {
        String borrow2 = getBorrow();
        int i11 = 43;
        int hashCode = (((borrow2 == null ? 43 : borrow2.hashCode()) + 59) * 59) + getCoinId();
        String frozen2 = getFrozen();
        int hashCode2 = (hashCode * 59) + (frozen2 == null ? 43 : frozen2.hashCode());
        String total2 = getTotal();
        int i12 = hashCode2 * 59;
        if (total2 != null) {
            i11 = total2.hashCode();
        }
        return i12 + i11;
    }

    public void setBorrow(String str) {
        this.borrow = str;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setFrozen(String str) {
        this.frozen = str;
    }

    public void setTotal(String str) {
        this.total = str;
    }

    public String toString() {
        return "WalletCoinBean(borrow=" + getBorrow() + ", coinId=" + getCoinId() + ", frozen=" + getFrozen() + ", total=" + getTotal() + ")";
    }
}
