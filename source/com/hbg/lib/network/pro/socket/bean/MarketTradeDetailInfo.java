package com.hbg.lib.network.pro.socket.bean;

import java.io.Serializable;

public class MarketTradeDetailInfo implements Serializable {
    public static final String TRADES_TYPE_BUY = "buy";
    public static final String TRADES_TYPE_SELL = "sell";
    private static final long serialVersionUID = 3180429936866984687L;
    private String amount;
    private String contractCode;
    private String contractShortType;
    private String direction;

    /* renamed from: id  reason: collision with root package name */
    private String f70632id;
    private String optionCode;
    private String price;
    private String symbol;
    private long tradeId;

    /* renamed from: ts  reason: collision with root package name */
    private long f70633ts;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f70632id.equals(((MarketTradeDetailInfo) obj).f70632id);
    }

    public String getAmount() {
        return this.amount;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractShortType() {
        return this.contractShortType;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getId() {
        return this.f70632id;
    }

    public String getOptionCode() {
        return this.optionCode;
    }

    public String getPrice() {
        return this.price;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public long getTradeId() {
        return this.tradeId;
    }

    public long getTs() {
        return this.f70633ts;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractShortType(String str) {
        this.contractShortType = str;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setId(String str) {
        this.f70632id = str;
    }

    public void setOptionCode(String str) {
        this.optionCode = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradeId(long j11) {
        this.tradeId = j11;
    }

    public void setTs(long j11) {
        this.f70633ts = j11;
    }

    public String toString() {
        return "MarketTradeDetailInfo(id=" + getId() + ", price=" + getPrice() + ", amount=" + getAmount() + ", direction=" + getDirection() + ", ts=" + getTs() + ", symbol=" + getSymbol() + ", contractShortType=" + getContractShortType() + ", contractCode=" + getContractCode() + ", optionCode=" + getOptionCode() + ", tradeId=" + getTradeId() + ")";
    }
}
