package com.huobi.otcoption.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class OtcOptionsOrderData implements Serializable {
    private static final long serialVersionUID = 2927755357573838499L;
    @SerializedName("currency")
    public String currency;
    @SerializedName("currency_list")
    private List<String> currencyList;
    @SerializedName("open_order_loss")
    public String openOrderLoss;
    @SerializedName("productType")
    public int productType;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcOptionsOrderData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOptionsOrderData)) {
            return false;
        }
        OtcOptionsOrderData otcOptionsOrderData = (OtcOptionsOrderData) obj;
        if (!otcOptionsOrderData.canEqual(this)) {
            return false;
        }
        List<String> currencyList2 = getCurrencyList();
        List<String> currencyList3 = otcOptionsOrderData.getCurrencyList();
        if (currencyList2 != null ? !currencyList2.equals(currencyList3) : currencyList3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = otcOptionsOrderData.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String openOrderLoss2 = getOpenOrderLoss();
        String openOrderLoss3 = otcOptionsOrderData.getOpenOrderLoss();
        if (openOrderLoss2 != null ? openOrderLoss2.equals(openOrderLoss3) : openOrderLoss3 == null) {
            return getProductType() == otcOptionsOrderData.getProductType();
        }
        return false;
    }

    public String getCurrency() {
        return this.currency;
    }

    public List<String> getCurrencyList() {
        return this.currencyList;
    }

    public String getOpenOrderLoss() {
        return this.openOrderLoss;
    }

    public int getProductType() {
        return this.productType;
    }

    public int hashCode() {
        List<String> currencyList2 = getCurrencyList();
        int i11 = 43;
        int hashCode = currencyList2 == null ? 43 : currencyList2.hashCode();
        String currency2 = getCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String openOrderLoss2 = getOpenOrderLoss();
        int i12 = hashCode2 * 59;
        if (openOrderLoss2 != null) {
            i11 = openOrderLoss2.hashCode();
        }
        return ((i12 + i11) * 59) + getProductType();
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCurrencyList(List<String> list) {
        this.currencyList = list;
    }

    public void setOpenOrderLoss(String str) {
        this.openOrderLoss = str;
    }

    public void setProductType(int i11) {
        this.productType = i11;
    }

    public String toString() {
        return "OtcOptionsOrderData(currencyList=" + getCurrencyList() + ", currency=" + getCurrency() + ", openOrderLoss=" + getOpenOrderLoss() + ", productType=" + getProductType() + ")";
    }
}
