package com.huobi.staring.bean;

import java.io.Serializable;

public class CustomConfig implements Serializable {
    private PriceConfig price;

    public boolean canEqual(Object obj) {
        return obj instanceof CustomConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomConfig)) {
            return false;
        }
        CustomConfig customConfig = (CustomConfig) obj;
        if (!customConfig.canEqual(this)) {
            return false;
        }
        PriceConfig price2 = getPrice();
        PriceConfig price3 = customConfig.getPrice();
        return price2 != null ? price2.equals(price3) : price3 == null;
    }

    public PriceConfig getPrice() {
        return this.price;
    }

    public int hashCode() {
        PriceConfig price2 = getPrice();
        return 59 + (price2 == null ? 43 : price2.hashCode());
    }

    public void setPrice(PriceConfig priceConfig) {
        this.price = priceConfig;
    }

    public String toString() {
        return "CustomConfig(price=" + getPrice() + ")";
    }
}
