package com.huobi.homemarket.bean;

import java.io.Serializable;

public class MarketCoinThirdTabClick implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private Long f72585id;
    private String mCurrentQuoteTab;

    public MarketCoinThirdTabClick(Long l11, String str) {
        this.f72585id = l11;
        this.mCurrentQuoteTab = str;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MarketCoinThirdTabClick;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketCoinThirdTabClick)) {
            return false;
        }
        MarketCoinThirdTabClick marketCoinThirdTabClick = (MarketCoinThirdTabClick) obj;
        if (!marketCoinThirdTabClick.canEqual(this)) {
            return false;
        }
        Long id2 = getId();
        Long id3 = marketCoinThirdTabClick.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String mCurrentQuoteTab2 = getMCurrentQuoteTab();
        String mCurrentQuoteTab3 = marketCoinThirdTabClick.getMCurrentQuoteTab();
        return mCurrentQuoteTab2 != null ? mCurrentQuoteTab2.equals(mCurrentQuoteTab3) : mCurrentQuoteTab3 == null;
    }

    public Long getId() {
        return this.f72585id;
    }

    public String getMCurrentQuoteTab() {
        return this.mCurrentQuoteTab;
    }

    public int hashCode() {
        Long id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        String mCurrentQuoteTab2 = getMCurrentQuoteTab();
        int i12 = (hashCode + 59) * 59;
        if (mCurrentQuoteTab2 != null) {
            i11 = mCurrentQuoteTab2.hashCode();
        }
        return i12 + i11;
    }

    public void setId(Long l11) {
        this.f72585id = l11;
    }

    public void setMCurrentQuoteTab(String str) {
        this.mCurrentQuoteTab = str;
    }

    public String toString() {
        return "MarketCoinThirdTabClick(id=" + getId() + ", mCurrentQuoteTab=" + getMCurrentQuoteTab() + ")";
    }
}
