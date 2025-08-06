package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ReversalEstimatedLiquidationPrice implements Serializable {
    @SerializedName("liquidation_price")
    private String liquidationPrice;
    @SerializedName("unit")
    private String unit;

    public boolean canEqual(Object obj) {
        return obj instanceof ReversalEstimatedLiquidationPrice;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReversalEstimatedLiquidationPrice)) {
            return false;
        }
        ReversalEstimatedLiquidationPrice reversalEstimatedLiquidationPrice = (ReversalEstimatedLiquidationPrice) obj;
        if (!reversalEstimatedLiquidationPrice.canEqual(this)) {
            return false;
        }
        String liquidationPrice2 = getLiquidationPrice();
        String liquidationPrice3 = reversalEstimatedLiquidationPrice.getLiquidationPrice();
        if (liquidationPrice2 != null ? !liquidationPrice2.equals(liquidationPrice3) : liquidationPrice3 != null) {
            return false;
        }
        String unit2 = getUnit();
        String unit3 = reversalEstimatedLiquidationPrice.getUnit();
        return unit2 != null ? unit2.equals(unit3) : unit3 == null;
    }

    public String getLiquidationPrice() {
        return this.liquidationPrice;
    }

    public String getUnit() {
        return this.unit;
    }

    public int hashCode() {
        String liquidationPrice2 = getLiquidationPrice();
        int i11 = 43;
        int hashCode = liquidationPrice2 == null ? 43 : liquidationPrice2.hashCode();
        String unit2 = getUnit();
        int i12 = (hashCode + 59) * 59;
        if (unit2 != null) {
            i11 = unit2.hashCode();
        }
        return i12 + i11;
    }

    public void setLiquidationPrice(String str) {
        this.liquidationPrice = str;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public String toString() {
        return "ReversalEstimatedLiquidationPrice(liquidationPrice=" + getLiquidationPrice() + ", unit=" + getUnit() + ")";
    }
}
