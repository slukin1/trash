package com.hbg.lite.market.bean;

import android.text.TextUtils;
import java.io.Serializable;

public class MarketDetailBean implements Comparable<MarketDetailBean>, Serializable {
    private String price;
    private long time;

    public MarketDetailBean(long j11, String str) {
        this.time = j11;
        this.price = str;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MarketDetailBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketDetailBean)) {
            return false;
        }
        MarketDetailBean marketDetailBean = (MarketDetailBean) obj;
        if (!marketDetailBean.canEqual(this) || getTime() != marketDetailBean.getTime()) {
            return false;
        }
        String price2 = getPrice();
        String price3 = marketDetailBean.getPrice();
        return price2 != null ? price2.equals(price3) : price3 == null;
    }

    public double getDoublePrice() {
        return Double.parseDouble(TextUtils.isEmpty(this.price) ? "0" : this.price);
    }

    public String getPrice() {
        return this.price;
    }

    public long getTime() {
        return this.time;
    }

    public int hashCode() {
        long time2 = getTime();
        String price2 = getPrice();
        return ((((int) (time2 ^ (time2 >>> 32))) + 59) * 59) + (price2 == null ? 43 : price2.hashCode());
    }

    public void setDoublePrice(double d11) {
        this.price = String.valueOf(d11);
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public String toString() {
        return "MarketDetailBean(time=" + getTime() + ", price=" + getPrice() + ")";
    }

    public int compareTo(MarketDetailBean marketDetailBean) {
        return Long.valueOf(this.time).compareTo(Long.valueOf(marketDetailBean.getTime()));
    }
}
