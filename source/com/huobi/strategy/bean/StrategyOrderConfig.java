package com.huobi.strategy.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StrategyOrderConfig implements Serializable {
    @SerializedName("base_currency_list")
    private List<String> baseCurrencyList = new ArrayList();
    @SerializedName("display_base_currency_list")
    private List<String> displayBaseCurrencyList = new ArrayList();
    @SerializedName("display_quote_currency_list")
    private List<String> displayQuoteCurrencyList = new ArrayList();
    @SerializedName("quote_currency_list")
    private List<String> quoteCurrencyList = new ArrayList();

    public boolean canEqual(Object obj) {
        return obj instanceof StrategyOrderConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StrategyOrderConfig)) {
            return false;
        }
        StrategyOrderConfig strategyOrderConfig = (StrategyOrderConfig) obj;
        if (!strategyOrderConfig.canEqual(this)) {
            return false;
        }
        List<String> baseCurrencyList2 = getBaseCurrencyList();
        List<String> baseCurrencyList3 = strategyOrderConfig.getBaseCurrencyList();
        if (baseCurrencyList2 != null ? !baseCurrencyList2.equals(baseCurrencyList3) : baseCurrencyList3 != null) {
            return false;
        }
        List<String> quoteCurrencyList2 = getQuoteCurrencyList();
        List<String> quoteCurrencyList3 = strategyOrderConfig.getQuoteCurrencyList();
        if (quoteCurrencyList2 != null ? !quoteCurrencyList2.equals(quoteCurrencyList3) : quoteCurrencyList3 != null) {
            return false;
        }
        List<String> displayBaseCurrencyList2 = getDisplayBaseCurrencyList();
        List<String> displayBaseCurrencyList3 = strategyOrderConfig.getDisplayBaseCurrencyList();
        if (displayBaseCurrencyList2 != null ? !displayBaseCurrencyList2.equals(displayBaseCurrencyList3) : displayBaseCurrencyList3 != null) {
            return false;
        }
        List<String> displayQuoteCurrencyList2 = getDisplayQuoteCurrencyList();
        List<String> displayQuoteCurrencyList3 = strategyOrderConfig.getDisplayQuoteCurrencyList();
        return displayQuoteCurrencyList2 != null ? displayQuoteCurrencyList2.equals(displayQuoteCurrencyList3) : displayQuoteCurrencyList3 == null;
    }

    public List<String> getBaseCurrencyList() {
        return this.baseCurrencyList;
    }

    public List<String> getDisplayBaseCurrencyList() {
        return this.displayBaseCurrencyList;
    }

    public List<String> getDisplayQuoteCurrencyList() {
        return this.displayQuoteCurrencyList;
    }

    public List<String> getQuoteCurrencyList() {
        return this.quoteCurrencyList;
    }

    public int hashCode() {
        List<String> baseCurrencyList2 = getBaseCurrencyList();
        int i11 = 43;
        int hashCode = baseCurrencyList2 == null ? 43 : baseCurrencyList2.hashCode();
        List<String> quoteCurrencyList2 = getQuoteCurrencyList();
        int hashCode2 = ((hashCode + 59) * 59) + (quoteCurrencyList2 == null ? 43 : quoteCurrencyList2.hashCode());
        List<String> displayBaseCurrencyList2 = getDisplayBaseCurrencyList();
        int hashCode3 = (hashCode2 * 59) + (displayBaseCurrencyList2 == null ? 43 : displayBaseCurrencyList2.hashCode());
        List<String> displayQuoteCurrencyList2 = getDisplayQuoteCurrencyList();
        int i12 = hashCode3 * 59;
        if (displayQuoteCurrencyList2 != null) {
            i11 = displayQuoteCurrencyList2.hashCode();
        }
        return i12 + i11;
    }

    public void setBaseCurrencyList(List<String> list) {
        this.baseCurrencyList = list;
    }

    public void setDisplayBaseCurrencyList(List<String> list) {
        this.displayBaseCurrencyList = list;
    }

    public void setDisplayQuoteCurrencyList(List<String> list) {
        this.displayQuoteCurrencyList = list;
    }

    public void setQuoteCurrencyList(List<String> list) {
        this.quoteCurrencyList = list;
    }

    public String toString() {
        return "StrategyOrderConfig(baseCurrencyList=" + getBaseCurrencyList() + ", quoteCurrencyList=" + getQuoteCurrencyList() + ", displayBaseCurrencyList=" + getDisplayBaseCurrencyList() + ", displayQuoteCurrencyList=" + getDisplayQuoteCurrencyList() + ")";
    }
}
