package com.hbg.lib.network.hbg.grid.bean;

import java.io.Serializable;

public class GridStrategyInfo implements Serializable {
    private int copyNum;
    private String markCode;
    private String maxPrice;
    private String minPrice;
    private long runTime;
    private int runType;
    private String strategyId;
    private String symbol;
    private String totalProfitAmount;
    private String totalProfitRate;

    public boolean canEqual(Object obj) {
        return obj instanceof GridStrategyInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridStrategyInfo)) {
            return false;
        }
        GridStrategyInfo gridStrategyInfo = (GridStrategyInfo) obj;
        if (!gridStrategyInfo.canEqual(this)) {
            return false;
        }
        String strategyId2 = getStrategyId();
        String strategyId3 = gridStrategyInfo.getStrategyId();
        if (strategyId2 != null ? !strategyId2.equals(strategyId3) : strategyId3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = gridStrategyInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String totalProfitAmount2 = getTotalProfitAmount();
        String totalProfitAmount3 = gridStrategyInfo.getTotalProfitAmount();
        if (totalProfitAmount2 != null ? !totalProfitAmount2.equals(totalProfitAmount3) : totalProfitAmount3 != null) {
            return false;
        }
        if (getRunTime() != gridStrategyInfo.getRunTime() || getRunType() != gridStrategyInfo.getRunType() || getCopyNum() != gridStrategyInfo.getCopyNum()) {
            return false;
        }
        String totalProfitRate2 = getTotalProfitRate();
        String totalProfitRate3 = gridStrategyInfo.getTotalProfitRate();
        if (totalProfitRate2 != null ? !totalProfitRate2.equals(totalProfitRate3) : totalProfitRate3 != null) {
            return false;
        }
        String minPrice2 = getMinPrice();
        String minPrice3 = gridStrategyInfo.getMinPrice();
        if (minPrice2 != null ? !minPrice2.equals(minPrice3) : minPrice3 != null) {
            return false;
        }
        String maxPrice2 = getMaxPrice();
        String maxPrice3 = gridStrategyInfo.getMaxPrice();
        if (maxPrice2 != null ? !maxPrice2.equals(maxPrice3) : maxPrice3 != null) {
            return false;
        }
        String markCode2 = getMarkCode();
        String markCode3 = gridStrategyInfo.getMarkCode();
        return markCode2 != null ? markCode2.equals(markCode3) : markCode3 == null;
    }

    public int getCopyNum() {
        return this.copyNum;
    }

    public String getMarkCode() {
        return this.markCode;
    }

    public String getMaxPrice() {
        return this.maxPrice;
    }

    public String getMinPrice() {
        return this.minPrice;
    }

    public long getRunTime() {
        return this.runTime;
    }

    public int getRunType() {
        return this.runType;
    }

    public String getStrategyId() {
        return this.strategyId;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTotalProfitAmount() {
        return this.totalProfitAmount;
    }

    public String getTotalProfitRate() {
        return this.totalProfitRate;
    }

    public int hashCode() {
        String strategyId2 = getStrategyId();
        int i11 = 43;
        int hashCode = strategyId2 == null ? 43 : strategyId2.hashCode();
        String symbol2 = getSymbol();
        int hashCode2 = ((hashCode + 59) * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String totalProfitAmount2 = getTotalProfitAmount();
        int hashCode3 = (hashCode2 * 59) + (totalProfitAmount2 == null ? 43 : totalProfitAmount2.hashCode());
        long runTime2 = getRunTime();
        int runType2 = (((((hashCode3 * 59) + ((int) (runTime2 ^ (runTime2 >>> 32)))) * 59) + getRunType()) * 59) + getCopyNum();
        String totalProfitRate2 = getTotalProfitRate();
        int hashCode4 = (runType2 * 59) + (totalProfitRate2 == null ? 43 : totalProfitRate2.hashCode());
        String minPrice2 = getMinPrice();
        int hashCode5 = (hashCode4 * 59) + (minPrice2 == null ? 43 : minPrice2.hashCode());
        String maxPrice2 = getMaxPrice();
        int hashCode6 = (hashCode5 * 59) + (maxPrice2 == null ? 43 : maxPrice2.hashCode());
        String markCode2 = getMarkCode();
        int i12 = hashCode6 * 59;
        if (markCode2 != null) {
            i11 = markCode2.hashCode();
        }
        return i12 + i11;
    }

    public void setCopyNum(int i11) {
        this.copyNum = i11;
    }

    public void setMarkCode(String str) {
        this.markCode = str;
    }

    public void setMaxPrice(String str) {
        this.maxPrice = str;
    }

    public void setMinPrice(String str) {
        this.minPrice = str;
    }

    public void setRunTime(long j11) {
        this.runTime = j11;
    }

    public void setRunType(int i11) {
        this.runType = i11;
    }

    public void setStrategyId(String str) {
        this.strategyId = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTotalProfitAmount(String str) {
        this.totalProfitAmount = str;
    }

    public void setTotalProfitRate(String str) {
        this.totalProfitRate = str;
    }

    public String toString() {
        return "GridStrategyInfo(strategyId=" + getStrategyId() + ", symbol=" + getSymbol() + ", totalProfitAmount=" + getTotalProfitAmount() + ", runTime=" + getRunTime() + ", runType=" + getRunType() + ", copyNum=" + getCopyNum() + ", totalProfitRate=" + getTotalProfitRate() + ", minPrice=" + getMinPrice() + ", maxPrice=" + getMaxPrice() + ", markCode=" + getMarkCode() + ")";
    }
}
