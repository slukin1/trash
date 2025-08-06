package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UserOtcCoupon implements Serializable {
    private long activityId;
    private String amount;
    private String baseCurrency;
    private long beginTime;
    private long endTime;

    /* renamed from: id  reason: collision with root package name */
    private long f70273id;
    private String meetCondition;
    private String quoteCurrency;
    private String quoteSign;
    private String rules;
    private long sysTime;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof UserOtcCoupon;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserOtcCoupon)) {
            return false;
        }
        UserOtcCoupon userOtcCoupon = (UserOtcCoupon) obj;
        if (!userOtcCoupon.canEqual(this) || getId() != userOtcCoupon.getId() || getActivityId() != userOtcCoupon.getActivityId()) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = userOtcCoupon.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = userOtcCoupon.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String quoteSign2 = getQuoteSign();
        String quoteSign3 = userOtcCoupon.getQuoteSign();
        if (quoteSign2 != null ? !quoteSign2.equals(quoteSign3) : quoteSign3 != null) {
            return false;
        }
        if (getType() != userOtcCoupon.getType()) {
            return false;
        }
        String meetCondition2 = getMeetCondition();
        String meetCondition3 = userOtcCoupon.getMeetCondition();
        if (meetCondition2 != null ? !meetCondition2.equals(meetCondition3) : meetCondition3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = userOtcCoupon.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        if (getBeginTime() != userOtcCoupon.getBeginTime() || getEndTime() != userOtcCoupon.getEndTime()) {
            return false;
        }
        String rules2 = getRules();
        String rules3 = userOtcCoupon.getRules();
        if (rules2 != null ? rules2.equals(rules3) : rules3 == null) {
            return getSysTime() == userOtcCoupon.getSysTime();
        }
        return false;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getId() {
        return this.f70273id;
    }

    public String getMeetCondition() {
        return this.meetCondition;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getQuoteSign() {
        return this.quoteSign;
    }

    public String getRules() {
        return this.rules;
    }

    public long getSysTime() {
        return this.sysTime;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        long id2 = getId();
        long activityId2 = getActivityId();
        int i11 = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) (activityId2 ^ (activityId2 >>> 32)));
        String baseCurrency2 = getBaseCurrency();
        int i12 = 43;
        int hashCode = (i11 * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode2 = (hashCode * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String quoteSign2 = getQuoteSign();
        int hashCode3 = (((hashCode2 * 59) + (quoteSign2 == null ? 43 : quoteSign2.hashCode())) * 59) + getType();
        String meetCondition2 = getMeetCondition();
        int hashCode4 = (hashCode3 * 59) + (meetCondition2 == null ? 43 : meetCondition2.hashCode());
        String amount2 = getAmount();
        int i13 = hashCode4 * 59;
        int hashCode5 = amount2 == null ? 43 : amount2.hashCode();
        long beginTime2 = getBeginTime();
        long endTime2 = getEndTime();
        int i14 = ((((i13 + hashCode5) * 59) + ((int) (beginTime2 ^ (beginTime2 >>> 32)))) * 59) + ((int) (endTime2 ^ (endTime2 >>> 32)));
        String rules2 = getRules();
        int i15 = i14 * 59;
        if (rules2 != null) {
            i12 = rules2.hashCode();
        }
        long sysTime2 = getSysTime();
        return ((i15 + i12) * 59) + ((int) ((sysTime2 >>> 32) ^ sysTime2));
    }

    public void setActivityId(long j11) {
        this.activityId = j11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setBeginTime(long j11) {
        this.beginTime = j11;
    }

    public void setEndTime(long j11) {
        this.endTime = j11;
    }

    public void setId(long j11) {
        this.f70273id = j11;
    }

    public void setMeetCondition(String str) {
        this.meetCondition = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setQuoteSign(String str) {
        this.quoteSign = str;
    }

    public void setRules(String str) {
        this.rules = str;
    }

    public void setSysTime(long j11) {
        this.sysTime = j11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "UserOtcCoupon(id=" + getId() + ", activityId=" + getActivityId() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", quoteSign=" + getQuoteSign() + ", type=" + getType() + ", meetCondition=" + getMeetCondition() + ", amount=" + getAmount() + ", beginTime=" + getBeginTime() + ", endTime=" + getEndTime() + ", rules=" + getRules() + ", sysTime=" + getSysTime() + ")";
    }
}
