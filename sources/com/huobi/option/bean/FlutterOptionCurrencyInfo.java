package com.huobi.option.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FlutterOptionCurrencyInfo implements Serializable {
    @SerializedName("symbol")
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterOptionCurrencyInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterOptionCurrencyInfo)) {
            return false;
        }
        FlutterOptionCurrencyInfo flutterOptionCurrencyInfo = (FlutterOptionCurrencyInfo) obj;
        if (!flutterOptionCurrencyInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = flutterOptionCurrencyInfo.getSymbol();
        return symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        return 59 + (symbol2 == null ? 43 : symbol2.hashCode());
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "FlutterOptionCurrencyInfo(symbol=" + getSymbol() + ")";
    }
}
