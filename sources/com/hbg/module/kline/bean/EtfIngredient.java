package com.hbg.module.kline.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.module.kline.handler.MarketInfoEtfIngredientHandler;
import java.io.Serializable;
import s9.a;

public class EtfIngredient implements a, Serializable {
    private double amount;
    private String currency;
    @SerializedName("equivalent_value")
    private double equivalentValue;
    private double rate;

    public boolean canEqual(Object obj) {
        return obj instanceof EtfIngredient;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EtfIngredient)) {
            return false;
        }
        EtfIngredient etfIngredient = (EtfIngredient) obj;
        if (!etfIngredient.canEqual(this) || Double.compare(getAmount(), etfIngredient.getAmount()) != 0) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = etfIngredient.getCurrency();
        if (currency2 != null ? currency2.equals(currency3) : currency3 == null) {
            return Double.compare(getEquivalentValue(), etfIngredient.getEquivalentValue()) == 0 && Double.compare(getRate(), etfIngredient.getRate()) == 0;
        }
        return false;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public double getEquivalentValue() {
        return this.equivalentValue;
    }

    public double getRate() {
        return this.rate;
    }

    public String getViewHandlerName() {
        return MarketInfoEtfIngredientHandler.class.getName();
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(getAmount());
        String currency2 = getCurrency();
        int hashCode = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        long doubleToLongBits2 = Double.doubleToLongBits(getEquivalentValue());
        int i11 = (hashCode * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(getRate());
        return (i11 * 59) + ((int) ((doubleToLongBits3 >>> 32) ^ doubleToLongBits3));
    }

    public void setAmount(double d11) {
        this.amount = d11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setEquivalentValue(double d11) {
        this.equivalentValue = d11;
    }

    public void setRate(double d11) {
        this.rate = d11;
    }

    public String toString() {
        return "EtfIngredient(amount=" + getAmount() + ", currency=" + getCurrency() + ", equivalentValue=" + getEquivalentValue() + ", rate=" + getRate() + ")";
    }
}
