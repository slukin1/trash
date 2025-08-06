package com.huobi.option.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class FlutterOptionConfig implements Serializable {
    @SerializedName("symbol")
    private String curSymbol;
    @SerializedName("is_option_coin")
    private boolean isOptionCoin;
    @SerializedName("is_red_rise_green_fall")
    private boolean isRedRiseGreenFall;
    @SerializedName("option_currency_list")
    private List<FlutterOptionCurrencyInfo> optionCurrencyList;
    @SerializedName("show_order_type")
    private int showOrderType;

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterOptionConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterOptionConfig)) {
            return false;
        }
        FlutterOptionConfig flutterOptionConfig = (FlutterOptionConfig) obj;
        if (!flutterOptionConfig.canEqual(this) || getShowOrderType() != flutterOptionConfig.getShowOrderType() || isOptionCoin() != flutterOptionConfig.isOptionCoin() || isRedRiseGreenFall() != flutterOptionConfig.isRedRiseGreenFall()) {
            return false;
        }
        String curSymbol2 = getCurSymbol();
        String curSymbol3 = flutterOptionConfig.getCurSymbol();
        if (curSymbol2 != null ? !curSymbol2.equals(curSymbol3) : curSymbol3 != null) {
            return false;
        }
        List<FlutterOptionCurrencyInfo> optionCurrencyList2 = getOptionCurrencyList();
        List<FlutterOptionCurrencyInfo> optionCurrencyList3 = flutterOptionConfig.getOptionCurrencyList();
        return optionCurrencyList2 != null ? optionCurrencyList2.equals(optionCurrencyList3) : optionCurrencyList3 == null;
    }

    public String getCurSymbol() {
        return this.curSymbol;
    }

    public List<FlutterOptionCurrencyInfo> getOptionCurrencyList() {
        return this.optionCurrencyList;
    }

    public int getShowOrderType() {
        return this.showOrderType;
    }

    public int hashCode() {
        int i11 = 79;
        int showOrderType2 = (((getShowOrderType() + 59) * 59) + (isOptionCoin() ? 79 : 97)) * 59;
        if (!isRedRiseGreenFall()) {
            i11 = 97;
        }
        String curSymbol2 = getCurSymbol();
        int i12 = (showOrderType2 + i11) * 59;
        int i13 = 43;
        int hashCode = i12 + (curSymbol2 == null ? 43 : curSymbol2.hashCode());
        List<FlutterOptionCurrencyInfo> optionCurrencyList2 = getOptionCurrencyList();
        int i14 = hashCode * 59;
        if (optionCurrencyList2 != null) {
            i13 = optionCurrencyList2.hashCode();
        }
        return i14 + i13;
    }

    public boolean isOptionCoin() {
        return this.isOptionCoin;
    }

    public boolean isRedRiseGreenFall() {
        return this.isRedRiseGreenFall;
    }

    public void setCurSymbol(String str) {
        this.curSymbol = str;
    }

    public void setOptionCoin(boolean z11) {
        this.isOptionCoin = z11;
    }

    public void setOptionCurrencyList(List<FlutterOptionCurrencyInfo> list) {
        this.optionCurrencyList = list;
    }

    public void setRedRiseGreenFall(boolean z11) {
        this.isRedRiseGreenFall = z11;
    }

    public void setShowOrderType(int i11) {
        this.showOrderType = i11;
    }

    public String toString() {
        return "FlutterOptionConfig(showOrderType=" + getShowOrderType() + ", isOptionCoin=" + isOptionCoin() + ", isRedRiseGreenFall=" + isRedRiseGreenFall() + ", curSymbol=" + getCurSymbol() + ", optionCurrencyList=" + getOptionCurrencyList() + ")";
    }
}
