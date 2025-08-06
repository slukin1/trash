package com.hbg.lib.network.otc.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FastBuyBean implements Serializable {
    private int fastbuyRefreshInterval;
    @SerializedName("fastbuyTips")
    private String fastbuyTips;

    public boolean canEqual(Object obj) {
        return obj instanceof FastBuyBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FastBuyBean)) {
            return false;
        }
        FastBuyBean fastBuyBean = (FastBuyBean) obj;
        if (!fastBuyBean.canEqual(this)) {
            return false;
        }
        String fastbuyTips2 = getFastbuyTips();
        String fastbuyTips3 = fastBuyBean.getFastbuyTips();
        if (fastbuyTips2 != null ? fastbuyTips2.equals(fastbuyTips3) : fastbuyTips3 == null) {
            return getFastbuyRefreshInterval() == fastBuyBean.getFastbuyRefreshInterval();
        }
        return false;
    }

    public int getFastbuyRefreshInterval() {
        return this.fastbuyRefreshInterval;
    }

    public String getFastbuyTips() {
        return this.fastbuyTips;
    }

    public int hashCode() {
        String fastbuyTips2 = getFastbuyTips();
        return (((fastbuyTips2 == null ? 43 : fastbuyTips2.hashCode()) + 59) * 59) + getFastbuyRefreshInterval();
    }

    public void setFastbuyRefreshInterval(int i11) {
        this.fastbuyRefreshInterval = i11;
    }

    public void setFastbuyTips(String str) {
        this.fastbuyTips = str;
    }

    public String toString() {
        return "FastBuyBean(fastbuyTips=" + getFastbuyTips() + ", fastbuyRefreshInterval=" + getFastbuyRefreshInterval() + ")";
    }
}
