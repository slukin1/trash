package com.huobi.homemarket.model;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.core.util.PhoneUtils;
import java.io.Serializable;

public class MgtExpandKlineBean implements Serializable {
    @SerializedName("newMarketExpandKlinePercent")
    private int newMarketExpandKlinePercent;

    public boolean canEqual(Object obj) {
        return obj instanceof MgtExpandKlineBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MgtExpandKlineBean)) {
            return false;
        }
        MgtExpandKlineBean mgtExpandKlineBean = (MgtExpandKlineBean) obj;
        return mgtExpandKlineBean.canEqual(this) && getNewMarketExpandKlinePercent() == mgtExpandKlineBean.getNewMarketExpandKlinePercent();
    }

    public int getNewMarketExpandKlinePercent() {
        return this.newMarketExpandKlinePercent;
    }

    public int hashCode() {
        return 59 + getNewMarketExpandKlinePercent();
    }

    public boolean isHuidu() {
        return (Math.abs(PhoneUtils.t().hashCode()) % 100) + 1 <= this.newMarketExpandKlinePercent;
    }

    public void setNewMarketExpandKlinePercent(int i11) {
        this.newMarketExpandKlinePercent = i11;
    }

    public String toString() {
        return "MgtExpandKlineBean(newMarketExpandKlinePercent=" + getNewMarketExpandKlinePercent() + ")";
    }
}
