package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractPriceInfo implements Serializable {
    private static final long serialVersionUID = -2759048871546134381L;
    @SerializedName("index_price")
    private String currentIndex;
    private String symbol;

    public String getCurrentIndex() {
        return this.currentIndex;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setCurrentIndex(String str) {
        this.currentIndex = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }
}
