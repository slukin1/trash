package com.huobi.coupon.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CouponCheck implements Serializable {
    private static final long serialVersionUID = 1885371101032495006L;
    @SerializedName("activityId")
    private long activityId;
    private String amount;
    @SerializedName("coupon")
    private Coupon coupon;
    private String couponDescribe;
    @SerializedName("luckDraw")
    private boolean luckDraw;
    private String title;
    private boolean usePopup;

    public boolean canEqual(Object obj) {
        return obj instanceof CouponCheck;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CouponCheck)) {
            return false;
        }
        CouponCheck couponCheck = (CouponCheck) obj;
        if (!couponCheck.canEqual(this) || getActivityId() != couponCheck.getActivityId() || isLuckDraw() != couponCheck.isLuckDraw()) {
            return false;
        }
        Coupon coupon2 = getCoupon();
        Coupon coupon3 = couponCheck.getCoupon();
        if (coupon2 != null ? !coupon2.equals(coupon3) : coupon3 != null) {
            return false;
        }
        String couponDescribe2 = getCouponDescribe();
        String couponDescribe3 = couponCheck.getCouponDescribe();
        if (couponDescribe2 != null ? !couponDescribe2.equals(couponDescribe3) : couponDescribe3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = couponCheck.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        if (isUsePopup() != couponCheck.isUsePopup()) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = couponCheck.getAmount();
        return amount2 != null ? amount2.equals(amount3) : amount3 == null;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public String getAmount() {
        return this.amount;
    }

    public Coupon getCoupon() {
        return this.coupon;
    }

    public String getCouponDescribe() {
        return this.couponDescribe;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        long activityId2 = getActivityId();
        int i11 = 79;
        int i12 = ((((int) (activityId2 ^ (activityId2 >>> 32))) + 59) * 59) + (isLuckDraw() ? 79 : 97);
        Coupon coupon2 = getCoupon();
        int i13 = 43;
        int hashCode = (i12 * 59) + (coupon2 == null ? 43 : coupon2.hashCode());
        String couponDescribe2 = getCouponDescribe();
        int hashCode2 = (hashCode * 59) + (couponDescribe2 == null ? 43 : couponDescribe2.hashCode());
        String title2 = getTitle();
        int hashCode3 = ((hashCode2 * 59) + (title2 == null ? 43 : title2.hashCode())) * 59;
        if (!isUsePopup()) {
            i11 = 97;
        }
        String amount2 = getAmount();
        int i14 = (hashCode3 + i11) * 59;
        if (amount2 != null) {
            i13 = amount2.hashCode();
        }
        return i14 + i13;
    }

    public boolean isLuckDraw() {
        return this.luckDraw;
    }

    public boolean isUsePopup() {
        return this.usePopup;
    }

    public void setActivityId(long j11) {
        this.activityId = j11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCoupon(Coupon coupon2) {
        this.coupon = coupon2;
    }

    public void setCouponDescribe(String str) {
        this.couponDescribe = str;
    }

    public void setLuckDraw(boolean z11) {
        this.luckDraw = z11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUsePopup(boolean z11) {
        this.usePopup = z11;
    }

    public String toString() {
        return "CouponCheck(activityId=" + getActivityId() + ", luckDraw=" + isLuckDraw() + ", coupon=" + getCoupon() + ", couponDescribe=" + getCouponDescribe() + ", title=" + getTitle() + ", usePopup=" + isUsePopup() + ", amount=" + getAmount() + ")";
    }
}
