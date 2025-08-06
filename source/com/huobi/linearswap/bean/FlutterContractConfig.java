package com.huobi.linearswap.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Set;

public class FlutterContractConfig implements Serializable {
    private static final long serialVersionUID = -5079294461350064681L;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_currency_list")
    private Set<String> contractCurrencyList;
    @SerializedName("is_red_rise_green_fall")
    private boolean isRedRiseGreenFall;
    @SerializedName("is_contract_coin")
    private boolean isSwapCoin;
    @SerializedName("page_type")
    private int pageType;
    @SerializedName("show_order_model")
    private int showOrderModel;
    @SerializedName("show_order_type")
    private int showOrderType;
    @SerializedName("symbol")
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterContractConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterContractConfig)) {
            return false;
        }
        FlutterContractConfig flutterContractConfig = (FlutterContractConfig) obj;
        if (!flutterContractConfig.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = flutterContractConfig.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = flutterContractConfig.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        if (getShowOrderType() != flutterContractConfig.getShowOrderType() || isSwapCoin() != flutterContractConfig.isSwapCoin() || isRedRiseGreenFall() != flutterContractConfig.isRedRiseGreenFall() || getShowOrderModel() != flutterContractConfig.getShowOrderModel() || getPageType() != flutterContractConfig.getPageType()) {
            return false;
        }
        Set<String> contractCurrencyList2 = getContractCurrencyList();
        Set<String> contractCurrencyList3 = flutterContractConfig.getContractCurrencyList();
        return contractCurrencyList2 != null ? contractCurrencyList2.equals(contractCurrencyList3) : contractCurrencyList3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public Set<String> getContractCurrencyList() {
        return this.contractCurrencyList;
    }

    public int getPageType() {
        return this.pageType;
    }

    public int getShowOrderModel() {
        return this.showOrderModel;
    }

    public int getShowOrderType() {
        return this.showOrderType;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractCode2 = getContractCode();
        int i12 = 79;
        int hashCode2 = (((((((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode())) * 59) + getShowOrderType()) * 59) + (isSwapCoin() ? 79 : 97)) * 59;
        if (!isRedRiseGreenFall()) {
            i12 = 97;
        }
        int showOrderModel2 = ((((hashCode2 + i12) * 59) + getShowOrderModel()) * 59) + getPageType();
        Set<String> contractCurrencyList2 = getContractCurrencyList();
        int i13 = showOrderModel2 * 59;
        if (contractCurrencyList2 != null) {
            i11 = contractCurrencyList2.hashCode();
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

    public void setContractCurrencyList(Set<String> set) {
        this.contractCurrencyList = set;
    }

    public void setPageType(int i11) {
        this.pageType = i11;
    }

    public void setRedRiseGreenFall(boolean z11) {
        this.isRedRiseGreenFall = z11;
    }

    public void setShowOrderModel(int i11) {
        this.showOrderModel = i11;
    }

    public void setShowOrderType(int i11) {
        this.showOrderType = i11;
    }

    public void setSwapCoin(boolean z11) {
        this.isSwapCoin = z11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "FlutterContractConfig(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", showOrderType=" + getShowOrderType() + ", isSwapCoin=" + isSwapCoin() + ", isRedRiseGreenFall=" + isRedRiseGreenFall() + ", showOrderModel=" + getShowOrderModel() + ", pageType=" + getPageType() + ", contractCurrencyList=" + getContractCurrencyList() + ")";
    }
}
