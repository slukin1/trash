package com.hbg.lib.network.contract.core.bean;

import java.io.Serializable;
import java.util.List;

public class ContractSettlementPrice implements Serializable {
    private static final long serialVersionUID = -3870413815842451207L;
    private List<ContractSettlementPriceInfo> list;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractSettlementPrice;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractSettlementPrice)) {
            return false;
        }
        ContractSettlementPrice contractSettlementPrice = (ContractSettlementPrice) obj;
        if (!contractSettlementPrice.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractSettlementPrice.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        List<ContractSettlementPriceInfo> list2 = getList();
        List<ContractSettlementPriceInfo> list3 = contractSettlementPrice.getList();
        return list2 != null ? list2.equals(list3) : list3 == null;
    }

    public List<ContractSettlementPriceInfo> getList() {
        return this.list;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        List<ContractSettlementPriceInfo> list2 = getList();
        int i12 = (hashCode + 59) * 59;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return i12 + i11;
    }

    public void setList(List<ContractSettlementPriceInfo> list2) {
        this.list = list2;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "ContractSettlementPrice(symbol=" + getSymbol() + ", list=" + getList() + ")";
    }
}
