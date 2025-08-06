package com.huobi.coupon.bean;

import java.io.Serializable;

public class CouponNoticeInfo implements Serializable {
    private long noticeType;
    private Long validAt;

    public boolean canEqual(Object obj) {
        return obj instanceof CouponNoticeInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CouponNoticeInfo)) {
            return false;
        }
        CouponNoticeInfo couponNoticeInfo = (CouponNoticeInfo) obj;
        if (!couponNoticeInfo.canEqual(this) || getNoticeType() != couponNoticeInfo.getNoticeType()) {
            return false;
        }
        Long validAt2 = getValidAt();
        Long validAt3 = couponNoticeInfo.getValidAt();
        return validAt2 != null ? validAt2.equals(validAt3) : validAt3 == null;
    }

    public long getNoticeType() {
        return this.noticeType;
    }

    public Long getValidAt() {
        return this.validAt;
    }

    public String getValidDate() {
        Long l11 = this.validAt;
        if (l11 == null) {
            return "1";
        }
        long longValue = l11.longValue() - System.currentTimeMillis();
        return longValue > 0 ? String.valueOf((((longValue / 1000) / 60) / 60) / 24) : "1";
    }

    public int hashCode() {
        long noticeType2 = getNoticeType();
        Long validAt2 = getValidAt();
        return ((((int) (noticeType2 ^ (noticeType2 >>> 32))) + 59) * 59) + (validAt2 == null ? 43 : validAt2.hashCode());
    }

    public boolean isCoupon() {
        return 1 == this.noticeType;
    }

    public boolean isGridFund() {
        return 15 == this.noticeType;
    }

    public boolean isTrailFund() {
        return 2 == this.noticeType;
    }

    public void setNoticeType(long j11) {
        this.noticeType = j11;
    }

    public void setValidAt(Long l11) {
        this.validAt = l11;
    }

    public String toString() {
        return "CouponNoticeInfo(noticeType=" + getNoticeType() + ", validAt=" + getValidAt() + ")";
    }
}
