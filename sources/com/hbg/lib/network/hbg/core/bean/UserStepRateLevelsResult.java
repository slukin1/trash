package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class UserStepRateLevelsResult implements Serializable {
    private static final long serialVersionUID = 3917563910569622965L;
    private List<UserStepRateLevelsInfo> rateList;

    public boolean canEqual(Object obj) {
        return obj instanceof UserStepRateLevelsResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserStepRateLevelsResult)) {
            return false;
        }
        UserStepRateLevelsResult userStepRateLevelsResult = (UserStepRateLevelsResult) obj;
        if (!userStepRateLevelsResult.canEqual(this)) {
            return false;
        }
        List<UserStepRateLevelsInfo> rateList2 = getRateList();
        List<UserStepRateLevelsInfo> rateList3 = userStepRateLevelsResult.getRateList();
        return rateList2 != null ? rateList2.equals(rateList3) : rateList3 == null;
    }

    public List<UserStepRateLevelsInfo> getRateList() {
        return this.rateList;
    }

    public int hashCode() {
        List<UserStepRateLevelsInfo> rateList2 = getRateList();
        return 59 + (rateList2 == null ? 43 : rateList2.hashCode());
    }

    public void setRateList(List<UserStepRateLevelsInfo> list) {
        this.rateList = list;
    }

    public String toString() {
        return "UserStepRateLevelsResult(rateList=" + getRateList() + ")";
    }
}
