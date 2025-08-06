package com.hbg.lib.network.contract.core.bean;

import java.io.Serializable;
import java.util.List;

public class ContractUserOrderLimitSymbol implements Serializable {
    private static final long serialVersionUID = -8513617346309039774L;
    private String symbol;
    private List<ContractUserOrderLimitType> types;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractUserOrderLimitSymbol;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractUserOrderLimitSymbol)) {
            return false;
        }
        ContractUserOrderLimitSymbol contractUserOrderLimitSymbol = (ContractUserOrderLimitSymbol) obj;
        if (!contractUserOrderLimitSymbol.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractUserOrderLimitSymbol.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        List<ContractUserOrderLimitType> types2 = getTypes();
        List<ContractUserOrderLimitType> types3 = contractUserOrderLimitSymbol.getTypes();
        return types2 != null ? types2.equals(types3) : types3 == null;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public List<ContractUserOrderLimitType> getTypes() {
        return this.types;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        List<ContractUserOrderLimitType> types2 = getTypes();
        int i12 = (hashCode + 59) * 59;
        if (types2 != null) {
            i11 = types2.hashCode();
        }
        return i12 + i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTypes(List<ContractUserOrderLimitType> list) {
        this.types = list;
    }

    public String toString() {
        return "ContractUserOrderLimitSymbol(symbol=" + getSymbol() + ", types=" + getTypes() + ")";
    }
}
