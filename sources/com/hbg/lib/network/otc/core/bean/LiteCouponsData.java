package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class LiteCouponsData implements Serializable {
    private List<LiteCoupon> coupons;
    private int nextPage;
    private int page;
    private long sysTime;

    public boolean canEqual(Object obj) {
        return obj instanceof LiteCouponsData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteCouponsData)) {
            return false;
        }
        LiteCouponsData liteCouponsData = (LiteCouponsData) obj;
        if (!liteCouponsData.canEqual(this) || getPage() != liteCouponsData.getPage() || getSysTime() != liteCouponsData.getSysTime() || getNextPage() != liteCouponsData.getNextPage()) {
            return false;
        }
        List<LiteCoupon> coupons2 = getCoupons();
        List<LiteCoupon> coupons3 = liteCouponsData.getCoupons();
        return coupons2 != null ? coupons2.equals(coupons3) : coupons3 == null;
    }

    public List<LiteCoupon> getCoupons() {
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
        List<LiteCoupon> coupons2 = getCoupons();
        return (page2 * 59) + (coupons2 == null ? 43 : coupons2.hashCode());
    }

    public void setCoupons(List<LiteCoupon> list) {
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
        return "LiteCouponsData(page=" + getPage() + ", sysTime=" + getSysTime() + ", nextPage=" + getNextPage() + ", coupons=" + getCoupons() + ")";
    }
}
