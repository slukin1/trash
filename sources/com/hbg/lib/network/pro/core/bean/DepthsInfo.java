package com.hbg.lib.network.pro.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

public class DepthsInfo implements Serializable {
    private static final long serialVersionUID = -128502073131022869L;
    @SerializedName("amount-scale")
    private int amountScale;
    @SerializedName("depth-steps")
    private Map<String, String[]> depthSteps;
    @SerializedName("l2quote-price-scale")
    private int l2quotePriceScale;
    @SerializedName("price-scale")
    private int priceScale;

    public boolean canEqual(Object obj) {
        return obj instanceof DepthsInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DepthsInfo)) {
            return false;
        }
        DepthsInfo depthsInfo = (DepthsInfo) obj;
        if (!depthsInfo.canEqual(this) || getAmountScale() != depthsInfo.getAmountScale() || getPriceScale() != depthsInfo.getPriceScale() || getL2quotePriceScale() != depthsInfo.getL2quotePriceScale()) {
            return false;
        }
        Map<String, String[]> depthSteps2 = getDepthSteps();
        Map<String, String[]> depthSteps3 = depthsInfo.getDepthSteps();
        return depthSteps2 != null ? depthSteps2.equals(depthSteps3) : depthSteps3 == null;
    }

    public int getAmountScale() {
        return this.amountScale;
    }

    public Map<String, String[]> getDepthSteps() {
        return this.depthSteps;
    }

    public int getL2quotePriceScale() {
        return this.l2quotePriceScale;
    }

    public int getPriceScale() {
        return this.priceScale;
    }

    public int hashCode() {
        int amountScale2 = ((((getAmountScale() + 59) * 59) + getPriceScale()) * 59) + getL2quotePriceScale();
        Map<String, String[]> depthSteps2 = getDepthSteps();
        return (amountScale2 * 59) + (depthSteps2 == null ? 43 : depthSteps2.hashCode());
    }

    public void setAmountScale(int i11) {
        this.amountScale = i11;
    }

    public void setDepthSteps(Map<String, String[]> map) {
        this.depthSteps = map;
    }

    public void setL2quotePriceScale(int i11) {
        this.l2quotePriceScale = i11;
    }

    public void setPriceScale(int i11) {
        this.priceScale = i11;
    }

    public String toString() {
        return "DepthsInfo(amountScale=" + getAmountScale() + ", priceScale=" + getPriceScale() + ", l2quotePriceScale=" + getL2quotePriceScale() + ", depthSteps=" + getDepthSteps() + ")";
    }
}
