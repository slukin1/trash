package com.huobi.staring.bean;

import java.io.Serializable;
import java.util.List;

public class PriceConfig implements Serializable {
    private int priceLimit;
    private List<String> symbols;

    public boolean canEqual(Object obj) {
        return obj instanceof PriceConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PriceConfig)) {
            return false;
        }
        PriceConfig priceConfig = (PriceConfig) obj;
        if (!priceConfig.canEqual(this) || getPriceLimit() != priceConfig.getPriceLimit()) {
            return false;
        }
        List<String> symbols2 = getSymbols();
        List<String> symbols3 = priceConfig.getSymbols();
        return symbols2 != null ? symbols2.equals(symbols3) : symbols3 == null;
    }

    public int getPriceLimit() {
        return this.priceLimit;
    }

    public List<String> getSymbols() {
        return this.symbols;
    }

    public int hashCode() {
        List<String> symbols2 = getSymbols();
        return ((getPriceLimit() + 59) * 59) + (symbols2 == null ? 43 : symbols2.hashCode());
    }

    public void setPriceLimit(int i11) {
        this.priceLimit = i11;
    }

    public void setSymbols(List<String> list) {
        this.symbols = list;
    }

    public String toString() {
        return "PriceConfig(priceLimit=" + getPriceLimit() + ", symbols=" + getSymbols() + ")";
    }
}
