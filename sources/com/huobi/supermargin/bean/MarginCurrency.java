package com.huobi.supermargin.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.supermargin.viewhandler.MarginCurrencyViewHandler;
import java.io.Serializable;
import s9.a;

public class MarginCurrency implements Serializable, a {
    public static final int STATE_0 = 0;
    public static final int STATE_1 = 1;
    private static final long serialVersionUID = 3111388199534338014L;
    @SerializedName("currency")
    private String currency;
    @SerializedName("loan-currency")
    private int loanCurrency;
    @SerializedName("loanable")
    private int loanable;
    @SerializedName("state")
    private int state;

    public boolean canEqual(Object obj) {
        return obj instanceof MarginCurrency;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarginCurrency)) {
            return false;
        }
        MarginCurrency marginCurrency = (MarginCurrency) obj;
        if (!marginCurrency.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = marginCurrency.getCurrency();
        if (currency2 != null ? currency2.equals(currency3) : currency3 == null) {
            return getState() == marginCurrency.getState() && getLoanCurrency() == marginCurrency.getLoanCurrency() && getLoanable() == marginCurrency.getLoanable();
        }
        return false;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getLoanCurrency() {
        return this.loanCurrency;
    }

    public int getLoanable() {
        return this.loanable;
    }

    public int getState() {
        return this.state;
    }

    public String getViewHandlerName() {
        return MarginCurrencyViewHandler.class.getName();
    }

    public int hashCode() {
        String currency2 = getCurrency();
        return (((((((currency2 == null ? 43 : currency2.hashCode()) + 59) * 59) + getState()) * 59) + getLoanCurrency()) * 59) + getLoanable();
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setLoanCurrency(int i11) {
        this.loanCurrency = i11;
    }

    public void setLoanable(int i11) {
        this.loanable = i11;
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public String toString() {
        return "MarginCurrency(currency=" + getCurrency() + ", state=" + getState() + ", loanCurrency=" + getLoanCurrency() + ", loanable=" + getLoanable() + ")";
    }
}
