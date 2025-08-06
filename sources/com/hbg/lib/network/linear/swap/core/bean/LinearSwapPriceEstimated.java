package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapPriceEstimated implements Serializable {
    private String currency;
    @SerializedName("price_precision")
    private int pricePrecision;

    public String getCurrency() {
        return this.currency;
    }

    public int getPricePrecision() {
        return this.pricePrecision;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setPricePrecision(int i11) {
        this.pricePrecision = i11;
    }
}
