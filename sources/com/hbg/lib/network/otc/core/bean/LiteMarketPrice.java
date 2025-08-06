package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class LiteMarketPrice implements Serializable {
    private String change;
    private int currencyId;
    private String price;
    private long time;

    public boolean canEqual(Object obj) {
        return obj instanceof LiteMarketPrice;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteMarketPrice)) {
            return false;
        }
        LiteMarketPrice liteMarketPrice = (LiteMarketPrice) obj;
        if (!liteMarketPrice.canEqual(this)) {
            return false;
        }
        String price2 = getPrice();
        String price3 = liteMarketPrice.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        if (getCurrencyId() != liteMarketPrice.getCurrencyId()) {
            return false;
        }
        String change2 = getChange();
        String change3 = liteMarketPrice.getChange();
        if (change2 != null ? change2.equals(change3) : change3 == null) {
            return getTime() == liteMarketPrice.getTime();
        }
        return false;
    }

    public String getChange() {
        return this.change;
    }

    public int getCurrencyId() {
        return this.currencyId;
    }

    public String getPrice() {
        return this.price;
    }

    public long getTime() {
        return this.time;
    }

    public int hashCode() {
        String price2 = getPrice();
        int i11 = 43;
        int hashCode = (((price2 == null ? 43 : price2.hashCode()) + 59) * 59) + getCurrencyId();
        String change2 = getChange();
        int i12 = hashCode * 59;
        if (change2 != null) {
            i11 = change2.hashCode();
        }
        long time2 = getTime();
        return ((i12 + i11) * 59) + ((int) ((time2 >>> 32) ^ time2));
    }

    public void setChange(String str) {
        this.change = str;
    }

    public void setCurrencyId(int i11) {
        this.currencyId = i11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public String toString() {
        return "LiteMarketPrice(price=" + getPrice() + ", currencyId=" + getCurrencyId() + ", change=" + getChange() + ", time=" + getTime() + ")";
    }
}
