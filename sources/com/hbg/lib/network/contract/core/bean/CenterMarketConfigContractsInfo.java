package com.hbg.lib.network.contract.core.bean;

import java.io.Serializable;
import java.util.List;

public class CenterMarketConfigContractsInfo implements Serializable {
    private static final long serialVersionUID = 8517765260729813482L;
    private List<String> symbols;

    public boolean canEqual(Object obj) {
        return obj instanceof CenterMarketConfigContractsInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CenterMarketConfigContractsInfo)) {
            return false;
        }
        CenterMarketConfigContractsInfo centerMarketConfigContractsInfo = (CenterMarketConfigContractsInfo) obj;
        if (!centerMarketConfigContractsInfo.canEqual(this)) {
            return false;
        }
        List<String> symbols2 = getSymbols();
        List<String> symbols3 = centerMarketConfigContractsInfo.getSymbols();
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
        return "CenterMarketConfigContractsInfo(symbols=" + getSymbols() + ")";
    }
}
