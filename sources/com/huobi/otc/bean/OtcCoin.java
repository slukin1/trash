package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcCoin implements Serializable {
    public int coinId;
    public String coinName;
    public String name = "";

    public OtcCoin() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcCoin;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcCoin)) {
            return false;
        }
        OtcCoin otcCoin = (OtcCoin) obj;
        if (!otcCoin.canEqual(this) || getCoinId() != otcCoin.getCoinId()) {
            return false;
        }
        String coinName2 = getCoinName();
        String coinName3 = otcCoin.getCoinName();
        if (coinName2 != null ? !coinName2.equals(coinName3) : coinName3 != null) {
            return false;
        }
        String name2 = getName();
        String name3 = otcCoin.getName();
        return name2 != null ? name2.equals(name3) : name3 == null;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public String getCoinName() {
        return this.coinName;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String coinName2 = getCoinName();
        int i11 = 43;
        int coinId2 = ((getCoinId() + 59) * 59) + (coinName2 == null ? 43 : coinName2.hashCode());
        String name2 = getName();
        int i12 = coinId2 * 59;
        if (name2 != null) {
            i11 = name2.hashCode();
        }
        return i12 + i11;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setCoinName(String str) {
        this.coinName = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "OtcCoin(coinId=" + getCoinId() + ", coinName=" + getCoinName() + ", name=" + getName() + ")";
    }

    public OtcCoin(int i11, String str, String str2) {
        this.coinId = i11;
        this.coinName = str;
        this.name = str2;
    }
}
