package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class GridAssetItem implements Serializable {
    private String currency;
    private String estimateBalance;

    /* renamed from: id  reason: collision with root package name */
    private String f70240id;
    private String strategyType;
    private String totalProfit;

    public boolean canEqual(Object obj) {
        return obj instanceof GridAssetItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridAssetItem)) {
            return false;
        }
        GridAssetItem gridAssetItem = (GridAssetItem) obj;
        if (!gridAssetItem.canEqual(this)) {
            return false;
        }
        String id2 = getId();
        String id3 = gridAssetItem.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = gridAssetItem.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String totalProfit2 = getTotalProfit();
        String totalProfit3 = gridAssetItem.getTotalProfit();
        if (totalProfit2 != null ? !totalProfit2.equals(totalProfit3) : totalProfit3 != null) {
            return false;
        }
        String estimateBalance2 = getEstimateBalance();
        String estimateBalance3 = gridAssetItem.getEstimateBalance();
        if (estimateBalance2 != null ? !estimateBalance2.equals(estimateBalance3) : estimateBalance3 != null) {
            return false;
        }
        String strategyType2 = getStrategyType();
        String strategyType3 = gridAssetItem.getStrategyType();
        return strategyType2 != null ? strategyType2.equals(strategyType3) : strategyType3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getEstimateBalance() {
        return this.estimateBalance;
    }

    public String getId() {
        return this.f70240id;
    }

    public String getStrategyType() {
        return this.strategyType;
    }

    public String getTotalProfit() {
        return this.totalProfit;
    }

    public int hashCode() {
        String id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        String currency2 = getCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String totalProfit2 = getTotalProfit();
        int hashCode3 = (hashCode2 * 59) + (totalProfit2 == null ? 43 : totalProfit2.hashCode());
        String estimateBalance2 = getEstimateBalance();
        int hashCode4 = (hashCode3 * 59) + (estimateBalance2 == null ? 43 : estimateBalance2.hashCode());
        String strategyType2 = getStrategyType();
        int i12 = hashCode4 * 59;
        if (strategyType2 != null) {
            i11 = strategyType2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setEstimateBalance(String str) {
        this.estimateBalance = str;
    }

    public void setId(String str) {
        this.f70240id = str;
    }

    public void setStrategyType(String str) {
        this.strategyType = str;
    }

    public void setTotalProfit(String str) {
        this.totalProfit = str;
    }

    public String toString() {
        return "GridAssetItem(id=" + getId() + ", currency=" + getCurrency() + ", totalProfit=" + getTotalProfit() + ", estimateBalance=" + getEstimateBalance() + ", strategyType=" + getStrategyType() + ")";
    }
}
