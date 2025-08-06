package com.huobi.contract.entity;

import java.io.Serializable;

public class ContractTradeStatus implements Serializable {
    public static final int STATUS_DELIVERY = 0;
    public static final int STATUS_TRADE = 1;
    private int status;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractTradeStatus;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractTradeStatus)) {
            return false;
        }
        ContractTradeStatus contractTradeStatus = (ContractTradeStatus) obj;
        if (!contractTradeStatus.canEqual(this) || getStatus() != contractTradeStatus.getStatus()) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractTradeStatus.getSymbol();
        return symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        return ((getStatus() + 59) * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "ContractTradeStatus(status=" + getStatus() + ", symbol=" + getSymbol() + ")";
    }
}
