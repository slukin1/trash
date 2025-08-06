package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcOrderCoupons implements Serializable {
    private String amount = "";
    private String describe = "";
    private String quantity = "";
    private String totalAmount = "";

    public boolean canEqual(Object obj) {
        return obj instanceof OtcOrderCoupons;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOrderCoupons)) {
            return false;
        }
        OtcOrderCoupons otcOrderCoupons = (OtcOrderCoupons) obj;
        if (!otcOrderCoupons.canEqual(this)) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = otcOrderCoupons.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String quantity2 = getQuantity();
        String quantity3 = otcOrderCoupons.getQuantity();
        if (quantity2 != null ? !quantity2.equals(quantity3) : quantity3 != null) {
            return false;
        }
        String describe2 = getDescribe();
        String describe3 = otcOrderCoupons.getDescribe();
        if (describe2 != null ? !describe2.equals(describe3) : describe3 != null) {
            return false;
        }
        String totalAmount2 = getTotalAmount();
        String totalAmount3 = otcOrderCoupons.getTotalAmount();
        return totalAmount2 != null ? totalAmount2.equals(totalAmount3) : totalAmount3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getDescribe() {
        return this.describe;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public int hashCode() {
        String amount2 = getAmount();
        int i11 = 43;
        int hashCode = amount2 == null ? 43 : amount2.hashCode();
        String quantity2 = getQuantity();
        int hashCode2 = ((hashCode + 59) * 59) + (quantity2 == null ? 43 : quantity2.hashCode());
        String describe2 = getDescribe();
        int hashCode3 = (hashCode2 * 59) + (describe2 == null ? 43 : describe2.hashCode());
        String totalAmount2 = getTotalAmount();
        int i12 = hashCode3 * 59;
        if (totalAmount2 != null) {
            i11 = totalAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setDescribe(String str) {
        this.describe = str;
    }

    public void setQuantity(String str) {
        this.quantity = str;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public String toString() {
        return "OtcOrderCoupons(amount=" + getAmount() + ", quantity=" + getQuantity() + ", describe=" + getDescribe() + ", totalAmount=" + getTotalAmount() + ")";
    }
}
