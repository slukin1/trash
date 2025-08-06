package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class StareInfo implements Serializable {
    private String description;
    private int isSupport;
    private int openStare;
    private int rate;
    private int status;
    private int strategyId;
    private String strategyName;

    public boolean canEqual(Object obj) {
        return obj instanceof StareInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StareInfo)) {
            return false;
        }
        StareInfo stareInfo = (StareInfo) obj;
        if (!stareInfo.canEqual(this) || getOpenStare() != stareInfo.getOpenStare() || getStatus() != stareInfo.getStatus() || getStrategyId() != stareInfo.getStrategyId()) {
            return false;
        }
        String strategyName2 = getStrategyName();
        String strategyName3 = stareInfo.getStrategyName();
        if (strategyName2 != null ? !strategyName2.equals(strategyName3) : strategyName3 != null) {
            return false;
        }
        String description2 = getDescription();
        String description3 = stareInfo.getDescription();
        if (description2 != null ? description2.equals(description3) : description3 == null) {
            return getIsSupport() == stareInfo.getIsSupport() && getRate() == stareInfo.getRate();
        }
        return false;
    }

    public String getDescription() {
        return this.description;
    }

    public int getIsSupport() {
        return this.isSupport;
    }

    public int getOpenStare() {
        return this.openStare;
    }

    public int getRate() {
        return this.rate;
    }

    public int getStatus() {
        return this.status;
    }

    public int getStrategyId() {
        return this.strategyId;
    }

    public String getStrategyName() {
        return this.strategyName;
    }

    public int hashCode() {
        int openStare2 = ((((getOpenStare() + 59) * 59) + getStatus()) * 59) + getStrategyId();
        String strategyName2 = getStrategyName();
        int i11 = 43;
        int hashCode = (openStare2 * 59) + (strategyName2 == null ? 43 : strategyName2.hashCode());
        String description2 = getDescription();
        int i12 = hashCode * 59;
        if (description2 != null) {
            i11 = description2.hashCode();
        }
        return ((((i12 + i11) * 59) + getIsSupport()) * 59) + getRate();
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIsSupport(int i11) {
        this.isSupport = i11;
    }

    public void setOpenStare(int i11) {
        this.openStare = i11;
    }

    public void setRate(int i11) {
        this.rate = i11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setStrategyId(int i11) {
        this.strategyId = i11;
    }

    public void setStrategyName(String str) {
        this.strategyName = str;
    }

    public String toString() {
        return "StareInfo(openStare=" + getOpenStare() + ", status=" + getStatus() + ", strategyId=" + getStrategyId() + ", strategyName=" + getStrategyName() + ", description=" + getDescription() + ", isSupport=" + getIsSupport() + ", rate=" + getRate() + ")";
    }
}
