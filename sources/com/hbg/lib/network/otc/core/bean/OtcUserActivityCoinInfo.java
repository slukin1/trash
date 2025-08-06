package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcUserActivityCoinInfo implements Serializable {
    private String coinName;
    private String name;
    private double quantity;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcUserActivityCoinInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcUserActivityCoinInfo)) {
            return false;
        }
        OtcUserActivityCoinInfo otcUserActivityCoinInfo = (OtcUserActivityCoinInfo) obj;
        if (!otcUserActivityCoinInfo.canEqual(this)) {
            return false;
        }
        String coinName2 = getCoinName();
        String coinName3 = otcUserActivityCoinInfo.getCoinName();
        if (coinName2 != null ? !coinName2.equals(coinName3) : coinName3 != null) {
            return false;
        }
        String name2 = getName();
        String name3 = otcUserActivityCoinInfo.getName();
        if (name2 != null ? name2.equals(name3) : name3 == null) {
            return Double.compare(getQuantity(), otcUserActivityCoinInfo.getQuantity()) == 0 && getType() == otcUserActivityCoinInfo.getType();
        }
        return false;
    }

    public String getCoinName() {
        return this.coinName;
    }

    public String getName() {
        return this.name;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String coinName2 = getCoinName();
        int i11 = 43;
        int hashCode = coinName2 == null ? 43 : coinName2.hashCode();
        String name2 = getName();
        int i12 = (hashCode + 59) * 59;
        if (name2 != null) {
            i11 = name2.hashCode();
        }
        long doubleToLongBits = Double.doubleToLongBits(getQuantity());
        return ((((i12 + i11) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 59) + getType();
    }

    public void setCoinName(String str) {
        this.coinName = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setQuantity(double d11) {
        this.quantity = d11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "OtcUserActivityCoinInfo(coinName=" + getCoinName() + ", name=" + getName() + ", quantity=" + getQuantity() + ", type=" + getType() + ")";
    }
}
