package com.huobi.trade.prime.bean;

import com.huobi.trade.bean.TradeOrderType;
import com.huobi.trade.prime.viewhandler.PrimeOrderBeanViewHandler;
import java.io.Serializable;
import s9.a;

public class PrimeOrderBean implements Serializable, a {
    public static final String FINISHED = "finished";
    private static final long serialVersionUID = -2869506945277736046L;
    private long accountId;
    private String amount;
    private long createdAt;

    /* renamed from: id  reason: collision with root package name */
    private long f82176id;
    private String price;
    private String quotaAmount;
    private String state;
    private String symbol;
    private String type;

    public boolean canEqual(Object obj) {
        return obj instanceof PrimeOrderBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimeOrderBean)) {
            return false;
        }
        PrimeOrderBean primeOrderBean = (PrimeOrderBean) obj;
        if (!primeOrderBean.canEqual(this) || getId() != primeOrderBean.getId() || getAccountId() != primeOrderBean.getAccountId()) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = primeOrderBean.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = primeOrderBean.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = primeOrderBean.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = primeOrderBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        if (getCreatedAt() != primeOrderBean.getCreatedAt()) {
            return false;
        }
        String state2 = getState();
        String state3 = primeOrderBean.getState();
        if (state2 != null ? !state2.equals(state3) : state3 != null) {
            return false;
        }
        String quotaAmount2 = getQuotaAmount();
        String quotaAmount3 = primeOrderBean.getQuotaAmount();
        return quotaAmount2 != null ? quotaAmount2.equals(quotaAmount3) : quotaAmount3 == null;
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

    public long getId() {
        return this.f82176id;
    }

    public String getPrice() {
        return this.price;
    }

    public String getQuotaAmount() {
        return this.quotaAmount;
    }

    public String getState() {
        return this.state;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getType() {
        return this.type;
    }

    public String getViewHandlerName() {
        return PrimeOrderBeanViewHandler.class.getName();
    }

    public int hashCode() {
        long id2 = getId();
        long accountId2 = getAccountId();
        int i11 = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) (accountId2 ^ (accountId2 >>> 32)));
        String symbol2 = getSymbol();
        int i12 = 43;
        int hashCode = (i11 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String type2 = getType();
        int hashCode2 = (hashCode * 59) + (type2 == null ? 43 : type2.hashCode());
        String price2 = getPrice();
        int hashCode3 = (hashCode2 * 59) + (price2 == null ? 43 : price2.hashCode());
        String amount2 = getAmount();
        int i13 = hashCode3 * 59;
        int hashCode4 = amount2 == null ? 43 : amount2.hashCode();
        long createdAt2 = getCreatedAt();
        String state2 = getState();
        int hashCode5 = ((((i13 + hashCode4) * 59) + ((int) ((createdAt2 >>> 32) ^ createdAt2))) * 59) + (state2 == null ? 43 : state2.hashCode());
        String quotaAmount2 = getQuotaAmount();
        int i14 = hashCode5 * 59;
        if (quotaAmount2 != null) {
            i12 = quotaAmount2.hashCode();
        }
        return i14 + i12;
    }

    public boolean isBuy() {
        return TradeOrderType.b(getType());
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

    public void setId(long j11) {
        this.f82176id = j11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setQuotaAmount(String str) {
        this.quotaAmount = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "PrimeOrderBean(id=" + getId() + ", accountId=" + getAccountId() + ", symbol=" + getSymbol() + ", type=" + getType() + ", price=" + getPrice() + ", amount=" + getAmount() + ", createdAt=" + getCreatedAt() + ", state=" + getState() + ", quotaAmount=" + getQuotaAmount() + ")";
    }
}
