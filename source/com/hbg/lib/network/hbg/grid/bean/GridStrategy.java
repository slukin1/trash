package com.hbg.lib.network.hbg.grid.bean;

import java.io.Serializable;

public class GridStrategy implements Serializable {
    public static final int STATUS_CLOSING = 3;
    public static final int STATUS_CREATED = 2;
    public static final int STATUS_CREATING = 1;
    public static final int STATUS_FAIL = 7;
    public static final int STATUS_LOSS_CLOSE = 6;
    public static final int STATUS_MANUAL_CLOSE = 4;
    public static final int STATUS_PROFIT_CLOSE = 5;
    private static final long serialVersionUID = 7997172430931429139L;
    private String baseCurrency;
    private long createAt;
    private String floatProfitAmount;
    private int gridNum;
    private String gridProfitAmount;

    /* renamed from: id  reason: collision with root package name */
    private long f70282id;
    private String investAmount;
    private String maxPrice;
    private String minPrice;
    private String name;
    private String quoteCurrency;
    private long runTime;
    private int status;
    private String stopLossPrice;
    private String stopProfitPrice;
    private String symbol;
    private String totalProfit;
    private String totalProfitRate;
    private String totalYieldRate;
    private int tradeNum;

    public boolean canEqual(Object obj) {
        return obj instanceof GridStrategy;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridStrategy)) {
            return false;
        }
        GridStrategy gridStrategy = (GridStrategy) obj;
        if (!gridStrategy.canEqual(this) || getId() != gridStrategy.getId()) {
            return false;
        }
        String name2 = getName();
        String name3 = gridStrategy.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = gridStrategy.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = gridStrategy.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = gridStrategy.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String investAmount2 = getInvestAmount();
        String investAmount3 = gridStrategy.getInvestAmount();
        if (investAmount2 != null ? !investAmount2.equals(investAmount3) : investAmount3 != null) {
            return false;
        }
        if (getCreateAt() != gridStrategy.getCreateAt()) {
            return false;
        }
        String minPrice2 = getMinPrice();
        String minPrice3 = gridStrategy.getMinPrice();
        if (minPrice2 != null ? !minPrice2.equals(minPrice3) : minPrice3 != null) {
            return false;
        }
        String maxPrice2 = getMaxPrice();
        String maxPrice3 = gridStrategy.getMaxPrice();
        if (maxPrice2 != null ? !maxPrice2.equals(maxPrice3) : maxPrice3 != null) {
            return false;
        }
        if (getGridNum() != gridStrategy.getGridNum()) {
            return false;
        }
        String stopProfitPrice2 = getStopProfitPrice();
        String stopProfitPrice3 = gridStrategy.getStopProfitPrice();
        if (stopProfitPrice2 != null ? !stopProfitPrice2.equals(stopProfitPrice3) : stopProfitPrice3 != null) {
            return false;
        }
        String stopLossPrice2 = getStopLossPrice();
        String stopLossPrice3 = gridStrategy.getStopLossPrice();
        if (stopLossPrice2 != null ? !stopLossPrice2.equals(stopLossPrice3) : stopLossPrice3 != null) {
            return false;
        }
        String totalProfit2 = getTotalProfit();
        String totalProfit3 = gridStrategy.getTotalProfit();
        if (totalProfit2 != null ? !totalProfit2.equals(totalProfit3) : totalProfit3 != null) {
            return false;
        }
        String totalProfitRate2 = getTotalProfitRate();
        String totalProfitRate3 = gridStrategy.getTotalProfitRate();
        if (totalProfitRate2 != null ? !totalProfitRate2.equals(totalProfitRate3) : totalProfitRate3 != null) {
            return false;
        }
        String floatProfitAmount2 = getFloatProfitAmount();
        String floatProfitAmount3 = gridStrategy.getFloatProfitAmount();
        if (floatProfitAmount2 != null ? !floatProfitAmount2.equals(floatProfitAmount3) : floatProfitAmount3 != null) {
            return false;
        }
        String gridProfitAmount2 = getGridProfitAmount();
        String gridProfitAmount3 = gridStrategy.getGridProfitAmount();
        if (gridProfitAmount2 != null ? !gridProfitAmount2.equals(gridProfitAmount3) : gridProfitAmount3 != null) {
            return false;
        }
        String totalYieldRate2 = getTotalYieldRate();
        String totalYieldRate3 = gridStrategy.getTotalYieldRate();
        if (totalYieldRate2 != null ? totalYieldRate2.equals(totalYieldRate3) : totalYieldRate3 == null) {
            return getTradeNum() == gridStrategy.getTradeNum() && getStatus() == gridStrategy.getStatus() && getRunTime() == gridStrategy.getRunTime();
        }
        return false;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public long getCreateAt() {
        return this.createAt;
    }

    public String getFloatProfitAmount() {
        return this.floatProfitAmount;
    }

    public int getGridNum() {
        return this.gridNum;
    }

    public String getGridProfitAmount() {
        return this.gridProfitAmount;
    }

    public long getId() {
        return this.f70282id;
    }

    public String getInvestAmount() {
        return this.investAmount;
    }

    public String getMaxPrice() {
        return this.maxPrice;
    }

    public String getMinPrice() {
        return this.minPrice;
    }

    public String getName() {
        return this.name;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public long getRunTime() {
        return this.runTime;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStopLossPrice() {
        return this.stopLossPrice;
    }

    public String getStopProfitPrice() {
        return this.stopProfitPrice;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTotalProfit() {
        return this.totalProfit;
    }

    public String getTotalProfitRate() {
        return this.totalProfitRate;
    }

    public String getTotalYieldRate() {
        return this.totalYieldRate;
    }

    public int getTradeNum() {
        return this.tradeNum;
    }

    public int hashCode() {
        long id2 = getId();
        String name2 = getName();
        int i11 = 43;
        int hashCode = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
        String symbol2 = getSymbol();
        int hashCode2 = (hashCode * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode3 = (hashCode2 * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String baseCurrency2 = getBaseCurrency();
        int hashCode4 = (hashCode3 * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String investAmount2 = getInvestAmount();
        int i12 = hashCode4 * 59;
        int hashCode5 = investAmount2 == null ? 43 : investAmount2.hashCode();
        long createAt2 = getCreateAt();
        int i13 = ((i12 + hashCode5) * 59) + ((int) (createAt2 ^ (createAt2 >>> 32)));
        String minPrice2 = getMinPrice();
        int hashCode6 = (i13 * 59) + (minPrice2 == null ? 43 : minPrice2.hashCode());
        String maxPrice2 = getMaxPrice();
        int hashCode7 = (((hashCode6 * 59) + (maxPrice2 == null ? 43 : maxPrice2.hashCode())) * 59) + getGridNum();
        String stopProfitPrice2 = getStopProfitPrice();
        int hashCode8 = (hashCode7 * 59) + (stopProfitPrice2 == null ? 43 : stopProfitPrice2.hashCode());
        String stopLossPrice2 = getStopLossPrice();
        int hashCode9 = (hashCode8 * 59) + (stopLossPrice2 == null ? 43 : stopLossPrice2.hashCode());
        String totalProfit2 = getTotalProfit();
        int hashCode10 = (hashCode9 * 59) + (totalProfit2 == null ? 43 : totalProfit2.hashCode());
        String totalProfitRate2 = getTotalProfitRate();
        int hashCode11 = (hashCode10 * 59) + (totalProfitRate2 == null ? 43 : totalProfitRate2.hashCode());
        String floatProfitAmount2 = getFloatProfitAmount();
        int hashCode12 = (hashCode11 * 59) + (floatProfitAmount2 == null ? 43 : floatProfitAmount2.hashCode());
        String gridProfitAmount2 = getGridProfitAmount();
        int hashCode13 = (hashCode12 * 59) + (gridProfitAmount2 == null ? 43 : gridProfitAmount2.hashCode());
        String totalYieldRate2 = getTotalYieldRate();
        int i14 = hashCode13 * 59;
        if (totalYieldRate2 != null) {
            i11 = totalYieldRate2.hashCode();
        }
        int tradeNum2 = ((((i14 + i11) * 59) + getTradeNum()) * 59) + getStatus();
        long runTime2 = getRunTime();
        return (tradeNum2 * 59) + ((int) ((runTime2 >>> 32) ^ runTime2));
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setCreateAt(long j11) {
        this.createAt = j11;
    }

    public void setFloatProfitAmount(String str) {
        this.floatProfitAmount = str;
    }

    public void setGridNum(int i11) {
        this.gridNum = i11;
    }

    public void setGridProfitAmount(String str) {
        this.gridProfitAmount = str;
    }

    public void setId(long j11) {
        this.f70282id = j11;
    }

    public void setInvestAmount(String str) {
        this.investAmount = str;
    }

    public void setMaxPrice(String str) {
        this.maxPrice = str;
    }

    public void setMinPrice(String str) {
        this.minPrice = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setRunTime(long j11) {
        this.runTime = j11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setStopLossPrice(String str) {
        this.stopLossPrice = str;
    }

    public void setStopProfitPrice(String str) {
        this.stopProfitPrice = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTotalProfit(String str) {
        this.totalProfit = str;
    }

    public void setTotalProfitRate(String str) {
        this.totalProfitRate = str;
    }

    public void setTotalYieldRate(String str) {
        this.totalYieldRate = str;
    }

    public void setTradeNum(int i11) {
        this.tradeNum = i11;
    }

    public String toString() {
        return "GridStrategy(id=" + getId() + ", name=" + getName() + ", symbol=" + getSymbol() + ", quoteCurrency=" + getQuoteCurrency() + ", baseCurrency=" + getBaseCurrency() + ", investAmount=" + getInvestAmount() + ", createAt=" + getCreateAt() + ", minPrice=" + getMinPrice() + ", maxPrice=" + getMaxPrice() + ", gridNum=" + getGridNum() + ", stopProfitPrice=" + getStopProfitPrice() + ", stopLossPrice=" + getStopLossPrice() + ", totalProfit=" + getTotalProfit() + ", totalProfitRate=" + getTotalProfitRate() + ", floatProfitAmount=" + getFloatProfitAmount() + ", gridProfitAmount=" + getGridProfitAmount() + ", totalYieldRate=" + getTotalYieldRate() + ", tradeNum=" + getTradeNum() + ", status=" + getStatus() + ", runTime=" + getRunTime() + ")";
    }
}
