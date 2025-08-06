package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class UsdtExchangeRequest implements Serializable {
    private List<String> currency;

    public UsdtExchangeRequest(List<String> list) {
        this.currency = list;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof UsdtExchangeRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UsdtExchangeRequest)) {
            return false;
        }
        UsdtExchangeRequest usdtExchangeRequest = (UsdtExchangeRequest) obj;
        if (!usdtExchangeRequest.canEqual(this)) {
            return false;
        }
        List<String> currency2 = getCurrency();
        List<String> currency3 = usdtExchangeRequest.getCurrency();
        return currency2 != null ? currency2.equals(currency3) : currency3 == null;
    }

    public List<String> getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        List<String> currency2 = getCurrency();
        return 59 + (currency2 == null ? 43 : currency2.hashCode());
    }

    public void setCurrency(List<String> list) {
        this.currency = list;
    }

    public String toString() {
        return "UsdtExchangeRequest(currency=" + getCurrency() + ")";
    }
}
