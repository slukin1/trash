package com.huobi.engineutils.bean;

import java.io.Serializable;

public class LongAssetLevelData implements Serializable {
    private String available;
    private String availableEquivalent;
    private String borrowed;
    private String currency;
    private String estimation;
    private String freeze;
    private String riskRate;
    private String symbolIcon;
    private String symbolName;

    public String getAvailable() {
        return this.available;
    }

    public String getAvailableEquivalent() {
        return this.availableEquivalent;
    }

    public String getBorrowed() {
        return this.borrowed;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getEstimation() {
        return this.estimation;
    }

    public String getFreeze() {
        return this.freeze;
    }

    public String getRiskRate() {
        return this.riskRate;
    }

    public String getSymbolIcon() {
        return this.symbolIcon;
    }

    public String getSymbolName() {
        return this.symbolName;
    }

    public void setAvailable(String str) {
        this.available = str;
    }

    public void setAvailableEquivalent(String str) {
        this.availableEquivalent = str;
    }

    public void setBorrowed(String str) {
        this.borrowed = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setEstimation(String str) {
        this.estimation = str;
    }

    public void setFreeze(String str) {
        this.freeze = str;
    }

    public void setRiskRate(String str) {
        this.riskRate = str;
    }

    public void setSymbolIcon(String str) {
        this.symbolIcon = str;
    }

    public void setSymbolName(String str) {
        this.symbolName = str;
    }
}
