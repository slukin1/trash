package com.hbg.lib.network.hbg.core.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Locale;

public class PricingMethodBean implements Serializable {
    private static final long serialVersionUID = 7634143859022556480L;
    private String abbr;
    private int defaultCurrency;
    private String deviceLanguage;
    private String fiatName;
    private String imageUrl;
    private int priority;
    private String symbol;

    public String getAbbr() {
        if (!TextUtils.isEmpty(this.abbr)) {
            return this.abbr.toLowerCase(Locale.US);
        }
        return this.abbr;
    }

    public int getDefaultCurrency() {
        return this.defaultCurrency;
    }

    public String getDeviceLanguage() {
        return this.deviceLanguage;
    }

    public String getFiatName() {
        return this.fiatName;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setAbbr(String str) {
        this.abbr = str;
    }

    public void setDefaultCurrency(int i11) {
        this.defaultCurrency = i11;
    }

    public void setDeviceLanguage(String str) {
        this.deviceLanguage = str;
    }

    public void setFiatName(String str) {
        this.fiatName = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setPriority(int i11) {
        this.priority = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }
}
