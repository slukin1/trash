package com.huobi.currencyconfig.bean;

import java.io.Serializable;

public class PricingMethodBean implements Serializable {
    private static final long serialVersionUID = -1249327298454039388L;
    private String countryFlag;
    private boolean defaultCurrency;
    private String locale;
    private String name;
    private String symbol;
    private int type;
    private String unit;

    public String getCountryFlag() {
        return this.countryFlag;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getType() {
        return this.type;
    }

    public String getUnit() {
        return this.unit;
    }

    public boolean isDefaultCurrency() {
        return this.defaultCurrency;
    }

    public void setCountryFlag(String str) {
        this.countryFlag = str;
    }

    public void setDefaultCurrency(boolean z11) {
        this.defaultCurrency = z11;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUnit(String str) {
        this.unit = str;
    }
}
