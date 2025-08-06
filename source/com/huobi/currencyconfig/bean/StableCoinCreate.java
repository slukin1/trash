package com.huobi.currencyconfig.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class StableCoinCreate implements Serializable {
    private static final long serialVersionUID = -6764285376090246217L;
    @SerializedName("in-amount")
    private String inAmount;
    @SerializedName("in-currency")
    private String inCurrency;
    @SerializedName("order-id")
    private String orderId;
    @SerializedName("out-amount")
    private String outAmount;
    @SerializedName("out-currency")
    private String outCurrency;
    @SerializedName("rate")
    private String rate;

    public boolean canEqual(Object obj) {
        return obj instanceof StableCoinCreate;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StableCoinCreate)) {
            return false;
        }
        StableCoinCreate stableCoinCreate = (StableCoinCreate) obj;
        if (!stableCoinCreate.canEqual(this)) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = stableCoinCreate.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        String outCurrency2 = getOutCurrency();
        String outCurrency3 = stableCoinCreate.getOutCurrency();
        if (outCurrency2 != null ? !outCurrency2.equals(outCurrency3) : outCurrency3 != null) {
            return false;
        }
        String inCurrency2 = getInCurrency();
        String inCurrency3 = stableCoinCreate.getInCurrency();
        if (inCurrency2 != null ? !inCurrency2.equals(inCurrency3) : inCurrency3 != null) {
            return false;
        }
        String outAmount2 = getOutAmount();
        String outAmount3 = stableCoinCreate.getOutAmount();
        if (outAmount2 != null ? !outAmount2.equals(outAmount3) : outAmount3 != null) {
            return false;
        }
        String inAmount2 = getInAmount();
        String inAmount3 = stableCoinCreate.getInAmount();
        if (inAmount2 != null ? !inAmount2.equals(inAmount3) : inAmount3 != null) {
            return false;
        }
        String rate2 = getRate();
        String rate3 = stableCoinCreate.getRate();
        return rate2 != null ? rate2.equals(rate3) : rate3 == null;
    }

    public String getInAmount() {
        return this.inAmount;
    }

    public String getInCurrency() {
        return this.inCurrency;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getOutAmount() {
        return this.outAmount;
    }

    public String getOutCurrency() {
        return this.outCurrency;
    }

    public String getRate() {
        return this.rate;
    }

    public int hashCode() {
        String orderId2 = getOrderId();
        int i11 = 43;
        int hashCode = orderId2 == null ? 43 : orderId2.hashCode();
        String outCurrency2 = getOutCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (outCurrency2 == null ? 43 : outCurrency2.hashCode());
        String inCurrency2 = getInCurrency();
        int hashCode3 = (hashCode2 * 59) + (inCurrency2 == null ? 43 : inCurrency2.hashCode());
        String outAmount2 = getOutAmount();
        int hashCode4 = (hashCode3 * 59) + (outAmount2 == null ? 43 : outAmount2.hashCode());
        String inAmount2 = getInAmount();
        int hashCode5 = (hashCode4 * 59) + (inAmount2 == null ? 43 : inAmount2.hashCode());
        String rate2 = getRate();
        int i12 = hashCode5 * 59;
        if (rate2 != null) {
            i11 = rate2.hashCode();
        }
        return i12 + i11;
    }

    public void setInAmount(String str) {
        this.inAmount = str;
    }

    public void setInCurrency(String str) {
        this.inCurrency = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOutAmount(String str) {
        this.outAmount = str;
    }

    public void setOutCurrency(String str) {
        this.outCurrency = str;
    }

    public void setRate(String str) {
        this.rate = str;
    }

    public String toString() {
        return "StableCoinCreate(orderId=" + getOrderId() + ", outCurrency=" + getOutCurrency() + ", inCurrency=" + getInCurrency() + ", outAmount=" + getOutAmount() + ", inAmount=" + getInAmount() + ", rate=" + getRate() + ")";
    }
}
