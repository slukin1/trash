package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcCoinBean implements Serializable {
    public int coinId;
    public String coinName;

    public OtcCoinBean() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcCoinBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcCoinBean)) {
            return false;
        }
        OtcCoinBean otcCoinBean = (OtcCoinBean) obj;
        if (!otcCoinBean.canEqual(this) || getCoinId() != otcCoinBean.getCoinId()) {
            return false;
        }
        String coinName2 = getCoinName();
        String coinName3 = otcCoinBean.getCoinName();
        return coinName2 != null ? coinName2.equals(coinName3) : coinName3 == null;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public String getCoinName() {
        return this.coinName;
    }

    public int hashCode() {
        String coinName2 = getCoinName();
        return ((getCoinId() + 59) * 59) + (coinName2 == null ? 43 : coinName2.hashCode());
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setCoinName(String str) {
        this.coinName = str;
    }

    public String toString() {
        return "OtcCoinBean(coinId=" + getCoinId() + ", coinName=" + getCoinName() + ")";
    }

    public OtcCoinBean(int i11, String str) {
        this.coinId = i11;
        this.coinName = str;
    }
}
