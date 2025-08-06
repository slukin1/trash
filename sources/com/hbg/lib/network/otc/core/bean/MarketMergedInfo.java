package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class MarketMergedInfo implements Serializable {
    private String change;
    private int coinId;
    private int currencyId;
    private List<String> merged;
    private String price;

    public boolean canEqual(Object obj) {
        return obj instanceof MarketMergedInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketMergedInfo)) {
            return false;
        }
        MarketMergedInfo marketMergedInfo = (MarketMergedInfo) obj;
        if (!marketMergedInfo.canEqual(this)) {
            return false;
        }
        String price2 = getPrice();
        String price3 = marketMergedInfo.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String change2 = getChange();
        String change3 = marketMergedInfo.getChange();
        if (change2 != null ? !change2.equals(change3) : change3 != null) {
            return false;
        }
        List<String> merged2 = getMerged();
        List<String> merged3 = marketMergedInfo.getMerged();
        if (merged2 != null ? merged2.equals(merged3) : merged3 == null) {
            return getCoinId() == marketMergedInfo.getCoinId() && getCurrencyId() == marketMergedInfo.getCurrencyId();
        }
        return false;
    }

    public String getChange() {
        return this.change;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public int getCurrencyId() {
        return this.currencyId;
    }

    public List<String> getMerged() {
        return this.merged;
    }

    public String getPrice() {
        return this.price;
    }

    public int hashCode() {
        String price2 = getPrice();
        int i11 = 43;
        int hashCode = price2 == null ? 43 : price2.hashCode();
        String change2 = getChange();
        int hashCode2 = ((hashCode + 59) * 59) + (change2 == null ? 43 : change2.hashCode());
        List<String> merged2 = getMerged();
        int i12 = hashCode2 * 59;
        if (merged2 != null) {
            i11 = merged2.hashCode();
        }
        return ((((i12 + i11) * 59) + getCoinId()) * 59) + getCurrencyId();
    }

    public void setChange(String str) {
        this.change = str;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setCurrencyId(int i11) {
        this.currencyId = i11;
    }

    public void setMerged(List<String> list) {
        this.merged = list;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String toString() {
        return "MarketMergedInfo(price=" + getPrice() + ", change=" + getChange() + ", merged=" + getMerged() + ", coinId=" + getCoinId() + ", currencyId=" + getCurrencyId() + ")";
    }
}
