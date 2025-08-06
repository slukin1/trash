package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapFundingRate implements Serializable {
    private static final long serialVersionUID = -8278623349622535722L;
    @SerializedName("final_funding_rate")
    private String finalFundingRate;
    @SerializedName("funding_rate")
    private String fundingRate;
    @SerializedName("funding_time")
    private long fundingTime;
    @SerializedName("next_funding_time")
    private long nextFundingTime;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapFundingRate;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapFundingRate)) {
            return false;
        }
        LinearSwapFundingRate linearSwapFundingRate = (LinearSwapFundingRate) obj;
        if (!linearSwapFundingRate.canEqual(this)) {
            return false;
        }
        String fundingRate2 = getFundingRate();
        String fundingRate3 = linearSwapFundingRate.getFundingRate();
        if (fundingRate2 != null ? !fundingRate2.equals(fundingRate3) : fundingRate3 != null) {
            return false;
        }
        String finalFundingRate2 = getFinalFundingRate();
        String finalFundingRate3 = linearSwapFundingRate.getFinalFundingRate();
        if (finalFundingRate2 != null ? finalFundingRate2.equals(finalFundingRate3) : finalFundingRate3 == null) {
            return getFundingTime() == linearSwapFundingRate.getFundingTime() && getNextFundingTime() == linearSwapFundingRate.getNextFundingTime();
        }
        return false;
    }

    public String getFinalFundingRate() {
        return this.finalFundingRate;
    }

    public String getFundingRate() {
        return this.fundingRate;
    }

    public long getFundingTime() {
        return this.fundingTime;
    }

    public long getNextFundingTime() {
        return this.nextFundingTime;
    }

    public int hashCode() {
        String fundingRate2 = getFundingRate();
        int i11 = 43;
        int hashCode = fundingRate2 == null ? 43 : fundingRate2.hashCode();
        String finalFundingRate2 = getFinalFundingRate();
        int i12 = (hashCode + 59) * 59;
        if (finalFundingRate2 != null) {
            i11 = finalFundingRate2.hashCode();
        }
        long fundingTime2 = getFundingTime();
        int i13 = ((i12 + i11) * 59) + ((int) (fundingTime2 ^ (fundingTime2 >>> 32)));
        long nextFundingTime2 = getNextFundingTime();
        return (i13 * 59) + ((int) ((nextFundingTime2 >>> 32) ^ nextFundingTime2));
    }

    public void setFinalFundingRate(String str) {
        this.finalFundingRate = str;
    }

    public void setFundingRate(String str) {
        this.fundingRate = str;
    }

    public void setFundingTime(long j11) {
        this.fundingTime = j11;
    }

    public void setNextFundingTime(long j11) {
        this.nextFundingTime = j11;
    }

    public String toString() {
        return "LinearSwapFundingRate(fundingRate=" + getFundingRate() + ", finalFundingRate=" + getFinalFundingRate() + ", fundingTime=" + getFundingTime() + ", nextFundingTime=" + getNextFundingTime() + ")";
    }
}
