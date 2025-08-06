package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class UnionSupportCurrency implements Serializable {
    @SerializedName("multi_assets")
    private List<String> currencyList;

    public boolean canEqual(Object obj) {
        return obj instanceof UnionSupportCurrency;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnionSupportCurrency)) {
            return false;
        }
        UnionSupportCurrency unionSupportCurrency = (UnionSupportCurrency) obj;
        if (!unionSupportCurrency.canEqual(this)) {
            return false;
        }
        List<String> currencyList2 = getCurrencyList();
        List<String> currencyList3 = unionSupportCurrency.getCurrencyList();
        return currencyList2 != null ? currencyList2.equals(currencyList3) : currencyList3 == null;
    }

    public List<String> getCurrencyList() {
        return this.currencyList;
    }

    public int hashCode() {
        List<String> currencyList2 = getCurrencyList();
        return 59 + (currencyList2 == null ? 43 : currencyList2.hashCode());
    }

    public void setCurrencyList(List<String> list) {
        this.currencyList = list;
    }

    public String toString() {
        return "UnionSupportCurrency(currencyList=" + getCurrencyList() + ")";
    }
}
