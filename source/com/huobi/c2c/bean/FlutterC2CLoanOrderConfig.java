package com.huobi.c2c.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean;
import java.io.Serializable;
import java.util.List;

public class FlutterC2CLoanOrderConfig implements Serializable {
    @SerializedName("c2c_currency_config")
    public List<C2CCurrencyBean> c2cCurrencyList;
    @SerializedName("currency")
    public String currency;
    @SerializedName("order_type")
    public int orderType;

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterC2CLoanOrderConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterC2CLoanOrderConfig)) {
            return false;
        }
        FlutterC2CLoanOrderConfig flutterC2CLoanOrderConfig = (FlutterC2CLoanOrderConfig) obj;
        if (!flutterC2CLoanOrderConfig.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = flutterC2CLoanOrderConfig.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        List<C2CCurrencyBean> c2cCurrencyList2 = getC2cCurrencyList();
        List<C2CCurrencyBean> c2cCurrencyList3 = flutterC2CLoanOrderConfig.getC2cCurrencyList();
        if (c2cCurrencyList2 != null ? c2cCurrencyList2.equals(c2cCurrencyList3) : c2cCurrencyList3 == null) {
            return getOrderType() == flutterC2CLoanOrderConfig.getOrderType();
        }
        return false;
    }

    public List<C2CCurrencyBean> getC2cCurrencyList() {
        return this.c2cCurrencyList;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        List<C2CCurrencyBean> c2cCurrencyList2 = getC2cCurrencyList();
        int i12 = (hashCode + 59) * 59;
        if (c2cCurrencyList2 != null) {
            i11 = c2cCurrencyList2.hashCode();
        }
        return ((i12 + i11) * 59) + getOrderType();
    }

    public void setC2cCurrencyList(List<C2CCurrencyBean> list) {
        this.c2cCurrencyList = list;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setOrderType(int i11) {
        this.orderType = i11;
    }

    public String toString() {
        return "FlutterC2CLoanOrderConfig(currency=" + getCurrency() + ", c2cCurrencyList=" + getC2cCurrencyList() + ", orderType=" + getOrderType() + ")";
    }
}
