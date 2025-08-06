package com.hbg.lite.index.bean;

import com.hbg.lib.network.otc.core.bean.MarketMergedInfo;
import com.hbg.lite.index.viewhandler.LiteIndexMarketItemHandler;
import java.io.Serializable;
import java.util.List;

public class LiteIndexMarketItem implements s9.a, Serializable {
    private a callback;
    private List<String> detailList;
    private boolean isChinese;
    private boolean isFast;
    private boolean isShowDivider = true;
    private String logoUrl;
    private MarketMergedInfo marketMergedInfo;
    private String name;
    private String shortName;
    private boolean usdShimmer;

    public interface a {
        void a(LiteIndexMarketItem liteIndexMarketItem);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof LiteIndexMarketItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteIndexMarketItem)) {
            return false;
        }
        LiteIndexMarketItem liteIndexMarketItem = (LiteIndexMarketItem) obj;
        if (!liteIndexMarketItem.canEqual(this)) {
            return false;
        }
        MarketMergedInfo marketMergedInfo2 = getMarketMergedInfo();
        MarketMergedInfo marketMergedInfo3 = liteIndexMarketItem.getMarketMergedInfo();
        if (marketMergedInfo2 != null ? !marketMergedInfo2.equals(marketMergedInfo3) : marketMergedInfo3 != null) {
            return false;
        }
        String logoUrl2 = getLogoUrl();
        String logoUrl3 = liteIndexMarketItem.getLogoUrl();
        if (logoUrl2 != null ? !logoUrl2.equals(logoUrl3) : logoUrl3 != null) {
            return false;
        }
        String shortName2 = getShortName();
        String shortName3 = liteIndexMarketItem.getShortName();
        if (shortName2 != null ? !shortName2.equals(shortName3) : shortName3 != null) {
            return false;
        }
        String name2 = getName();
        String name3 = liteIndexMarketItem.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        a callback2 = getCallback();
        a callback3 = liteIndexMarketItem.getCallback();
        if (callback2 != null ? !callback2.equals(callback3) : callback3 != null) {
            return false;
        }
        List<String> detailList2 = getDetailList();
        List<String> detailList3 = liteIndexMarketItem.getDetailList();
        if (detailList2 != null ? detailList2.equals(detailList3) : detailList3 == null) {
            return isChinese() == liteIndexMarketItem.isChinese() && isUsdShimmer() == liteIndexMarketItem.isUsdShimmer() && isFast() == liteIndexMarketItem.isFast() && isShowDivider() == liteIndexMarketItem.isShowDivider();
        }
        return false;
    }

    public a getCallback() {
        return this.callback;
    }

    public List<String> getDetailList() {
        return this.detailList;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public MarketMergedInfo getMarketMergedInfo() {
        return this.marketMergedInfo;
    }

    public String getName() {
        return this.name;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getViewHandlerName() {
        return LiteIndexMarketItemHandler.class.getName();
    }

    public int hashCode() {
        MarketMergedInfo marketMergedInfo2 = getMarketMergedInfo();
        int i11 = 43;
        int hashCode = marketMergedInfo2 == null ? 43 : marketMergedInfo2.hashCode();
        String logoUrl2 = getLogoUrl();
        int hashCode2 = ((hashCode + 59) * 59) + (logoUrl2 == null ? 43 : logoUrl2.hashCode());
        String shortName2 = getShortName();
        int hashCode3 = (hashCode2 * 59) + (shortName2 == null ? 43 : shortName2.hashCode());
        String name2 = getName();
        int hashCode4 = (hashCode3 * 59) + (name2 == null ? 43 : name2.hashCode());
        a callback2 = getCallback();
        int hashCode5 = (hashCode4 * 59) + (callback2 == null ? 43 : callback2.hashCode());
        List<String> detailList2 = getDetailList();
        int i12 = hashCode5 * 59;
        if (detailList2 != null) {
            i11 = detailList2.hashCode();
        }
        int i13 = 79;
        int i14 = (((((((i12 + i11) * 59) + (isChinese() ? 79 : 97)) * 59) + (isUsdShimmer() ? 79 : 97)) * 59) + (isFast() ? 79 : 97)) * 59;
        if (!isShowDivider()) {
            i13 = 97;
        }
        return i14 + i13;
    }

    public boolean isChinese() {
        return this.isChinese;
    }

    public boolean isFast() {
        return this.isFast;
    }

    public boolean isShowDivider() {
        return this.isShowDivider;
    }

    public boolean isUsdShimmer() {
        return this.usdShimmer;
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setChinese(boolean z11) {
        this.isChinese = z11;
    }

    public void setDetailList(List<String> list) {
        this.detailList = list;
    }

    public void setFast(boolean z11) {
        this.isFast = z11;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public void setMarketMergedInfo(MarketMergedInfo marketMergedInfo2) {
        this.marketMergedInfo = marketMergedInfo2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setShortName(String str) {
        this.shortName = str;
    }

    public void setShowDivider(boolean z11) {
        this.isShowDivider = z11;
    }

    public void setUsdShimmer(boolean z11) {
        this.usdShimmer = z11;
    }

    public String toString() {
        return "LiteIndexMarketItem(marketMergedInfo=" + getMarketMergedInfo() + ", logoUrl=" + getLogoUrl() + ", shortName=" + getShortName() + ", name=" + getName() + ", callback=" + getCallback() + ", detailList=" + getDetailList() + ", isChinese=" + isChinese() + ", usdShimmer=" + isUsdShimmer() + ", isFast=" + isFast() + ", isShowDivider=" + isShowDivider() + ")";
    }
}
