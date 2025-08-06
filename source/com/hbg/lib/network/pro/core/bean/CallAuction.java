package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class CallAuction implements Serializable {
    public static final int MATCH_PHASE_CALL_AUCTION = 1;
    public static final int MATCH_PHASE_CONTINUITY = 0;
    private static final long serialVersionUID = 2929632131506420613L;
    private long createTime;
    private String forecastPrice;
    private String matchAmount;
    private Integer matchPhase;

    public boolean canEqual(Object obj) {
        return obj instanceof CallAuction;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CallAuction)) {
            return false;
        }
        CallAuction callAuction = (CallAuction) obj;
        if (!callAuction.canEqual(this)) {
            return false;
        }
        String forecastPrice2 = getForecastPrice();
        String forecastPrice3 = callAuction.getForecastPrice();
        if (forecastPrice2 != null ? !forecastPrice2.equals(forecastPrice3) : forecastPrice3 != null) {
            return false;
        }
        String matchAmount2 = getMatchAmount();
        String matchAmount3 = callAuction.getMatchAmount();
        if (matchAmount2 != null ? !matchAmount2.equals(matchAmount3) : matchAmount3 != null) {
            return false;
        }
        Integer matchPhase2 = getMatchPhase();
        Integer matchPhase3 = callAuction.getMatchPhase();
        if (matchPhase2 != null ? matchPhase2.equals(matchPhase3) : matchPhase3 == null) {
            return getCreateTime() == callAuction.getCreateTime();
        }
        return false;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getForecastPrice() {
        return this.forecastPrice;
    }

    public String getMatchAmount() {
        return this.matchAmount;
    }

    public Integer getMatchPhase() {
        return this.matchPhase;
    }

    public int hashCode() {
        String forecastPrice2 = getForecastPrice();
        int i11 = 43;
        int hashCode = forecastPrice2 == null ? 43 : forecastPrice2.hashCode();
        String matchAmount2 = getMatchAmount();
        int hashCode2 = ((hashCode + 59) * 59) + (matchAmount2 == null ? 43 : matchAmount2.hashCode());
        Integer matchPhase2 = getMatchPhase();
        int i12 = hashCode2 * 59;
        if (matchPhase2 != null) {
            i11 = matchPhase2.hashCode();
        }
        long createTime2 = getCreateTime();
        return ((i12 + i11) * 59) + ((int) ((createTime2 >>> 32) ^ createTime2));
    }

    public boolean isCallAuction() {
        Integer num = this.matchPhase;
        return num != null && num.intValue() == 1;
    }

    public boolean isContinuity() {
        Integer num = this.matchPhase;
        return num != null && num.intValue() == 0;
    }

    public void setCreateTime(long j11) {
        this.createTime = j11;
    }

    public void setForecastPrice(String str) {
        this.forecastPrice = str;
    }

    public void setMatchAmount(String str) {
        this.matchAmount = str;
    }

    public void setMatchPhase(Integer num) {
        this.matchPhase = num;
    }

    public String toString() {
        return "CallAuction(forecastPrice=" + getForecastPrice() + ", matchAmount=" + getMatchAmount() + ", matchPhase=" + getMatchPhase() + ", createTime=" + getCreateTime() + ")";
    }
}
