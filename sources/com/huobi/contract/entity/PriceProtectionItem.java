package com.huobi.contract.entity;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.dialog.bean.OrderConfirmBean;

public class PriceProtectionItem extends OrderConfirmBean.ListItem {
    private String contractCode;
    private String contractShortType;
    private String symbol;
    private TradeType tradeType;

    public boolean canEqual(Object obj) {
        return obj instanceof PriceProtectionItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PriceProtectionItem)) {
            return false;
        }
        PriceProtectionItem priceProtectionItem = (PriceProtectionItem) obj;
        if (!priceProtectionItem.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = priceProtectionItem.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = priceProtectionItem.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String contractShortType2 = getContractShortType();
        String contractShortType3 = priceProtectionItem.getContractShortType();
        if (contractShortType2 != null ? !contractShortType2.equals(contractShortType3) : contractShortType3 != null) {
            return false;
        }
        TradeType tradeType2 = getTradeType();
        TradeType tradeType3 = priceProtectionItem.getTradeType();
        return tradeType2 != null ? tradeType2.equals(tradeType3) : tradeType3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractShortType() {
        return this.contractShortType;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public String getViewHandlerName() {
        return "com.huobi.linearswap.viewhandler.PriceProtectionItemHandler";
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode3 = (hashCode2 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String contractShortType2 = getContractShortType();
        int hashCode4 = (hashCode3 * 59) + (contractShortType2 == null ? 43 : contractShortType2.hashCode());
        TradeType tradeType2 = getTradeType();
        int i12 = hashCode4 * 59;
        if (tradeType2 != null) {
            i11 = tradeType2.hashCode();
        }
        return i12 + i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractShortType(String str) {
        this.contractShortType = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }

    public String toString() {
        return "PriceProtectionItem(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", contractShortType=" + getContractShortType() + ", tradeType=" + getTradeType() + ")";
    }
}
