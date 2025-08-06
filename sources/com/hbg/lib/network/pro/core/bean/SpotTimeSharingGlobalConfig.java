package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class SpotTimeSharingGlobalConfig implements Serializable {
    private boolean available;
    private Object data;
    private int maxInterval;
    private String maxOrderPriceRatio;
    private int minInterval;
    private String minOrderPriceRatio;

    public boolean canEqual(Object obj) {
        return obj instanceof SpotTimeSharingGlobalConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpotTimeSharingGlobalConfig)) {
            return false;
        }
        SpotTimeSharingGlobalConfig spotTimeSharingGlobalConfig = (SpotTimeSharingGlobalConfig) obj;
        if (!spotTimeSharingGlobalConfig.canEqual(this)) {
            return false;
        }
        Object data2 = getData();
        Object data3 = spotTimeSharingGlobalConfig.getData();
        if (data2 != null ? !data2.equals(data3) : data3 != null) {
            return false;
        }
        if (isAvailable() != spotTimeSharingGlobalConfig.isAvailable() || getMinInterval() != spotTimeSharingGlobalConfig.getMinInterval() || getMaxInterval() != spotTimeSharingGlobalConfig.getMaxInterval()) {
            return false;
        }
        String minOrderPriceRatio2 = getMinOrderPriceRatio();
        String minOrderPriceRatio3 = spotTimeSharingGlobalConfig.getMinOrderPriceRatio();
        if (minOrderPriceRatio2 != null ? !minOrderPriceRatio2.equals(minOrderPriceRatio3) : minOrderPriceRatio3 != null) {
            return false;
        }
        String maxOrderPriceRatio2 = getMaxOrderPriceRatio();
        String maxOrderPriceRatio3 = spotTimeSharingGlobalConfig.getMaxOrderPriceRatio();
        return maxOrderPriceRatio2 != null ? maxOrderPriceRatio2.equals(maxOrderPriceRatio3) : maxOrderPriceRatio3 == null;
    }

    public Object getData() {
        return this.data;
    }

    public int getMaxInterval() {
        return this.maxInterval;
    }

    public String getMaxOrderPriceRatio() {
        return this.maxOrderPriceRatio;
    }

    public int getMinInterval() {
        return this.minInterval;
    }

    public String getMinOrderPriceRatio() {
        return this.minOrderPriceRatio;
    }

    public int hashCode() {
        Object data2 = getData();
        int i11 = 43;
        int hashCode = (((((((data2 == null ? 43 : data2.hashCode()) + 59) * 59) + (isAvailable() ? 79 : 97)) * 59) + getMinInterval()) * 59) + getMaxInterval();
        String minOrderPriceRatio2 = getMinOrderPriceRatio();
        int hashCode2 = (hashCode * 59) + (minOrderPriceRatio2 == null ? 43 : minOrderPriceRatio2.hashCode());
        String maxOrderPriceRatio2 = getMaxOrderPriceRatio();
        int i12 = hashCode2 * 59;
        if (maxOrderPriceRatio2 != null) {
            i11 = maxOrderPriceRatio2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean z11) {
        this.available = z11;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setMaxInterval(int i11) {
        this.maxInterval = i11;
    }

    public void setMaxOrderPriceRatio(String str) {
        this.maxOrderPriceRatio = str;
    }

    public void setMinInterval(int i11) {
        this.minInterval = i11;
    }

    public void setMinOrderPriceRatio(String str) {
        this.minOrderPriceRatio = str;
    }

    public String toString() {
        return "SpotTimeSharingGlobalConfig(data=" + getData() + ", available=" + isAvailable() + ", minInterval=" + getMinInterval() + ", maxInterval=" + getMaxInterval() + ", minOrderPriceRatio=" + getMinOrderPriceRatio() + ", maxOrderPriceRatio=" + getMaxOrderPriceRatio() + ")";
    }
}
