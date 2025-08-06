package com.huobi.trade.prime.bean;

import java.io.Serializable;

public class AvailableLimit implements Serializable {
    private String currentVolume;
    private String totalVolume;

    public boolean canEqual(Object obj) {
        return obj instanceof AvailableLimit;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AvailableLimit)) {
            return false;
        }
        AvailableLimit availableLimit = (AvailableLimit) obj;
        if (!availableLimit.canEqual(this)) {
            return false;
        }
        String currentVolume2 = getCurrentVolume();
        String currentVolume3 = availableLimit.getCurrentVolume();
        if (currentVolume2 != null ? !currentVolume2.equals(currentVolume3) : currentVolume3 != null) {
            return false;
        }
        String totalVolume2 = getTotalVolume();
        String totalVolume3 = availableLimit.getTotalVolume();
        return totalVolume2 != null ? totalVolume2.equals(totalVolume3) : totalVolume3 == null;
    }

    public String getCurrentVolume() {
        return this.currentVolume;
    }

    public String getTotalVolume() {
        return this.totalVolume;
    }

    public int hashCode() {
        String currentVolume2 = getCurrentVolume();
        int i11 = 43;
        int hashCode = currentVolume2 == null ? 43 : currentVolume2.hashCode();
        String totalVolume2 = getTotalVolume();
        int i12 = (hashCode + 59) * 59;
        if (totalVolume2 != null) {
            i11 = totalVolume2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrentVolume(String str) {
        this.currentVolume = str;
    }

    public void setTotalVolume(String str) {
        this.totalVolume = str;
    }

    public String toString() {
        return "AvailableLimit(currentVolume=" + getCurrentVolume() + ", totalVolume=" + getTotalVolume() + ")";
    }
}
