package com.huobi.staring.bean;

import java.io.Serializable;
import java.util.List;

public class SystemConfig implements Serializable {
    private List<String> symbols;

    public boolean canEqual(Object obj) {
        return obj instanceof SystemConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SystemConfig)) {
            return false;
        }
        SystemConfig systemConfig = (SystemConfig) obj;
        if (!systemConfig.canEqual(this)) {
            return false;
        }
        List<String> symbols2 = getSymbols();
        List<String> symbols3 = systemConfig.getSymbols();
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
        return "SystemConfig(symbols=" + getSymbols() + ")";
    }
}
