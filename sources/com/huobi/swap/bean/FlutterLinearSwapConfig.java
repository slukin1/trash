package com.huobi.swap.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import java.io.Serializable;
import java.util.List;

public class FlutterLinearSwapConfig implements Serializable {
    private static final long serialVersionUID = -5079294461350064681L;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("is_red_rise_green_fall")
    private boolean isRedRiseGreenFall;
    @SerializedName("linear_swap_currency_list")
    private List<LinearSwapContractInfo> linearSwapCurrencyList;
    @SerializedName("page_type")
    private int pageType;
    @SerializedName("show_order_mode")
    private int showOrderMode;
    @SerializedName("show_order_type")
    private int showOrderType;
    @SerializedName("unit_type")
    private int unit;

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterLinearSwapConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterLinearSwapConfig)) {
            return false;
        }
        FlutterLinearSwapConfig flutterLinearSwapConfig = (FlutterLinearSwapConfig) obj;
        if (!flutterLinearSwapConfig.canEqual(this)) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = flutterLinearSwapConfig.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        if (getShowOrderType() != flutterLinearSwapConfig.getShowOrderType() || getUnit() != flutterLinearSwapConfig.getUnit() || isRedRiseGreenFall() != flutterLinearSwapConfig.isRedRiseGreenFall() || getShowOrderMode() != flutterLinearSwapConfig.getShowOrderMode() || getPageType() != flutterLinearSwapConfig.getPageType()) {
            return false;
        }
        List<LinearSwapContractInfo> linearSwapCurrencyList2 = getLinearSwapCurrencyList();
        List<LinearSwapContractInfo> linearSwapCurrencyList3 = flutterLinearSwapConfig.getLinearSwapCurrencyList();
        return linearSwapCurrencyList2 != null ? linearSwapCurrencyList2.equals(linearSwapCurrencyList3) : linearSwapCurrencyList3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public List<LinearSwapContractInfo> getLinearSwapCurrencyList() {
        return this.linearSwapCurrencyList;
    }

    public int getPageType() {
        return this.pageType;
    }

    public int getShowOrderMode() {
        return this.showOrderMode;
    }

    public int getShowOrderType() {
        return this.showOrderType;
    }

    public int getUnit() {
        return this.unit;
    }

    public int hashCode() {
        String contractCode2 = getContractCode();
        int i11 = 43;
        int hashCode = (((((((((((contractCode2 == null ? 43 : contractCode2.hashCode()) + 59) * 59) + getShowOrderType()) * 59) + getUnit()) * 59) + (isRedRiseGreenFall() ? 79 : 97)) * 59) + getShowOrderMode()) * 59) + getPageType();
        List<LinearSwapContractInfo> linearSwapCurrencyList2 = getLinearSwapCurrencyList();
        int i12 = hashCode * 59;
        if (linearSwapCurrencyList2 != null) {
            i11 = linearSwapCurrencyList2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isRedRiseGreenFall() {
        return this.isRedRiseGreenFall;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setLinearSwapCurrencyList(List<LinearSwapContractInfo> list) {
        this.linearSwapCurrencyList = list;
    }

    public void setPageType(int i11) {
        this.pageType = i11;
    }

    public void setRedRiseGreenFall(boolean z11) {
        this.isRedRiseGreenFall = z11;
    }

    public void setShowOrderMode(int i11) {
        this.showOrderMode = i11;
    }

    public void setShowOrderType(int i11) {
        this.showOrderType = i11;
    }

    public void setUnit(int i11) {
        this.unit = i11;
    }

    public String toString() {
        return "FlutterLinearSwapConfig(contractCode=" + getContractCode() + ", showOrderType=" + getShowOrderType() + ", unit=" + getUnit() + ", isRedRiseGreenFall=" + isRedRiseGreenFall() + ", showOrderMode=" + getShowOrderMode() + ", pageType=" + getPageType() + ", linearSwapCurrencyList=" + getLinearSwapCurrencyList() + ")";
    }
}
