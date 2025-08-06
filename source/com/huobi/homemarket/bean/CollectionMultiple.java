package com.huobi.homemarket.bean;

import java.io.Serializable;

public class CollectionMultiple implements Serializable {
    private String tradingPair;
    private String website;

    public CollectionMultiple() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof CollectionMultiple;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectionMultiple)) {
            return false;
        }
        CollectionMultiple collectionMultiple = (CollectionMultiple) obj;
        if (!collectionMultiple.canEqual(this)) {
            return false;
        }
        String website2 = getWebsite();
        String website3 = collectionMultiple.getWebsite();
        if (website2 != null ? !website2.equals(website3) : website3 != null) {
            return false;
        }
        String tradingPair2 = getTradingPair();
        String tradingPair3 = collectionMultiple.getTradingPair();
        return tradingPair2 != null ? tradingPair2.equals(tradingPair3) : tradingPair3 == null;
    }

    public String getTradingPair() {
        return this.tradingPair;
    }

    public String getWebsite() {
        return this.website;
    }

    public int hashCode() {
        String website2 = getWebsite();
        int i11 = 43;
        int hashCode = website2 == null ? 43 : website2.hashCode();
        String tradingPair2 = getTradingPair();
        int i12 = (hashCode + 59) * 59;
        if (tradingPair2 != null) {
            i11 = tradingPair2.hashCode();
        }
        return i12 + i11;
    }

    public void setTradingPair(String str) {
        this.tradingPair = str;
    }

    public void setWebsite(String str) {
        this.website = str;
    }

    public String toString() {
        return "CollectionMultiple(website=" + getWebsite() + ", tradingPair=" + getTradingPair() + ")";
    }

    public CollectionMultiple(String str, String str2) {
        this.website = str;
        this.tradingPair = str2;
    }
}
