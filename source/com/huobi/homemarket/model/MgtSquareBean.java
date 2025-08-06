package com.huobi.homemarket.model;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.core.util.PhoneUtils;
import java.io.Serializable;

public class MgtSquareBean implements Serializable {
    @SerializedName("newMarketSquarePercent")
    private int newMarketSquarePercent;

    public boolean canEqual(Object obj) {
        return obj instanceof MgtSquareBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MgtSquareBean)) {
            return false;
        }
        MgtSquareBean mgtSquareBean = (MgtSquareBean) obj;
        return mgtSquareBean.canEqual(this) && getNewMarketSquarePercent() == mgtSquareBean.getNewMarketSquarePercent();
    }

    public int getNewMarketSquarePercent() {
        return this.newMarketSquarePercent;
    }

    public int hashCode() {
        return 59 + getNewMarketSquarePercent();
    }

    public boolean isHuidu() {
        return (Math.abs(PhoneUtils.t().hashCode()) % 100) + 1 <= this.newMarketSquarePercent;
    }

    public void setNewMarketSquarePercent(int i11) {
        this.newMarketSquarePercent = i11;
    }

    public String toString() {
        return "MgtSquareBean(newMarketSquarePercent=" + getNewMarketSquarePercent() + ")";
    }
}
