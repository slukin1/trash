package com.huobi.account.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class RateList implements Serializable {
    private static final long serialVersionUID = 6317180422736982108L;
    @SerializedName("rate-list")
    private List<UserStepRate> rateList;

    public boolean canEqual(Object obj) {
        return obj instanceof RateList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RateList)) {
            return false;
        }
        RateList rateList2 = (RateList) obj;
        if (!rateList2.canEqual(this)) {
            return false;
        }
        List<UserStepRate> rateList3 = getRateList();
        List<UserStepRate> rateList4 = rateList2.getRateList();
        return rateList3 != null ? rateList3.equals(rateList4) : rateList4 == null;
    }

    public List<UserStepRate> getRateList() {
        return this.rateList;
    }

    public int hashCode() {
        List<UserStepRate> rateList2 = getRateList();
        return 59 + (rateList2 == null ? 43 : rateList2.hashCode());
    }

    public void setRateList(List<UserStepRate> list) {
        this.rateList = list;
    }

    public String toString() {
        return "RateList(rateList=" + getRateList() + ")";
    }
}
