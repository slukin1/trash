package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcU1000ActivityBean implements Serializable {
    private int advertiseDays;
    private long date;
    private int itemTag;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcU1000ActivityBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcU1000ActivityBean)) {
            return false;
        }
        OtcU1000ActivityBean otcU1000ActivityBean = (OtcU1000ActivityBean) obj;
        return otcU1000ActivityBean.canEqual(this) && getDate() == otcU1000ActivityBean.getDate() && getItemTag() == otcU1000ActivityBean.getItemTag() && getAdvertiseDays() == otcU1000ActivityBean.getAdvertiseDays();
    }

    public int getAdvertiseDays() {
        return this.advertiseDays;
    }

    public long getDate() {
        return this.date;
    }

    public int getItemTag() {
        return this.itemTag;
    }

    public int hashCode() {
        long date2 = getDate();
        return ((((((int) (date2 ^ (date2 >>> 32))) + 59) * 59) + getItemTag()) * 59) + getAdvertiseDays();
    }

    public void setAdvertiseDays(int i11) {
        this.advertiseDays = i11;
    }

    public void setDate(long j11) {
        this.date = j11;
    }

    public void setItemTag(int i11) {
        this.itemTag = i11;
    }

    public String toString() {
        return "OtcU1000ActivityBean(date=" + getDate() + ", itemTag=" + getItemTag() + ", advertiseDays=" + getAdvertiseDays() + ")";
    }
}
