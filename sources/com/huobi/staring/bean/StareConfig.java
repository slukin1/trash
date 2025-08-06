package com.huobi.staring.bean;

import java.io.Serializable;
import java.util.List;

public class StareConfig implements Serializable {
    private List<String> symbols;

    public boolean canEqual(Object obj) {
        return obj instanceof StareConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StareConfig)) {
            return false;
        }
        StareConfig stareConfig = (StareConfig) obj;
        if (!stareConfig.canEqual(this)) {
            return false;
        }
        List<String> symbols2 = getSymbols();
        List<String> symbols3 = stareConfig.getSymbols();
        return symbols2 != null ? symbols2.equals(symbols3) : symbols3 == null;
    }

    public List<String> getSymbols() {
        return this.symbols;
    }

    public int hashCode() {
        List<String> symbols2 = getSymbols();
        return 59 + (symbols2 == null ? 43 : symbols2.hashCode());
    }

    public void setSymbols(List<String> list) {
        this.symbols = list;
    }

    public String toString() {
        return "StareConfig(symbols=" + getSymbols() + ")";
    }
}
