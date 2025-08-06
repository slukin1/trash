package com.huobi.coupon.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class CouponReturnContainer implements Serializable {
    @SerializedName("appCheckFlag")
    private int appCheckFlag;
    @SerializedName("couponList")
    private List<CouponReturn> coupons;

    public boolean canEqual(Object obj) {
        return obj instanceof CouponReturnContainer;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CouponReturnContainer)) {
            return false;
        }
        CouponReturnContainer couponReturnContainer = (CouponReturnContainer) obj;
        if (!couponReturnContainer.canEqual(this)) {
            return false;
        }
        List<CouponReturn> coupons2 = getCoupons();
        List<CouponReturn> coupons3 = couponReturnContainer.getCoupons();
        if (coupons2 != null ? coupons2.equals(coupons3) : coupons3 == null) {
            return getAppCheckFlag() == couponReturnContainer.getAppCheckFlag();
        }
        return false;
    }

    public int getAppCheckFlag() {
        return this.appCheckFlag;
    }

    public List<CouponReturn> getCoupons() {
        return this.coupons;
    }

    public int hashCode() {
        List<CouponReturn> coupons2 = getCoupons();
        return (((coupons2 == null ? 43 : coupons2.hashCode()) + 59) * 59) + getAppCheckFlag();
    }

    public boolean isCheck() {
        return this.appCheckFlag == 0;
    }

    public void setAppCheckFlag(int i11) {
        this.appCheckFlag = i11;
    }

    public void setCoupons(List<CouponReturn> list) {
        this.coupons = list;
    }

    public String toString() {
        return "CouponReturnContainer(coupons=" + getCoupons() + ", appCheckFlag=" + getAppCheckFlag() + ")";
    }
}
