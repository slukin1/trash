package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class PurchasePriceBean implements Serializable {
    public String price;

    public boolean canEqual(Object obj) {
        return obj instanceof PurchasePriceBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PurchasePriceBean)) {
            return false;
        }
        PurchasePriceBean purchasePriceBean = (PurchasePriceBean) obj;
        if (!purchasePriceBean.canEqual(this)) {
            return false;
        }
        String price2 = getPrice();
        String price3 = purchasePriceBean.getPrice();
        return price2 != null ? price2.equals(price3) : price3 == null;
    }

    public String getPrice() {
        return this.price;
    }

    public int hashCode() {
        String price2 = getPrice();
        return 59 + (price2 == null ? 43 : price2.hashCode());
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String toString() {
        return "PurchasePriceBean(price=" + getPrice() + ")";
    }
}
