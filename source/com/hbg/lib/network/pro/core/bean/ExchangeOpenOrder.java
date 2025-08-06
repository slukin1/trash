package com.hbg.lib.network.pro.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ExchangeOpenOrder implements Serializable {
    private static final long serialVersionUID = -4111949235013352619L;
    @SerializedName("account-id")
    private long accountId;
    private String amount;
    @SerializedName("created-at")
    private long createdAt;
    @SerializedName("filled-amount")
    private String filledAmount;
    @SerializedName("filled-cash-amount")
    private String filledCashAmount;
    @SerializedName("filled-fees")
    private String filledFees;
    @SerializedName("ice-amount")
    private String iceAmount;

    /* renamed from: id  reason: collision with root package name */
    private long f70613id;
    private String operator;
    private String price;
    private String source;
    private String state;
    @SerializedName("stop-price")
    private String stopPrice;
    private String symbol;
    private String type;

    public boolean canEqual(Object obj) {
        return obj instanceof ExchangeOpenOrder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExchangeOpenOrder)) {
            return false;
        }
        ExchangeOpenOrder exchangeOpenOrder = (ExchangeOpenOrder) obj;
        if (!exchangeOpenOrder.canEqual(this) || getId() != exchangeOpenOrder.getId() || getAccountId() != exchangeOpenOrder.getAccountId()) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = exchangeOpenOrder.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = exchangeOpenOrder.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        if (getCreatedAt() != exchangeOpenOrder.getCreatedAt()) {
            return false;
        }
        String type2 = getType();
        String type3 = exchangeOpenOrder.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = exchangeOpenOrder.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String filledAmount2 = getFilledAmount();
        String filledAmount3 = exchangeOpenOrder.getFilledAmount();
        if (filledAmount2 != null ? !filledAmount2.equals(filledAmount3) : filledAmount3 != null) {
            return false;
        }
        String iceAmount2 = getIceAmount();
        String iceAmount3 = exchangeOpenOrder.getIceAmount();
        if (iceAmount2 != null ? !iceAmount2.equals(iceAmount3) : iceAmount3 != null) {
            return false;
        }
        String filledCashAmount2 = getFilledCashAmount();
        String filledCashAmount3 = exchangeOpenOrder.getFilledCashAmount();
        if (filledCashAmount2 != null ? !filledCashAmount2.equals(filledCashAmount3) : filledCashAmount3 != null) {
            return false;
        }
        String filledFees2 = getFilledFees();
        String filledFees3 = exchangeOpenOrder.getFilledFees();
        if (filledFees2 != null ? !filledFees2.equals(filledFees3) : filledFees3 != null) {
            return false;
        }
        String source2 = getSource();
        String source3 = exchangeOpenOrder.getSource();
        if (source2 != null ? !source2.equals(source3) : source3 != null) {
            return false;
        }
        String state2 = getState();
        String state3 = exchangeOpenOrder.getState();
        if (state2 != null ? !state2.equals(state3) : state3 != null) {
            return false;
        }
        String stopPrice2 = getStopPrice();
        String stopPrice3 = exchangeOpenOrder.getStopPrice();
        if (stopPrice2 != null ? !stopPrice2.equals(stopPrice3) : stopPrice3 != null) {
            return false;
        }
        String operator2 = getOperator();
        String operator3 = exchangeOpenOrder.getOperator();
        return operator2 != null ? operator2.equals(operator3) : operator3 == null;
    }

    public long getAccountId() {
        return this.accountId;
    }

    public String getAmount() {
        return this.amount;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getFilledAmount() {
        return this.filledAmount;
    }

    public String getFilledCashAmount() {
        return this.filledCashAmount;
    }

    public String getFilledFees() {
        return this.filledFees;
    }

    public String getIceAmount() {
        return this.iceAmount;
    }

    public long getId() {
        return this.f70613id;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getPrice() {
        return this.price;
    }

    public String getSource() {
        return this.source;
    }

    public String getState() {
        return this.state;
    }

    public String getStopPrice() {
        return this.stopPrice;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        long id2 = getId();
        long accountId2 = getAccountId();
        int i11 = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) (accountId2 ^ (accountId2 >>> 32)));
        String symbol2 = getSymbol();
        int i12 = 43;
        int hashCode = (i11 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String price2 = getPrice();
        int i13 = hashCode * 59;
        int hashCode2 = price2 == null ? 43 : price2.hashCode();
        long createdAt2 = getCreatedAt();
        String type2 = getType();
        int hashCode3 = ((((i13 + hashCode2) * 59) + ((int) ((createdAt2 >>> 32) ^ createdAt2))) * 59) + (type2 == null ? 43 : type2.hashCode());
        String amount2 = getAmount();
        int hashCode4 = (hashCode3 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String filledAmount2 = getFilledAmount();
        int hashCode5 = (hashCode4 * 59) + (filledAmount2 == null ? 43 : filledAmount2.hashCode());
        String iceAmount2 = getIceAmount();
        int hashCode6 = (hashCode5 * 59) + (iceAmount2 == null ? 43 : iceAmount2.hashCode());
        String filledCashAmount2 = getFilledCashAmount();
        int hashCode7 = (hashCode6 * 59) + (filledCashAmount2 == null ? 43 : filledCashAmount2.hashCode());
        String filledFees2 = getFilledFees();
        int hashCode8 = (hashCode7 * 59) + (filledFees2 == null ? 43 : filledFees2.hashCode());
        String source2 = getSource();
        int hashCode9 = (hashCode8 * 59) + (source2 == null ? 43 : source2.hashCode());
        String state2 = getState();
        int hashCode10 = (hashCode9 * 59) + (state2 == null ? 43 : state2.hashCode());
        String stopPrice2 = getStopPrice();
        int hashCode11 = (hashCode10 * 59) + (stopPrice2 == null ? 43 : stopPrice2.hashCode());
        String operator2 = getOperator();
        int i14 = hashCode11 * 59;
        if (operator2 != null) {
            i12 = operator2.hashCode();
        }
        return i14 + i12;
    }

    public void setAccountId(long j11) {
        this.accountId = j11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setFilledAmount(String str) {
        this.filledAmount = str;
    }

    public void setFilledCashAmount(String str) {
        this.filledCashAmount = str;
    }

    public void setFilledFees(String str) {
        this.filledFees = str;
    }

    public void setIceAmount(String str) {
        this.iceAmount = str;
    }

    public void setId(long j11) {
        this.f70613id = j11;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setStopPrice(String str) {
        this.stopPrice = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "ExchangeOpenOrder(id=" + getId() + ", accountId=" + getAccountId() + ", symbol=" + getSymbol() + ", price=" + getPrice() + ", createdAt=" + getCreatedAt() + ", type=" + getType() + ", amount=" + getAmount() + ", filledAmount=" + getFilledAmount() + ", iceAmount=" + getIceAmount() + ", filledCashAmount=" + getFilledCashAmount() + ", filledFees=" + getFilledFees() + ", source=" + getSource() + ", state=" + getState() + ", stopPrice=" + getStopPrice() + ", operator=" + getOperator() + ")";
    }
}
