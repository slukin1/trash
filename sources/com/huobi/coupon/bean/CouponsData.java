package com.huobi.coupon.bean;

import com.hbg.lib.network.otc.core.bean.LiteCouponsData;
import java.io.Serializable;
import java.util.List;

public class CouponsData implements Serializable {
    private List<Coupon> coupons;
    private int nextPage;
    private int page;
    private long sysTime;

    public static LiteCouponsData couponsDataToLite(CouponsData couponsData) {
        if (couponsData == null) {
            return null;
        }
        LiteCouponsData liteCouponsData = new LiteCouponsData();
        liteCouponsData.setCoupons(Coupon.couponListToLiteCouponList(couponsData.getCoupons()));
        liteCouponsData.setNextPage(couponsData.getNextPage());
        liteCouponsData.setPage(couponsData.getPage());
        liteCouponsData.setSysTime(couponsData.getSysTime());
        return liteCouponsData;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof CouponsData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CouponsData)) {
            return false;
        }
        CouponsData couponsData = (CouponsData) obj;
        if (!couponsData.canEqual(this) || getPage() != couponsData.getPage() || getSysTime() != couponsData.getSysTime() || getNextPage() != couponsData.getNextPage()) {
            return false;
        }
        List<Coupon> coupons2 = getCoupons();
        List<Coupon> coupons3 = couponsData.getCoupons();
        return coupons2 != null ? coupons2.equals(coupons3) : coupons3 == null;
    }

    public List<Coupon> getCoupons() {
        return this.coupons;
    }

    public int getNextPage() {
        return this.nextPage;
    }

    public int getPage() {
        return this.page;
    }

    public long getSysTime() {
        return this.sysTime;
    }

    public int hashCode() {
        long sysTime2 = getSysTime();
        int page2 = ((((getPage() + 59) * 59) + ((int) (sysTime2 ^ (sysTime2 >>> 32)))) * 59) + getNextPage();
        List<Coupon> coupons2 = getCoupons();
        return (page2 * 59) + (coupons2 == null ? 43 : coupons2.hashCode());
    }

    public void setCoupons(List<Coupon> list) {
        this.coupons = list;
    }

    public void setNextPage(int i11) {
        this.nextPage = i11;
    }

    public void setPage(int i11) {
        this.page = i11;
    }

    public void setSysTime(long j11) {
        this.sysTime = j11;
    }

    public String toString() {
        return "CouponsData(page=" + getPage() + ", sysTime=" + getSysTime() + ", nextPage=" + getNextPage() + ", coupons=" + getCoupons() + ")";
    }
}
