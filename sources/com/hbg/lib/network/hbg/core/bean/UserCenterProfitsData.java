package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UserCenterProfitsData implements Serializable {
    private String commission;
    private String coupon;
    private String point;

    public boolean canEqual(Object obj) {
        return obj instanceof UserCenterProfitsData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserCenterProfitsData)) {
            return false;
        }
        UserCenterProfitsData userCenterProfitsData = (UserCenterProfitsData) obj;
        if (!userCenterProfitsData.canEqual(this)) {
            return false;
        }
        String commission2 = getCommission();
        String commission3 = userCenterProfitsData.getCommission();
        if (commission2 != null ? !commission2.equals(commission3) : commission3 != null) {
            return false;
        }
        String point2 = getPoint();
        String point3 = userCenterProfitsData.getPoint();
        if (point2 != null ? !point2.equals(point3) : point3 != null) {
            return false;
        }
        String coupon2 = getCoupon();
        String coupon3 = userCenterProfitsData.getCoupon();
        return coupon2 != null ? coupon2.equals(coupon3) : coupon3 == null;
    }

    public String getCommission() {
        return this.commission;
    }

    public String getCoupon() {
        return this.coupon;
    }

    public String getPoint() {
        return this.point;
    }

    public int hashCode() {
        String commission2 = getCommission();
        int i11 = 43;
        int hashCode = commission2 == null ? 43 : commission2.hashCode();
        String point2 = getPoint();
        int hashCode2 = ((hashCode + 59) * 59) + (point2 == null ? 43 : point2.hashCode());
        String coupon2 = getCoupon();
        int i12 = hashCode2 * 59;
        if (coupon2 != null) {
            i11 = coupon2.hashCode();
        }
        return i12 + i11;
    }

    public void setCommission(String str) {
        this.commission = str;
    }

    public void setCoupon(String str) {
        this.coupon = str;
    }

    public void setPoint(String str) {
        this.point = str;
    }

    public String toString() {
        return "UserCenterProfitsData(commission=" + getCommission() + ", point=" + getPoint() + ", coupon=" + getCoupon() + ")";
    }
}
