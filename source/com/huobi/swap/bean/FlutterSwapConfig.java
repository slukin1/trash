package com.huobi.swap.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import java.io.Serializable;
import java.util.List;

public class FlutterSwapConfig implements Serializable {
    private static final long serialVersionUID = -5079294461350064681L;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("is_red_rise_green_fall")
    private boolean isRedRiseGreenFall;
    @SerializedName("is_swap_coin")
    private boolean isSwapCoin;
    @SerializedName("page_type")
    private int pageType;
    @SerializedName("show_order_type")
    private int showOrderType;
    @SerializedName("swap_currency_list")
    private List<SwapCurrencyInfo> swapCurrencyList;

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterSwapConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterSwapConfig)) {
            return false;
        }
        FlutterSwapConfig flutterSwapConfig = (FlutterSwapConfig) obj;
        if (!flutterSwapConfig.canEqual(this)) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = flutterSwapConfig.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        if (getShowOrderType() != flutterSwapConfig.getShowOrderType() || isSwapCoin() != flutterSwapConfig.isSwapCoin() || isRedRiseGreenFall() != flutterSwapConfig.isRedRiseGreenFall() || getPageType() != flutterSwapConfig.getPageType()) {
            return false;
        }
        List<SwapCurrencyInfo> swapCurrencyList2 = getSwapCurrencyList();
        List<SwapCurrencyInfo> swapCurrencyList3 = flutterSwapConfig.getSwapCurrencyList();
        return swapCurrencyList2 != null ? swapCurrencyList2.equals(swapCurrencyList3) : swapCurrencyList3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public int getPageType() {
        return this.pageType;
    }

    public int getShowOrderType() {
        return this.showOrderType;
    }

    public List<SwapCurrencyInfo> getSwapCurrencyList() {
        return this.swapCurrencyList;
    }

    public int hashCode() {
        String contractCode2 = getContractCode();
        int i11 = 43;
        int i12 = 79;
        int hashCode = ((((((contractCode2 == null ? 43 : contractCode2.hashCode()) + 59) * 59) + getShowOrderType()) * 59) + (isSwapCoin() ? 79 : 97)) * 59;
        if (!isRedRiseGreenFall()) {
            i12 = 97;
        }
        int pageType2 = ((hashCode + i12) * 59) + getPageType();
        List<SwapCurrencyInfo> swapCurrencyList2 = getSwapCurrencyList();
        int i13 = pageType2 * 59;
        if (swapCurrencyList2 != null) {
            i11 = swapCurrencyList2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isRedRiseGreenFall() {
        return this.isRedRiseGreenFall;
    }

    public boolean isSwapCoin() {
        return this.isSwapCoin;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setPageType(int i11) {
        this.pageType = i11;
    }

    public void setRedRiseGreenFall(boolean z11) {
        this.isRedRiseGreenFall = z11;
    }

    public void setShowOrderType(int i11) {
        this.showOrderType = i11;
    }

    public void setSwapCoin(boolean z11) {
        this.isSwapCoin = z11;
    }

    public void setSwapCurrencyList(List<SwapCurrencyInfo> list) {
        this.swapCurrencyList = list;
    }

    public String toString() {
        return "FlutterSwapConfig(contractCode=" + getContractCode() + ", showOrderType=" + getShowOrderType() + ", isSwapCoin=" + isSwapCoin() + ", isRedRiseGreenFall=" + isRedRiseGreenFall() + ", pageType=" + getPageType() + ", swapCurrencyList=" + getSwapCurrencyList() + ")";
    }
}
